package co.kr.gaepan.controller.pet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pet/*")
@Controller
public class PetMainController {

    @RequestMapping("/blog")
    public String main() {
        return "pet/blog";
    }

    @RequestMapping("/blog_details")
    public String blog_details() {
        return "pet/blog-details";
    }
}
