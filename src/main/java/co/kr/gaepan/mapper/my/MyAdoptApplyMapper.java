package co.kr.gaepan.mapper.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyAdoptApplyMapper {

    public int insertApply(PetAdoptApplyDTO petAdoptApplyDTO);
}
