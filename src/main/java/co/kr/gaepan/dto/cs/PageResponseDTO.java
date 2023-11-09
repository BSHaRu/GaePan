package co.kr.gaepan.dto.cs;

import co.kr.gaepan.dto.board.BoardDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO {
    private List<BoardDTO> dtoList;
    private int cate;
    private int pg;
    private int size;
    private int total;

    private int start, end;
    private boolean prev, next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<BoardDTO> dtoList, int total){

        this.cate = pageRequestDTO.getCate();
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int) (Math.ceil(total / (double) size));

        this.end = end > last ? last : end; // 삼항연산자
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;


    }
}
