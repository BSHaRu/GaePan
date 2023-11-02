package co.kr.gaepan.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/my/*")
@Controller
public class MyMainController {

    @GetMapping("/index")
    public String index(){
        return "my/index";
    }
}
