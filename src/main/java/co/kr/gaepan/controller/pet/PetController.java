package co.kr.gaepan.controller.pet;

import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.service.pet.PetBoardService;
import com.nimbusds.jose.shaded.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
