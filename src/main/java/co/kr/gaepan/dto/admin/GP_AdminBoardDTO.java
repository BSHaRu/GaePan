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

    private int bno;
    private String uid;
    private String title;
    private String content;
    private String group;
    private int cate;
    private int type;
    private String regIP;

    private LocalDateTime regDate;

    private int hit;
    private int parent;
    private String comment;
}
