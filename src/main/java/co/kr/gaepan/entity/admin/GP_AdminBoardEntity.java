package co.kr.gaepan.entity.admin;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gp_board")
public class GP_AdminBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_no;
    private String b_uid;
    private String b_title;
    private String b_content;
    private String b_group;
    private int b_cate;
    private int b_type;
    private String b_redIP;

    @CreatedDate
    private LocalDateTime b_regDate;
    private String thumb1;
    private String thumb2;
    private String thumb3;

    @Builder.Default
    private int b_hit = 0;
    @Builder.Default
    private int b_parent = 0;
    private String b_comment;

}
