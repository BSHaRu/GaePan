package co.kr.gaepan.controller.member;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequestMapping("/member/*")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model, String success) {
        log.info("success : "+ success);
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

    @PostMapping("/register")
    public String register(MemberDTO dto) {

        String rawPw = "";
        String encodePw = "";

        rawPw = dto.getPass1();
        encodePw = passwordEncoder.encode(rawPw);
        dto.setPass1(encodePw);

        log.info("dto" + dto);
        service.registerUser(dto);
        return "member/login";
    }

}
