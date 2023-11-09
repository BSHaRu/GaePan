package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.service.my.MyInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/my/*")
@Log4j2
public class MyInfoController {

    @Autowired
    private MyInfoService infoService;

    @GetMapping("/info")
    public String view(Model model, String uid) {

        MyInfoDTO myInfoDTO = MyInfoDTO.builder()
                                .name("김유신")
                                .uid("User1")
                                .nick("Kim")
                                .gender(1)
                                .hp("01010011234")
                                .email("kim@gmail.com")
                                .birth("1983년 05월 03일")
                                .zip("13465")
                                .addr1("부산광역시")
                                .addr2("부산진구")
                                .count(0)
                                .build();

        model.addAttribute("myInfoDTO", myInfoDTO);

        return "my/info";
    }

    @PostMapping("/info")
    public String modify(String uid){

        infoService.updateInfo(uid);
        // infoService.deleteInfo(uid);

        log.info("infoService" +  infoService);
        // log.info("infoService" +  infoService);

        return "redirect:/index";
    }

    @GetMapping("/passcheck")
    public String passcheck(Model model, MyInfoDTO myInfoDTO) {

        log.info("myInfoDTO : " + myInfoDTO);

        model.addAttribute(myInfoDTO);

        return "/my/passcheck";
    }

    @ResponseBody
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String uid){
        log.info("withdraw!!!");
        return uid;
    }
}
