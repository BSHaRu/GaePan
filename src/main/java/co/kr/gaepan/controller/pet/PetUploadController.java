package co.kr.gaepan.controller.pet;

import co.kr.gaepan.service.pet.PetBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pet")
public class PetUploadController {

    @Autowired
    private PetBoardService petBoardService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // PetBoardService의 파일 업로드 메서드 호출
        String fileUrl = petBoardService.uploadFile(file);

        return ResponseEntity.ok(fileUrl);
    }
}

