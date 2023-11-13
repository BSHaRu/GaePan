package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisAdminBoardMapper {

    // 조회
    List<GP_AdminBoardDTO> findAll(String group) throws Exception;
    // 조회수 증가
    void updateViewCnt(int bno) throws Exception;

}
