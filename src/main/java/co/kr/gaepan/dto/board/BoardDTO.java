package co.kr.gaepan.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private int b_no;
    private String b_uid;
    private String b_title;
    private String b_content;
    private String b_group;
    private int b_cate;
    private int b_type;
    private String b_regIP;

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

    // toEntity

}
