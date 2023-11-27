package co.kr.gaepan.controller.admin.board;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.dto.board.BoardDTO;
import co.kr.gaepan.dto.board.BoardTypeDTO;
import co.kr.gaepan.service.admin.AdminBoardCateService;
import co.kr.gaepan.service.admin.AdminBoardCommentService;
import co.kr.gaepan.service.admin.AdminBoardService;
import co.kr.gaepan.util.SearchCriteria;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.koreate.common.utils.PageMaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/board/*")
@RequiredArgsConstructor
@Log4j2
public class AdminBoardController {

    private final AdminBoardService adminBoardService;
    private final AdminBoardCateService adminBoardCateService;
    private final AdminBoardCommentService adminBoardCommentService;

    @GetMapping("/write")
    public String write(@RequestParam("group") String group,
                        Model model) {
        try {
            List<BoardCateDTO> cateDTO = adminBoardCateService.getCateName(group);
            List<BoardTypeDTO> typeDTO = adminBoardCateService.selectType(cateDTO.get(0).getCate());

            log.info("cateDTO: " + cateDTO);
            log.info("typeDTO: " + typeDTO);

            model.addAttribute("cateDTO", cateDTO);
            model.addAttribute("typeDTO", typeDTO);
            model.addAttribute("group", group);
        } catch (Exception e) {
            log.error("getWriteController error" + e.getMessage());
            throw new RuntimeException(e);
        }
        return "admin/board/write";
    }

    @PostMapping("/write")
    public String write(GP_AdminBoardDTO dto, HttpServletRequest request,
                    @RequestParam("group") String group){
        try {
            String ip = request.getRemoteAddr();
            dto.setRegIP(ip);
            adminBoardService.saveAdminBoard(dto);
        } catch (Exception e) {
            log.error("getWriteController error" + e.getMessage());
            throw new RuntimeException(e);
        }

        return "redirect:list?group="+group;
    }

    @GetMapping("/list")
    public String pagingBoardList(@RequestParam("group") String group,
                                  Model model, SearchCriteria cri)  {
        // board List 출력
        cri.setGroup(group);
        try {
            List<GP_AdminBoardDTO> adminBoardList
                    = adminBoardService.pagingBoardList(cri);
            model.addAttribute("adminBoardList", adminBoardList);

            List<BoardCateDTO> cateDTO = adminBoardCateService.getCateName(group);
            model.addAttribute("cateDTO", cateDTO);

            for (GP_AdminBoardDTO board : adminBoardList) {
                // 각 게시글에 대한 댓글 수를 조회하여 DTO에 설정
                int commentCount = adminBoardCommentService.countComments(board.getBno());
                board.setCommentCount(commentCount >= 0 ? commentCount : 0);
            }
        } catch (Exception e) {
            log.error("admin board list error", e.getMessage());
            throw new RuntimeException(e);
        }

        // 페이징 처리
        try {
            PageMaker pm = adminBoardService.getPageMaker(cri);
            model.addAttribute("pm", pm);
        } catch (Exception e) {
            log.error("admin board pm error", e.getMessage());
            throw new RuntimeException(e);
        }
        model.addAttribute("group", group);

        return "admin/board/list";
    }

    @GetMapping("/view")
    public String findById(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model, GP_AdminBoardDTO dto) {
        try {
            adminBoardService.updateViewCnt(request, response, dto.getBno());

            GP_AdminBoardDTO adminBoardDTO = adminBoardService.findById(dto.getBno());
            model.addAttribute("boardDTO", adminBoardDTO);

            List<GP_AdminBoardDTO> comments = adminBoardCommentService.findComments(dto);
            model.addAttribute("comments", comments);
//            log.info("admin board findById comments : " + comments);
        } catch (Exception e) {
            log.error("admin board view error", e.getMessage());
            throw new RuntimeException(e);
        }
        return "admin/board/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("group") String group,
                         Model model, int bno){

        try {
            List<BoardCateDTO> cateDTO = adminBoardCateService.getCateName(group);
            List<BoardTypeDTO> typeDTO = adminBoardCateService.selectType(cateDTO.get(0).getCate());
            GP_AdminBoardDTO boardDTO = adminBoardService.findById(bno);

            log.info("cateDTO: " + cateDTO);
            log.info("typeDTO: " + typeDTO);

            model.addAttribute("cateDTO", cateDTO);
            model.addAttribute("typeDTO", typeDTO);
            model.addAttribute("boardDTO", boardDTO);
        } catch (Exception e) {
            log.error("getModifyController error" + e.getMessage());
            throw new RuntimeException(e);
        }
        return "admin/board/modify";
    }

    @PostMapping("/modify")
    public String modify(GP_AdminBoardDTO dto,
                         @RequestParam("bno") int bno){
        log.info("modify bno:" + bno);
        try {
            adminBoardService.modifyAdminBoard(dto);
        } catch (Exception e) {
            log.error("PostModifyController error" + e.getMessage());
            throw new RuntimeException(e);
        }
        return "redirect:view?bno=" + bno;
    }


    @PostMapping("/commentWrite")
    public String commentWrite(GP_AdminBoardDTO dto, HttpServletRequest request,
                            @RequestParam("bno") int parent){
        log.info("처음 parent : " + parent);
        try {
            String ip = request.getRemoteAddr();
            dto.setRegIP(ip);

            adminBoardCommentService.saveComment(dto);
/*            log.info("dto group:" + dto.getGroup());
            log.info("dto cate : "+ dto.getCate());
            log.info("dto type:" + dto.getType());
            log.info("dto comment : "+ dto.getComment());
            log.info("dto parent:" + dto.getParent());*/

        } catch (Exception e) {
            log.error("getWriteController error" + e.getMessage());
            throw new RuntimeException(e);
        }
        return "redirect:view?bno=" + parent;
    }


}
