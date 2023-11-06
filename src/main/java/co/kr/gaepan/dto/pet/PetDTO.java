package co.kr.gaepan.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDTO {

    private int p_no;
    private int p_cate;
    private int p_type;
    private String p_name;
    private String p_uid;
    private String p_company;
    private String p_thumb1;
    private String p_thumb2;
    private String p_thumb3;
    private String p_addr;
    private String p_regip;
    private LocalDateTime p_regDate;
    private int p_adoptYN;
}
