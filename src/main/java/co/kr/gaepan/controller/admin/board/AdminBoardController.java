package co.kr.gaepan.controller.admin.board;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.service.admin.AdminBoardCateService;
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

    @GetMapping("/write")
    public String write(){

        return "admin/board/write";
    }

    @PostMapping("/write")
    public String write(GP_AdminBoardDTO dto){
        
        return "redirect:/list";
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
                           Model model, int bno) {
        try {
            // todo 여기에서 GaePan 쿠키가 있을 때만 실행하게 해야되네..
            adminBoardService.updateViewCnt(request, response, bno);

            GP_AdminBoardDTO adminBoardDTO = adminBoardService.findById(bno);
            model.addAttribute("adminBoardDTO", adminBoardDTO);
        } catch (Exception e) {
            log.error("admin board view error", e.getMessage());
            throw new RuntimeException(e);
        }

        return "admin/board/view";
    }

    @GetMapping("/list/{group}/{cate}")
    public String getCate(String group, int cate){
        log.info("group" + group);
        log.info("cate" + cate);
        try {
            List<GP_AdminBoardDTO> boardList = adminBoardCateService.getCate(group, cate);
            log.info("admin board getCate : " + boardList);
        } catch (Exception e) {
            log.error("admin board getCate Error" + e.getMessage());
            throw new RuntimeException(e);
        }

        return "redirect:/list";
    }

}
