package co.kr.gaepan.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetCateDTO {

    private int p_cno;
    private int p_cate;
    private String p_cName;
}
