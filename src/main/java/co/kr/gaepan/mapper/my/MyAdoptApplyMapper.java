package co.kr.gaepan.mapper.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import co.kr.gaepan.dto.pet.PetCateDTO;
import co.kr.gaepan.dto.pet.PetTypeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyAdoptApplyMapper {

    public void insertApply(PetAdoptApplyDTO petAdoptApplyDTO);
}
