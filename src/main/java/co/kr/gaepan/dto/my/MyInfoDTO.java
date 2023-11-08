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
    private String hp;
    private String email;
    private String birth;
    private int type;
    private String zip;
    private String addr1;
    private String addr2;
    private String company;
    private String bizRegNum;
    private LocalDateTime regDate;
    private LocalDateTime leaDate;
    private String exp;
    private int count;

}
