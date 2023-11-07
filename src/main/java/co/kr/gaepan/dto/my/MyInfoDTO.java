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

    private int m_no;
    private String m_uid;
    private String m_pw;
    private String m_name;
    private String m_nick;
    private int m_gender;
    private String m_hp;
    private String m_email;
    private String m_birth;
    private int m_type;
    private String m_zip;
    private String m_addr1;
    private String m_addr2;
    private String m_company;
    private String m_bizRegNum;
    private LocalDateTime m_regDate;
    private LocalDateTime m_leaDate;
    private String m_exp;
    private int m_count;

}
