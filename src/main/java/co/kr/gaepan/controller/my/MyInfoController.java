package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.security.MyUserDetails;
import co.kr.gaepan.service.my.MyInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/my/*")
@Log4j2
public class MyInfoController {

    @Autowired
    private MyInfoService infoService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
            model.addAttribute("error", "오류가 발생했습니다.");
        }

        return "my/info";
    }

    @PostMapping("/info")
    public String modify(@ModelAttribute MyInfoDTO myInfoDTO) {

        log.info("myInfoDTO : " + myInfoDTO);

        // 서비스 메서드 호출
        int updatedRows = infoService.updateInfo(myInfoDTO);

        // 업데이트가 성공했을 경우에 대한 로직 추가 (예: 로그 출력)
        if (updatedRows > 0) {
            log.info("정보 수정 완료된 아이디: " + myInfoDTO.getUid());
        } else {
            log.info("정보 수정에 실패한 아이디: " + myInfoDTO.getUid());
        }

        return "redirect:index";
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
    @ResponseBody
    public Map<String, Object> passmodify(@ModelAttribute("myInfoDTO") MyInfoDTO myInfoDTO,
                                          @RequestParam("currentPw") String currentPw,
                                          @RequestParam("newPw") String newPw) {

        log.info("passmodify...1");

        Map<String, Object> response = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("passmodify...2");
        if (authentication != null && authentication.isAuthenticated()) {
            log.info("passmodify...3");
            if (authentication.getPrincipal() instanceof MyUserDetails) {
                MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                String uid = userDetails.getMember().getUid();
                MyInfoDTO storedInfo = infoService.selectInfo(uid);
                log.info("passmodify...4");
                if (storedInfo != null && passwordEncoder.matches(currentPw, storedInfo.getPw())) {
                    // 현재 비밀번호가 일치하면 변경
                    int rowsAffected = infoService.updatePassword(uid, currentPw, newPw);
                    log.info("passmodify...5");
                    if (rowsAffected > 0) {
                        response.put("success", true);
                        response.put("message", "비밀번호 변경 성공");
                        log.info("passmodify...6");
                        return response;

                    } else {
                        response.put("success", false);
                        response.put("message", "비밀번호 변경 실패");
                        log.info("passmodify...7");
                    }
                } else {
                    response.put("success", false);
                    response.put("message", "비밀번호가 일치하지 않습니다.");
                    log.info("passmodify...8");
                }
            }
        }

        return response;
    }

}
