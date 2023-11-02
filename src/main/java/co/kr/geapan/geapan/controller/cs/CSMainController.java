package co.kr.geapan.geapan.controller.cs;

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
}
