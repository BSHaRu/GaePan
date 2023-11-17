package co.kr.gaepan.controller.admin.rest;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.service.admin.AdminBoardCateService;
import co.kr.gaepan.service.admin.AdminBoardService;
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

    @GetMapping("/getCateDTO")
    public List<BoardCateDTO> getCateDTO(@RequestParam("group") String group,
                                             int cate){
        List<BoardCateDTO> cateDTO = null;
        log.info("getCateDTO cate" + cate);
        log.info("getCateDTO group" + group);
        try {
            cateDTO = adminBoardCateService.getCateName(group);
            log.info("CateDTO: " + cateDTO);
        } catch (Exception e) {
            log.error("ajax getCate error" + e.getMessage());
            throw new RuntimeException(e);
        }
        return cateDTO;
    }
}
