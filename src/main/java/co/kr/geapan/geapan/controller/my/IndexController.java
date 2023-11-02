package co.kr.geapan.geapan.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/my/index")
    public String index(){
        return "my/index";
    }
}
