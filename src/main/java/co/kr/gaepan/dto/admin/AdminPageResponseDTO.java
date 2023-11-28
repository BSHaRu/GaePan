package co.kr.gaepan.dto.admin;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class AdminPageResponseDTO {
    // 위에는 추가해야 되는 값
    private List<GP_AdminBoardDTO> boardList;

    // 아래는 기본값
    private int pg;
    private int size;
    private int total;
    private int last;

    private String group;
    private int cate;
    private int displayPageNum;

    private int start, end;
    private boolean prev, next;

    @Builder
    public AdminPageResponseDTO(AdminPageRequestDTO adminPageRequestDTO,
                             List<GP_AdminBoardDTO> boardList, int total) {
        this.pg = adminPageRequestDTO.getPg();
        this.size = adminPageRequestDTO.getSize();

        this.total = total;
        this.group = adminPageRequestDTO.getGroup();
        this.cate = adminPageRequestDTO.getCate();

        this.boardList = boardList;
        this.displayPageNum = 5;

        // 이게 페이지 번호 개수 나타내는거임
        // 5로 잡으면 5개씩 페이지 출력함
        this.end = (int) (Math.ceil(this.pg / (double)displayPageNum)) * displayPageNum;
        this.start = this.end - (displayPageNum - 1);

        int last = (int)(Math.ceil(total / (double)size));
        this.last = last;

        this.end = end > last ? last:end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
