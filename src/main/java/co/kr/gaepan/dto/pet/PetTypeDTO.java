package co.kr.gaepan.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetTypeDTO {

    private int p_tno;
    private int pt_cate;
    private int type;
    private int tName;
}
