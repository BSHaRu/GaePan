package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisAdminMemberMapper {
    List<MemberDTO> findAll() throws Exception;
}
