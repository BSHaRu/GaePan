package co.kr.gaepan.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"result","status"})
public class ResponseEmailDTO {
    private int result;
    private int status;
}

