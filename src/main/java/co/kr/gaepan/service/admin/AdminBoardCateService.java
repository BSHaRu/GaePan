package co.kr.gaepan.service.admin;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.dto.board.BoardDTO;

import java.util.List;

public interface AdminBoardCateService {
    // cate에 따라서 해당 게시글 보기
    List<GP_AdminBoardDTO> getCate(String group, int cate) throws Exception;
    // board의 group과 cateDTO를 join해서 cateName가져오기
    List<BoardCateDTO> getCateName(String group) throws Exception;

    // board와 group이랑 cate 다 join해서 cateName, typeName가져오기
    List<GP_AdminBoardDTO> cateNameAndTypeName(String group, int cate, int type) throws Exception;
}
