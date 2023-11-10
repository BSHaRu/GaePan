package co.kr.gaepan.service.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.mapper.my.MyInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyInfoService {

    private final MyInfoMapper myInfoMapper;

    public MyInfoDTO selectInfo(String uid){
        MyInfoDTO myInfoDTO = myInfoMapper.selectInfo(uid);
        return myInfoDTO;
    }

    public MyInfoDTO updateInfo(String uid){
        MyInfoDTO myInfoDTO = myInfoMapper.updateInfo(uid);
        return myInfoDTO;
    }

    public void deleteInfo(String uid){
        myInfoMapper.deleteInfo(uid);
    }
}
