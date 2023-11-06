package co.kr.gaepan.dto.admin;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GP_AdminBoardDTO {

    private int b_no;
    private String b_uid;
    private String b_title;
    private String b_content;
    private String b_group;
    private int b_cate;
    private int b_type;
    private String b_redIP;

    private LocalDateTime b_regDate;
    private String thumb1;
    private String thumb2;
    private String thumb3;

    private int b_hit;
    private int b_parent;
    private String b_comment;
}
