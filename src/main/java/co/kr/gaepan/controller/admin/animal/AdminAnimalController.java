package co.kr.gaepan.controller.admin.animal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/animal/*")
@Controller
public class AdminAnimalController {

    @GetMapping("/person")
    public String person() {
        return "admin/animal/person";
    }

    @GetMapping("/company")
    public String company() {
        return "admin/animal/company";
    }
}
