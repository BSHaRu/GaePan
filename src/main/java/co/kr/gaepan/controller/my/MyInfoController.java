package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.security.MyUserDetails;
import co.kr.gaepan.service.my.MyInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/my/*")
@Log4j2
public class MyInfoController {

    @Autowired
    private MyInfoService infoService;

    @GetMapping("/info")
    public String view(Model model) {
        try {
            // 현재 사용자의 Authentication 객체를 가져옴
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.isAuthenticated()) {
                // Principal이 문자열인 경우 처리
                if (authentication.getPrincipal() instanceof String) {
                    // 현재 사용자의 UID를 가져옴
                    String uid = (String) authentication.getPrincipal();
                    MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                    model.addAttribute("myInfoDTO", myInfoDTO);
                } else if (authentication.getPrincipal() instanceof MyUserDetails) {
                    // Principal이 MyUserDetails 타입인 경우
                    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                    String uid = userDetails.getMember().getUid();
                    MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                    model.addAttribute("myInfoDTO", myInfoDTO);
                }
            }
        } catch (Exception e) {
            // 예외 처리: 로그 등을 활용하여 디버깅 또는 로깅 가능
            e.printStackTrace();
            // 예외 발생 시 사용자에게 알림 등을 추가할 수 있음
            // model.addAttribute("error", "오류가 발생했습니다.");
        }

        return "my/info";
    }

    @PostMapping("/info")
    public String modify(String uid){

        infoService.updateInfo(uid);
        log.info("infoService" +  infoService);

        return "redirect:my/index";
    }

    @GetMapping("/passcheck")
    public String passCheck(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication.getPrincipal() instanceof String) {
                String uid = (String) authentication.getPrincipal();
                MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                model.addAttribute("myInfoDTO", myInfoDTO);
            } else if (authentication.getPrincipal() instanceof MyUserDetails) {
                MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                String uid = userDetails.getMember().getUid();
                MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                model.addAttribute("myInfoDTO", myInfoDTO);
            }
        }

        return "my/passcheck";
    }

    @GetMapping("/passchange")
    public String passchange(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication.getPrincipal() instanceof String) {
                String uid = (String) authentication.getPrincipal();
                MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                model.addAttribute("myInfoDTO", myInfoDTO);
            } else if (authentication.getPrincipal() instanceof MyUserDetails) {
                MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                String uid = userDetails.getMember().getUid();
                MyInfoDTO myInfoDTO = infoService.selectInfo(uid);
                model.addAttribute("myInfoDTO", myInfoDTO);
            }
        }

        return "my/passchange";
    }

    @PostMapping("/passchange")
    public String passmodify(Model model) {
        return "info";
    }
}
