package co.kr.gaepan.controller.cs;


import co.kr.gaepan.dto.cs.PageRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cs/*")
@Controller
public class CSMainController {

    @GetMapping("/index")
    public String index(){
        return "cs/index"; // return 시작할 때 / 붙이지 않기w
    }
    @GetMapping("/qna/list")
    public String qnaList(PageRequestDTO PageRequestDTO){


        return "cs/qna/list";
    }
    @GetMapping("/qna/view")
    public String qnaView() {
        return "cs/qna/view";
    }
    @GetMapping("/qna/write")
    public String qnaWrite(){
        return "cs/qna/write";
    }
    @GetMapping("/notice/list")
    public String noticeList(){
        return "cs/notice/list";
    }@GetMapping("/notice/view")
    public String noticeView(){
        return "cs/notice/view";
    }
    @GetMapping("/faq/list")
    public String faqList(){
        return "cs/faq/list";
    }
}

