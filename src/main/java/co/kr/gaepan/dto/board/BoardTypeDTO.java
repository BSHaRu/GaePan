package co.kr.gaepan.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardTypeDTO {

    private int bt_no;
    private int bt_cate;
    private int bt_type;
    private String bt_typeName;
}
