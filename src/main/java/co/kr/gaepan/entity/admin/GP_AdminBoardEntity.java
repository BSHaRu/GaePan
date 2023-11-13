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
    private int bno;
    private String uid;
    private String title;
    private String content;
    private String group;
    private int cate;
    private int type;
    private String regIP;

    @CreatedDate
    private LocalDateTime regDate;

    @Builder.Default
    private int hit = 0;
    @Builder.Default
    private int parent = 0;
    private String comment;

}
