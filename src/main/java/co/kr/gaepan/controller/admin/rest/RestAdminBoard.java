package co.kr.gaepan.controller.admin.rest;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
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

    private final AdminBoardService adminBoardService;
    private final AdminBoardCateService adminBoardCateService;

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

    // 게시글 checkbox로 삭제
    @PostMapping("/deleteBoardList")
    public String deleteBoardList(List<GP_AdminBoardDTO> boardDTO){
        log.info("deleteBoardList : " + boardDTO);
        try {
            adminBoardService.deleteAdminBoard(boardDTO);
        } catch (Exception e) {
            log.error("ajax admin deleteBoardList error : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return "";
    }

    // 게시글 bno값을 통해서 1개만 삭제
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam int bno) {
        log.info("ajax bno : " + bno);
        try {
            adminBoardService.deleteById(bno);
        } catch (Exception e) {
            log.error("ajax admin deleteById error : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return "";
    }



}
