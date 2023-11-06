package co.kr.gaepan.controller.admin.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board/*")
public class AdminBoardController {

    @GetMapping("/ad_notice")
    public String ad_notice() {
        return "admin/board/ad_notice";
    }

    @GetMapping("/ad_faq")
    public String ad_faq() {
        return "admin/board/ad_faq";
    }

    @GetMapping("/ad_qna")
    public String ad_qna() {
        return "admin/board/ad_qna";
    }
}
