package co.kr.gaepan.dto.admin;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GP_AdminBoardCateDTO {

    private int bc_no;
    private int bc_cate;
    private String bc_cateName;
}
