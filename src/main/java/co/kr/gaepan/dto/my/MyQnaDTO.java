package co.kr.gaepan.dto.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyQnaDTO {

    private int no;
    private String title;
    private String content;
    private String uid;
    private String group;
    private int cate;
    private int type;
    private int hit;
    private String comment;
    private String redIP;
    private LocalDateTime regDate;
    private String thumb1;
    private String thumb2;
    private String thumb3;

}
