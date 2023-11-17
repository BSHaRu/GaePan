package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
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

    // cate에 따라 board List 출력
    List<GP_AdminBoardDTO> getCate(String group, int cate) throws Exception;

    // group에 따라 카테고리를 cateName에 맞게 출력
    List<BoardCateDTO> getCateName(String group) throws Exception;

    List<GP_AdminBoardDTO> cateNameAndTypeName(String group, int cate, int type) throws Exception;
}
