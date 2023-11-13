package co.kr.gaepan.service.admin;

import co.kr.gaepan.dto.member.MemberDTO;

import java.util.List;

public interface AdminMemberService {

    // 회원관리 List
    List<MemberDTO> findAll() throws Exception;

    // 회원 상세 보기
    MemberDTO findById(int no) throws Exception;

    // 회원 수정 -> 블랙리스트 등록 / 등급 수정 등
    void modifyMember(MemberDTO memberDTO) throws Exception;

    // 회원 탈퇴 -> 개인정보 null / uid, nick은 그대로 유지
    void updateMember(MemberDTO memberDTO) throws Exception;
}
