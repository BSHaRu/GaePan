package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import co.kr.gaepan.dto.pet.PetCateDTO;
import co.kr.gaepan.service.my.MyAdoptApplyService;
import co.kr.gaepan.service.my.MyInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
public class MyApplyController {

    @Autowired
    private MyAdoptApplyService myAdoptApplyService;

    @GetMapping("/my/apply")
    public String view() {
        return "my/apply";
    }

    @PostMapping("/my/apply")
    public String write(PetAdoptApplyDTO petAdoptApplyDTO) {

        myAdoptApplyService.insertApply(petAdoptApplyDTO);
        log.info("myAdoptApplyService : " +myAdoptApplyService);

        return "redirect:index";
    }
}
