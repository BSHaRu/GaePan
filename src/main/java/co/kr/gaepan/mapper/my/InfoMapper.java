package co.kr.gaepan.mapper.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoMapper {

    // 사용자 정보 불러오기
    public MyInfoDTO selectInfo(String uid);

    // 사용자 정보 수정하기
    public void updateInfo(String uid);

    // 사용자 정보 삭제하기
    public void deleteInfo(String uid);
}
