package co.kr.gaepan.controller.pet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pet/*")
@Controller
public class PetMainController {

    @RequestMapping("/pet/petlist")
    public String main() {
        return "pet/petlist";
    }

    @RequestMapping("/pet/missinglist")
    public String missing() {
        return "pet/missinglist";
    }

    @RequestMapping("/pet/petdetails")
    public String blog_details() {
        return "pet/petdetails";
    }
}
