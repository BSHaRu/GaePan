package co.kr.gaepan.controller.cs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cs/*")
@Controller
public class CSMainController {

    @GetMapping("/index")
    public String index(){

        return "cs/index";
    }
    @GetMapping("/qna/list")
    public String qnaList(){
        return "/cs/qna/list";

    }@GetMapping("/qna/write")
    public String qnaWrite(){
        return "/cs/qna/write";
    }

}
