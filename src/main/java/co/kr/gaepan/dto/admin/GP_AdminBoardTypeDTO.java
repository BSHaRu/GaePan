package co.kr.gaepan.dto.admin;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GP_AdminBoardTypeDTO {

    private int tno;
    private int cate;
    private int type;
    private String typeName;
}
