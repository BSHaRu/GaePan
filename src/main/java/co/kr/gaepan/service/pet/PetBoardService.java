package co.kr.gaepan.service.pet;

import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.entity.pet.PetRegisterEntity;
import co.kr.gaepan.repository.pet.PetBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PetBoardService {

    private final PetBoardRepository petBoardRepository;

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public void insertPet(PetRegisterDTO dto) {

        PetRegisterEntity entity = dto.toEntity();
        petBoardRepository.save(entity);

    }



}
