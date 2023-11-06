package co.kr.gaepan.dto.admin;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GP_AdminBoardTypeDTO {

    private int bt_no;
    private int bt_cate;
    private int bt_type;
    private String bt_typeName;
}
