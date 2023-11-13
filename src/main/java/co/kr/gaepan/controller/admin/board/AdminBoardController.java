package co.kr.gaepan.controller.admin.board;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.service.admin.AdminBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/board/*")
@RequiredArgsConstructor
@Log4j2
public class AdminBoardController {

    private final AdminBoardService adminBoardService;

    @GetMapping("/list")
    public String list(@RequestParam("group") String group, Model model) {
        List<GP_AdminBoardDTO> adminBoardList = null;
        try {
            adminBoardList = adminBoardService.findAll(group);
//            log.info("admin board list : {}", adminBoardList);
        } catch (Exception e) {
            log.error("admin board list error", e.getMessage());
            throw new RuntimeException(e);
        }
        model.addAttribute("adminBoardList", adminBoardList);
        model.addAttribute("group", group);
        return "admin/board/list";
    }

    @GetMapping("/view")
    public String findById(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model, int bno) {
        try {
            // 여기에서 GaePan 쿠키가 있을 때만 실행하게 해야되네..
            adminBoardService.updateViewCnt(request, response, bno);

            GP_AdminBoardDTO adminBoardDTO = adminBoardService.findById(bno);
            model.addAttribute("adminBoardDTO", adminBoardDTO);
        } catch (Exception e) {
            log.error("admin board view error", e.getMessage());
            throw new RuntimeException(e);
        }

        return "admin/board/view";
    }

}
