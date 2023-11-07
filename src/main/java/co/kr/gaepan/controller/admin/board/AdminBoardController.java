package co.kr.gaepan.controller.admin.board;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.service.admin.impl.AdminBoardServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/board/*")
@RequiredArgsConstructor
@Log4j2
public class AdminBoardController {

    private final AdminBoardServiceImpl adminBoardService;

    @GetMapping("/ad_notice/noticeList")
    public String ad_notice(Model model) {
        try {
            List<GP_AdminBoardDTO> adminBoardList = adminBoardService.findAll();
            model.addAttribute("adminBoardList", adminBoardList);
            log.info("Admin Notice List : " + adminBoardList);
        } catch (Exception e) {
            log.error("Admin Notice List error : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return "admin/board/ad_notice/noticeList";
    }


    @GetMapping("/ad_notice/noticeView")
    public String findById(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model, int bno) {
        try {
            adminBoardService.updateViewCnt(request, response, bno);

            GP_AdminBoardDTO adminBoardDTO = adminBoardService.findById(bno);
            model.addAttribute("adminBoardDTO", adminBoardDTO);
        } catch (Exception e) {
            log.error("Admin Notice View error : " + e.getMessage());
            throw new RuntimeException(e);
        }

        return "admin/board/ad_notice/noticeView";
    }


    @GetMapping("/ad_faq/faqList")
    public String ad_faq() {
        return "admin/board/ad_faq/faqList";
    }

    @GetMapping("/ad_qna/qnaList")
    public String ad_qna() {
        return "admin/board/ad_qna/qnaList";
    }
}
