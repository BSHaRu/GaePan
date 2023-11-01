package co.kr.geapan.geapan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/member/login")
    public String login() {
        return "member/login";
    }
}
