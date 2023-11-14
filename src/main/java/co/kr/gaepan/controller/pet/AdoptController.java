package co.kr.gaepan.controller.pet;

import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.service.pet.PetBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pet/*")
@Controller
@RequiredArgsConstructor
public class AdoptController {

    private final PetBoardService petBoardService;

    @RequestMapping("/pet/adoptdiary")
    public String adoptdiary() {
        return "pet/adoptdiary";
    }

    @RequestMapping("/pet/adoptditails")
    public String adoptditails() {
        return "pet/adoptditails";
    }

    @RequestMapping("/pet/adoptdiaryregister")
    public String adoptdiaryregister() {
        return "pet/adoptdiaryregister";
    }


}
