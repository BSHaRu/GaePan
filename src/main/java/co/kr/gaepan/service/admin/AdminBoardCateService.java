package co.kr.gaepan.service.admin;


import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.dto.board.BoardDTO;

import java.util.List;

public interface AdminBoardCateService {
    //
    List<GP_AdminBoardDTO> getCate(String group, int cate) throws Exception;
    // board의 group과 cateDTO를 조인해서 cateNaem가져오기
    List<BoardCateDTO> getCateName(String group) throws Exception;
}
