package co.kr.gaepan.mapper.my;

import co.kr.gaepan.dto.my.MyQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyQnaMapper {

    // 페이징 - 전체 게시글 갯수 계산
    public int selectQnaCountTotal();

    // 나의 리뷰 10개씩 출력
    public List<MyQnaDTO> select_all(String uid, int start);
}
