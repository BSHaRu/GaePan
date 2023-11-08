package co.kr.gaepan.service.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.mapper.my.InfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class InfoService {

    private final InfoMapper infoMapper;

    public MyInfoDTO selectInfo(String uid){
        MyInfoDTO myInfoDTO = infoMapper.selectInfo(uid);
        return myInfoDTO;
    }

    public void updateInfo(String uid){
        infoMapper.updateInfo(uid);
    }

    public void deleteInfo(String uid){
        infoMapper.deleteInfo(uid);
    }
}
