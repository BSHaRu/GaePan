package co.kr.gaepan.entity.admin;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gp_board_type")
public class GP_AdminBoardTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bt_no;
    private int bt_cate;
    private int bt_type;
    private String bt_typeName;
}
