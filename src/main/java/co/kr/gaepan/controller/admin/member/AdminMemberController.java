package co.kr.gaepan.controller.admin.member;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.service.admin.AdminMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/member/*")
@Controller
@RequiredArgsConstructor
@Log4j2
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @GetMapping("/members")
    public String index(Model model) {
        List<MemberDTO> memberDTOList = null;
        try {
            memberDTOList = adminMemberService.findAll();
//            log.info("admin member list : {}", memberDTOList);
        } catch (Exception e) {
            log.error("admin member list error", e.getMessage());
            throw new RuntimeException(e);
        }
        model.addAttribute("memberDTO", memberDTOList);

        return "admin/member/members";
    }

    @PostMapping("/blackListCheck")
    public String blackListCheck(){

        return "redirect:/member/members";
    }

    @GetMapping("/black")
    public String black() {
        return "admin/member/black";
    }
}
