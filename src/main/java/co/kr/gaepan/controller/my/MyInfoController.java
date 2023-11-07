package co.kr.gaepan.controller.my;

import co.kr.gaepan.dto.my.MyInfoDTO;
import co.kr.gaepan.mapper.my.InfoMapper;
import co.kr.gaepan.service.my.InfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my/*")
@Log4j2
public class MyInfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/info")
    public String view(Model model, String m_uid) {

        MyInfoDTO myInfoDTO = MyInfoDTO.builder()
                                .m_name("김유신")
                                .m_uid("User1")
                                .m_nick("Kim")
                                .m_gender(1)
                                .m_hp("01010011234")
                                .m_email("kim@gmail.com")
                                .m_birth("1983년 05월 03일")
                                .m_addr1("부산광역시")
                                .m_addr2("부산진구")
                                .m_count(0)
                                .build();

        model.addAttribute("myInfoDTO", myInfoDTO);

        return "my/info";
    }

    @PostMapping("/info")
    public String modify(String m_uid){

        infoService.updateInfo(m_uid);
        // infoService.deleteInfo(m_uid);

        log.info("infoService" +  infoService);
        // log.info("infoService" +  infoService);

        return "redirect:/index";
    }

    @PostMapping("/withdraw")
    public void withdraw(){
        log.info("withdraw!!!");
    }
}
