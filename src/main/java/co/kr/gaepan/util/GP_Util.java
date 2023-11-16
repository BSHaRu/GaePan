package co.kr.gaepan.util;

import co.kr.gaepan.dto.member.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class GP_Util {

    // < > 특수 문자 치환 -> XSS(Cross-Site Scripting)  공격 막는거임
    public String replaceScript(String text){
        text = text.replace("<", "&lt");
        text = text.replace(">", "&gt");

        return text;
    }

    // 주소 지역만 가져옴
    public MemberDTO addrSubString(MemberDTO memberDTO) {
        memberDTO.setAddr1(addrSubString(memberDTO.getAddr1()));
        return memberDTO;
    }
    // 주소 2글자만 짜르기
    public String addrSubString(String addr){
        return addr.substring(0, 2);
    }

}
