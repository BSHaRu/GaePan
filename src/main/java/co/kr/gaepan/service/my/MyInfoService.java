package co.kr.gaepan.service.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.mapper.my.MyInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyInfoService {

    private final MyInfoMapper myInfoMapper;
    private final PasswordEncoder passwordEncoder;

    public MyInfoDTO selectInfo(String uid) {
        return myInfoMapper.selectInfo(uid);
    }

    public int updateInfo(MyInfoDTO myInfoDTO){
        int updatedRowCount = myInfoMapper.updateInfo(myInfoDTO);
        log.info("Updated rows: " + updatedRowCount);
        return updatedRowCount;
    }

    public int updatePassword(String uid, String currentPw, String newPw) {
        // 현재 비밀번호 확인
        MyInfoDTO currentInfo = myInfoMapper.selectInfo(uid);

        if (currentInfo == null) {
            // 현재 정보가 없으면 실패를 나타내는 값을 반환하거나 예외를 던질 수 있습니다.
            return 0; // 현재 정보가 없음
        }

        // 사용자가 입력한 현재 비밀번호를 암호화하여 데이터베이스에 저장된 암호화된 비밀번호와 비교
        if (!passwordEncoder.matches(currentPw, currentInfo.getPw())) {
            // 비밀번호가 일치하지 않으면 실패를 나타내는 값을 반환하거나 예외를 던질 수 있습니다.
            return 0; // 비밀번호 불일치
        }

        // MyBatis 매퍼를 통해 비밀번호 변경 쿼리 수행
        int rowsAffected = myInfoMapper.updatePassword(uid, passwordEncoder.encode(newPw));

        return rowsAffected;
    }

    @Transactional
    public void deleteInfo(MyInfoDTO myInfoDTO) {
        myInfoMapper.deleteInfo(myInfoDTO);
    }

}
