package co.kr.gaepan.mapper.cs;

import co.kr.gaepan.dto.board.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CsBoardMapper { // interface선언

    //
    public List<BoardDTO> findByGroupAndCate(@Param("group") String group, @Param("cate") int cate, @Param("offset") int offset, @Param("limit") int limit);
    public int countByGroupAndCate(@Param("group") String group, @Param("cate") int cate);
}
