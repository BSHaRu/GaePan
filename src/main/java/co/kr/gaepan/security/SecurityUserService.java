package co.kr.gaepan.security;


import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.service.member.MemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    private final MemberService service;

    public SecurityUserService(MemberService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴
        MemberDTO member = service.loginUser(username);

        if (member == null) {
            throw new UsernameNotFoundException("해당 사용자가 없습니다.");
        }





        // 사용자 인증객체 생성(세션에 저장)
        UserDetails userDetails = MyUserDetails.builder()
                .member(member)
                .build();

        return userDetails;
    }

}