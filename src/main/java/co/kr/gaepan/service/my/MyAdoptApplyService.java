package co.kr.gaepan.service.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import co.kr.gaepan.mapper.my.MyAdoptApplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyAdoptApplyService {

    private final MyAdoptApplyMapper myAdoptApplyMapper;

    public int insertApply(PetAdoptApplyDTO petAdoptApplyDTO) {

        return myAdoptApplyMapper.insertApply(petAdoptApplyDTO);
    }
}
