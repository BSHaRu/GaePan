package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import co.kr.gaepan.service.my.MyAdoptApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my/*")
public class MyApplyController {

    @GetMapping("/apply")
    public String view() {
        return "my/apply";
    }
}
