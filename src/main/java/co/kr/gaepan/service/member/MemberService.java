package co.kr.gaepan.service.member;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public MemberDTO loginUser(String uid){
        return mapper.loginUser(uid);
    }


}
