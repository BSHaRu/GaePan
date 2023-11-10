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
public class PetMainController {

    private final PetBoardService petService;

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

    @PostMapping("/pet/register")
    public String insert(PetRegisterDTO dto) {

        petService.insertPet(dto);

        return "redirect:petlist";
    }

    @RequestMapping("/pet/missingregister")
    public String missingregister() {
        return "pet/missingregister";
    }

}
