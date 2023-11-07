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

    public MyInfoDTO selectInfo(String m_uid){
        MyInfoDTO myInfoDTO = infoMapper.selectInfo(m_uid);
        return myInfoDTO;
    }

    public void updateInfo(String m_uid){
        infoMapper.updateInfo(m_uid);
    }

    public void deleteInfo(String m_uid){
        infoMapper.deleteInfo(m_uid);
    }
}
