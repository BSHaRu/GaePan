package co.kr.gaepan.mapper.cs;

import co.kr.gaepan.dto.board.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CsBoardMapper { // interface선언

    // ★ 매개변수 바인딩 하는법
    // String group만 하니까 쿼리문 바인딩 안되서 이렇게 파라미터 이름대로 바인딩 해주자
    public List<BoardDTO> findByGroupAndCate(@Param("group") String group, @Param("cate") int cate, @Param("offset") int offset, @Param("limit") int limit);
    public int countByGroupAndCate(@Param("group") String group, @Param("cate") int cate);
    public BoardDTO findByNo(@Param("bno") int bno);
    public BoardDTO findByParent(@Param("bno") int bno);

    public void insertInquiry(
            @Param("uid") String uid,
            @Param("title") String title,
            @Param("content") String content,
            @Param("cate") int cate,
            @Param("type") int type,
            @Param("regIP") String regIP,
            @Param("regDate") LocalDateTime regDate // 타입 String 아니라 LocalDateTime / 이렇게 한다고 regDate 값 자동으로 정해지는 게 아니구나
            );
}
