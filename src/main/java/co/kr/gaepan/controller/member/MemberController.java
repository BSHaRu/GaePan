package co.kr.gaepan.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member/*")
@Controller
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
    @GetMapping("/register")
    public String register() {
        return "member/register";
    }

}
