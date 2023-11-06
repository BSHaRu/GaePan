package co.kr.gaepan.controller.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/member/*")
@Controller
public class AdminMemberController {

    @GetMapping("/member")
    public String index() {
        return "admin/member/member";
    }

    @GetMapping("/black")
    public String black() {
        return "admin/member/black";
    }
}
