package co.kr.gaepan.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my/*")
public class MyApplyListController {

    @GetMapping("/applylist")
    public String view(Model model, String pg, Authentication authentication) {

        // 사용자 로그인 정보에서 UID 가져오기
        String currentUserUid = null;
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                currentUserUid = ((UserDetails) principal).getUsername();
            }
        }
        // 페이징 처리
        int currentPage = myAdoptApplyListService.getCurrentPage(pg);
        log.info("currentPage : " + currentPage);
        int start = myAdoptApplyListService.getStartNum(currentPage);
        log.info("start : " + start);
        int total = myAdoptApplyListService.selectApplyListCountTotal(currentUserUid);
        log.info("total : " + total);
        int lastPageNum = myAdoptApplyListService.getLastPageNum(total);
        log.info("lastPageNum : " + lastPageNum);
        int[] result = myAdoptApplyListService.getPageGroupNum(currentPage, lastPageNum);
        log.info("result : " + Arrays.toString(result));
        int pageStartNum = myAdoptApplyListService.getPageStartNum(currentPage, lastPageNum);
        log.info("pageStartNum : " + pageStartNum);

        List<PetAdoptApplyDTO> applyList = myAdoptApplyListService.applyAll(currentUserUid, start);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("total", total);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);

        model.addAttribute("applyList", applyList);
        return "my/applylist";
    }
}
