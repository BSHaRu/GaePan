package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.util.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisAdminBoardMapper {

    // 조회
    List<GP_AdminBoardDTO> findAll(String group) throws Exception;

    // 조회수 증가
    void updateViewCnt(int bno) throws Exception;

    // 검색된 게시물 목록
    List<GP_AdminBoardDTO> searchList(SearchCriteria cri) throws Exception;

    // 검색된 게시물의 전체 개수
    int searchListCount(SearchCriteria cri) throws Exception;

    // cate & type 이름 가져오기
    List<GP_AdminBoardDTO> cateAndType(String group, String cate, String type) throws Exception;

}
