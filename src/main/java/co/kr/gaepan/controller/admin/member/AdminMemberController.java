package co.kr.gaepan.controller.admin.member;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.service.admin.AdminMemberService;
import co.kr.gaepan.util.SearchCriteria;
import co.kr.gaepan.util.SearchPageMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.koreate.common.utils.PageMaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/member/*")
@Controller
@RequiredArgsConstructor
@Log4j2
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

/*    @GetMapping("/members")
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
    }*/
    @GetMapping("/members")
    public String index(Model model, SearchCriteria cri) {
        try {
            List<MemberDTO> memberDTOList = adminMemberService.pagingMemberList(cri);
//            log.info("admin member list : {}", memberDTOList);
            model.addAttribute("memberDTO", memberDTOList);
        } catch (Exception e) {
            log.error("admin member list error", e.getMessage());
            throw new RuntimeException(e);
        }
        // 페이징 처리
        try {
            PageMaker pm = adminMemberService.getPageMaker(cri);
            model.addAttribute("pm", pm);
//            SearchPageMaker spm = adminMemberService.getSearchPageMaker(cri);
        } catch (Exception e) {
            log.error("admin board pm error", e.getMessage());
            throw new RuntimeException(e);
        }

        return "admin/member/members";
    }

    @GetMapping("/black")
    public String black(@RequestParam("type") int type, Model model) {
        List<MemberDTO> memberDTOList = null;
        try {
            memberDTOList = adminMemberService.blackList(type);
        } catch (Exception e) {
            log.error("admin member list error", e.getMessage());
            throw new RuntimeException(e);
        }
        model.addAttribute("memberDTO", memberDTOList);
        return "admin/member/black";
    }
}
