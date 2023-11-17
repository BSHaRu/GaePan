package co.kr.gaepan.controller.admin.rest;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.dto.board.BoardTypeDTO;
import co.kr.gaepan.service.admin.AdminBoardCateService;
import co.kr.gaepan.service.admin.AdminBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/admin/board/*")
public class RestAdminBoard {

    private final AdminBoardService adminBoardService;
    private final AdminBoardCateService adminBoardCateService;

    @GetMapping("/ajaxWrite")
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
    }
}
