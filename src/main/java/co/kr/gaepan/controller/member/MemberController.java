package co.kr.gaepan.controller.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequestMapping("/member/*")
@Controller
public class MemberController {

    @GetMapping("/login")
    public String login(Model model, String success) {
        log.info("success : "+success);
        model.addAttribute("success",success);
        return "member/login";
    }

    @GetMapping("/policy")
    public String policy(){
        return "member/policy";
    }

    @GetMapping("/register")
    public String register() {
        return "member/register";
    }

}
