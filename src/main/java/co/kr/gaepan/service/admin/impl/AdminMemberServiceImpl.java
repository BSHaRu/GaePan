package co.kr.gaepan.service.admin.impl;

import co.kr.gaepan.dto.member.MemberDTO;
import co.kr.gaepan.mapper.admin.MybatisAdminMemberMapper;
import co.kr.gaepan.service.admin.AdminMemberService;
import co.kr.gaepan.util.GP_Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminMemberServiceImpl implements AdminMemberService {

    private final MybatisAdminMemberMapper mybatisAdminMemberMapper;
    private final GP_Util gpUtil;

    @Override
    public List<MemberDTO> findAll() throws Exception {
        List<MemberDTO> memberList = mybatisAdminMemberMapper.findAll();
        memberList.replaceAll(gpUtil::addrSubString);
        return memberList;
    }

    @Override
    public MemberDTO findById(int no) throws Exception {
        return null;
    }

    @Override
    public void blackMember(List<MemberDTO> memberDTOList) throws Exception {
        mybatisAdminMemberMapper.blackMember(memberDTOList);
    }

    @Override
    public void leaveMember(List<MemberDTO> memberDTO) throws Exception {
        mybatisAdminMemberMapper.leaveMember(memberDTO);
    }
}
