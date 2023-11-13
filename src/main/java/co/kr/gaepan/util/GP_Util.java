package co.kr.gaepan.util;

import co.kr.gaepan.dto.member.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class GP_Util {

    // < > 특수 문자 치환 -> 태그 공격 막는거임
    public String replaceScript(String text){
        text = text.replace("<", "&lt");
        text = text.replace(">", "&gt");

        return text;
    }

    // 검색 한 결과값에 뭘 검색했는지 텍스트에 하이라이트 적용
    public String highLight(String text, String word) {	// 수정할 텍스트 | 검색한 키워드
        text = text.replace(word, "<b style='color:#8972ee;'>"+word+"</b>");
        return text;
    }

    public MemberDTO addrSubString(MemberDTO memberDTO) {
        memberDTO.setAddr1(addrSubString(memberDTO.getAddr1()));
        return memberDTO;
    }
    public String addrSubString(String addr){
        return addr.substring(0, 2);
    }

}
