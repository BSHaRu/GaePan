package co.kr.gaepan.controller.pet;

import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.service.pet.PetBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/pet/*")
@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetBoardService petBoardService;

    @RequestMapping("/pet/petlist")
    public String main(Model model) {

        List<PetRegisterDTO> petall = petBoardService.PetAll();
        model.addAttribute("petall", petall);

        return "pet/petlist";

    }

    @RequestMapping("/pet/petdoglist")
    public String petdoglist(Model model) {
        List<PetRegisterDTO> PetDog = petBoardService.PetDog("1");
        model.addAttribute("PetDog", PetDog);

        return "pet/petdoglist";
    }

    @RequestMapping("/pet/petcatlist")
    public String petcatlist(Model model) {
        List<PetRegisterDTO> PetCat = petBoardService.PetCat("2");
        model.addAttribute("PetCat", PetCat);

        return "pet/petcatlist";
    }

    @RequestMapping("/pet/petetclist")
    public String petetclist(Model model) {
        List<PetRegisterDTO> PetEtc = petBoardService.PetEtc("3");
        model.addAttribute("PetEtc", PetEtc);

        return "pet/petetclist";
    }


    @RequestMapping("/pet/petdetails")
    public String blog_details(String no, Model model) {

        PetRegisterDTO petview = petBoardService.pet(no);

        model.addAttribute("petview", petview);

        return "pet/petdetails";
    }

    @RequestMapping("/pet/register")
    public String register() {
        return "pet/register";
    }

    @PostMapping("/pet/register")
    public String insert(PetRegisterDTO dto) {

        petBoardService.insertPet(dto);

        return "redirect:petlist";
    }

}
