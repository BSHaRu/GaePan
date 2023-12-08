package co.kr.gaepan.controller.member;

import co.kr.gaepan.dto.member.RequestEmailDTO;
import co.kr.gaepan.dto.member.ResponseEmailDTO;
import co.kr.gaepan.service.member.MailService;
import co.kr.gaepan.service.member.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/member/email")
@RestController
public class MailController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MailService mailService;


    @GetMapping("/authEmail")
    public ResponseEmailDTO checkAuthEmail(RequestEmailDTO dto) {
        int result = 0;
        int status = 0;
        log.info("requestEmailDTO의 division 종류 : " + dto.getDivision());


        if(dto.getDivision().equals("REGISTER")) {
            //회원가입 할 때 이메일 인증
            result = memberService.countEmail(dto.getEmail()); //이메일 중복체크
            if (result == 0) { //가입된 이메일로 인증할 수 없음
                status = mailService.sendMail(dto.getEmail()); //이메일 발송 함수 호출
            }
        }

        ResponseEmailDTO response = new ResponseEmailDTO();
        response.setResult(result);
        response.setStatus(status);
        return response;
    }

    // 코드확인 method 설정
    @PostMapping("/confirmEmail/{code}")
    public int confirmEmail(@PathVariable("code") String code) {
        int result = mailService.confirmCodeByEmail(code);
        return result;
    }
}