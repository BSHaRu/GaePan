package co.kr.gaepan.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private int b_no;
    private int b_parent;
    private int b_group;
    private int b_cate1;
    private int b_cate2;
    private String b_writer;
    private String b_title;
    private String b_content;
    private String b_regip;
    private LocalDateTime b_regdate;

}
