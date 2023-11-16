package co.kr.gaepan.service.cs;

import co.kr.gaepan.dto.board.BoardDTO;
import co.kr.gaepan.dto.cs.PageRequestDTO;
import co.kr.gaepan.dto.cs.PageResponseDTO;
import co.kr.gaepan.mapper.cs.CsBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
public class CsBoardService {

    @Autowired
    private CsBoardMapper mapper;

    public PageResponseDTO findByGroupAndCate(PageRequestDTO pageRequestDTO){

        log.info("CsBoardService pageRequestDTO : " + pageRequestDTO);
        log.info("CsBoardService getGroup : " + pageRequestDTO.getGroup());
        log.info("CsBoardService getCate : " + pageRequestDTO.getCate());

        // total 값 필요한 이유는 총 페이지 나타내야하므로
        int totalElements = mapper.countByGroupAndCate(pageRequestDTO.getGroup(), pageRequestDTO.getCate());
        log.info("CsBoardService totalElements : " + totalElements);


        List<BoardDTO> dtoList = mapper.findByGroupAndCate(pageRequestDTO.getGroup(), pageRequestDTO.getCate(), pageRequestDTO.getOffset(), pageRequestDTO.getLimit());
        log.info("CsBoardService dtoList : " + dtoList);

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElements)
                .build();

    }
}
