package co.kr.gaepan.service.pet;

import co.kr.gaepan.dto.pet.PetFileDTO;
import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.entity.pet.PetRegisterEntity;
import co.kr.gaepan.mapper.pet.PetListMapper;
import co.kr.gaepan.repository.pet.PetBoardRepository;
import co.kr.gaepan.repository.pet.PetFileRepository;
import com.nimbusds.jose.shaded.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetBoardService {

    private final PetBoardRepository petBoardRepository;
    private final PetFileRepository petFileRepository;
    private final PetListMapper petListMapper;

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public void insertPet(PetRegisterDTO dto) {

        PetRegisterEntity entity = dto.toEntity();

        PetFileDTO fileDTO = fileUpload(dto.getFilethumb()); // 단일 파일 업로드로 수정

        if (fileDTO != null) {
            fileDTO.setNo(entity.getNo());
            log.info("FileDTO : " + fileDTO);

            petFileRepository.save(fileDTO.toEntity());

            entity.setThumb(fileDTO.getSName());

        }

        PetRegisterEntity fileEntity = petBoardRepository.save(entity);
    }

    public PetFileDTO fileUpload(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String path = new File(filePath).getAbsolutePath();
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + fileExtension;

            try {
                file.transferTo(new File(path, newFileName));
                return PetFileDTO.builder().oName(originalFileName).sName(newFileName).build();
            } catch (IOException e) {
                log.error("파일 업로드 실패: " + e.getMessage(), e);
            }
        }

        return null; // 파일이 비어있거나 업로드 실패 시 null 반환
    }

    public List<PetRegisterDTO> PetAll() {

        List<PetRegisterDTO> petAll = petListMapper.petlist();

        return petAll;
    }

    public List<PetRegisterDTO> PetDog(String cate) {

        List<PetRegisterDTO> PetDog = petListMapper.petdoglist(cate);

        return PetDog;
    }

    public List<PetRegisterDTO> PetCat(String cate) {

        List<PetRegisterDTO> PetCat = petListMapper.petcatlist(cate);

        return PetCat;
    }

    public List<PetRegisterDTO> PetEtc(String cate) {

        List<PetRegisterDTO> PetEtc = petListMapper.petetclist(cate);

        return PetEtc;
    }

    public PetRegisterDTO pet(String no) {

        PetRegisterDTO pet = petListMapper.pet(no);

        return pet;
    }

}
