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

    @RequestMapping("/pet/adoptdiary")
    public String adoptdiary() {
        return "pet/adoptdiary";
    }
    @RequestMapping("/pet/sighting")
    public String sighting() {
        return "pet/sighting";
    }
    @RequestMapping("/pet/register")
    public String register() {
        return "pet/register";
    }

    @RequestMapping("/pet/missingregister")
    public String missingregister() {
        return "pet/missingregister";
    }

}
