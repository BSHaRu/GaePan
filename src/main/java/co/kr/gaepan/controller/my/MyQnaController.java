package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.my.MyQnaDTO;
import co.kr.gaepan.mapper.my.MyQnaMapper;
import co.kr.gaepan.service.my.MyQnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/my/*")
public class MyQnaController {

    @Autowired
    private MyQnaService myQnaService;

    @GetMapping("/qna")
    public String view(Model model, String uid, String pg) {

        // 페이징 처리
        // 현재 페이지 번호
        int currentPage = myQnaService.getCurrentPage(pg);

        // 전체 게시물 갯수
        int total = myQnaService.selectQnaCountTotal();

        // 마지막 페이지 번호
        int lastPageNum = myQnaService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = myQnaService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작번호
        int pageStartNum = myQnaService.getPageStartNum(currentPage, lastPageNum);

        // 시작 인덱스
        int start = myQnaService.getStartNum(currentPage);

        // 문의사항 출력
        List<MyQnaDTO> qnaList = myQnaService.select_all(uid, start);

        model.addAttribute("qnaList", qnaList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("total", total);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);

        return "my/qna";
    }
}
