package co.kr.gaepan.dto.cs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data // Getter, Setter, ToString
@Builder
@AllArgsConstructor // 속성 초기화 생성자
@NoArgsConstructor // 기본 생성자
public class PageRequestDTO {

    @Builder.Default
    private int pg = 1;

    @Builder.Default
    private int size = 10;

    @Builder.Default
    private int cate = 10; // notice=10 qna=20 faq=30

    @Builder.Default
    private int type = 0;
    public Pageable getPageable(String sort){ // sort에 "no" 값 넣음

        return PageRequest.of(this.pg - 1, this.size, Sort.by(sort).descending());
    }
}