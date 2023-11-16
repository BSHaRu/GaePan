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
public class MyInfoDTO {

    private int no;
    private String uid;
    private String pw;
    private String name;
    private String nick;
    private int gender;
    private String hp1;
    private String hp2;
    private String hp3;
    private String hp = (hp1 + "-" + hp2 + "-" + hp3);
    private String email1;
    private String email2;
    private String email = (email1 + "@" + email2);
    private String birth;
    private int type;
    private String zip;
    private String addr1;
    private String addr2;
    private String exp;
    private int count;
    private LocalDateTime regDate;
    private LocalDateTime levDate;

    // 추가
    private String pass1;
    private String company;
    private String bizRegNum;

}
