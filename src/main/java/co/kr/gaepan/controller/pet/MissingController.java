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
public class MissingController {

    private final PetBoardService petBoardService;

    @RequestMapping("/pet/missinglist")
    public String missing() {
        return "pet/missinglist";
    }

    @RequestMapping("/pet/missingregister")
    public String missingregister() {
        return "pet/missingregister";
    }

    @RequestMapping("/pet/missingdetails")
    public String missingdetails() {
        return "pet/missingdetails";
    }

}
