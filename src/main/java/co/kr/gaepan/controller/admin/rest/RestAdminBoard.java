package co.kr.gaepan.controller.admin.rest;

import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.dto.board.BoardTypeDTO;
import co.kr.gaepan.service.admin.AdminBoardCateService;
import co.kr.gaepan.service.admin.AdminBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/admin/board/*")
public class RestAdminBoard {

//    private final AdminBoardService adminBoardService;
    private final AdminBoardCateService adminBoardCateService;

    /*@GetMapping("/ajaxWrite")
    public List<GP_AdminBoardDTO> ajaxWrite(@RequestParam String optionValue,
                                            int cate, int type,
                                            HttpServletResponse response){

        List<GP_AdminBoardDTO> boardDTO = null;
        try {
            boardDTO = adminBoardCateService.cateNameAndTypeName(optionValue, cate, type);
        } catch (Exception e) {
            log.error("ajaxWrite error : ", e.getMessage());
            throw new RuntimeException(e);
        }

        return boardDTO;
    }*/

    @PostMapping("/ajaxCate")
    public List<BoardCateDTO> selectCate(@RequestParam String group) {
        try {
            return adminBoardCateService.getCateName(group);
        } catch (Exception e) {
            log.error("ajax cate error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ajaxType")
    public List<BoardTypeDTO> selectType(@RequestParam int cate){
        try {
            return adminBoardCateService.selectType(cate);
        } catch (Exception e) {
            log.error("ajax select type error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
