package co.kr.gaepan.service.admin.impl;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.entity.admin.GP_AdminBoardEntity;
import co.kr.gaepan.mapper.admin.AdminBoardMapper;
import co.kr.gaepan.mapper.admin.MybatisAdminBoardMapper;
import co.kr.gaepan.repository.admin.AdminBoardRepository;
import co.kr.gaepan.service.admin.AdminBoardService;
import co.kr.gaepan.util.GP_Util;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminBoardServiceImpl implements AdminBoardService {

    private final AdminBoardRepository adminBoardRepository;
    private final AdminBoardMapper adminBoardMapper;
    private final MybatisAdminBoardMapper mybatisAdminBoardMapper;
    private final GP_Util gpUtil;

    @Override
    public void saveAdminBoard(GP_AdminBoardDTO dto) throws Exception {
        GP_AdminBoardEntity entity = adminBoardMapper.toEntity(dto);
        log.info("GP_AdminBoardEntity entity : "+entity);
        adminBoardRepository.save(entity);
    }

    @Override
    public List<GP_AdminBoardDTO> findAll() throws Exception {
        List<GP_AdminBoardDTO> dto = mybatisAdminBoardMapper.findAll();
        log.info("List<GP_AdminBoardDTO> dto : "+dto);
        return dto;
    }

    @Override
    public void modifyAdminBoard(GP_AdminBoardDTO dto) throws Exception {

    }

    @Override
    public void deleteAdminBoard(int bno) throws Exception {

    }

    @Override
    public GP_AdminBoardDTO findById(int bno) throws Exception {
        GP_AdminBoardEntity entity = adminBoardRepository.findById(bno).get();
        GP_AdminBoardDTO dto = adminBoardMapper.toDTO(entity);
        return dto;
    }


    @Override
    public void updateViewCnt(HttpServletRequest request,
                              HttpServletResponse response,
                              int bno) throws Exception {
        String cookieBno = "GaePan" + bno;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieBno)) {
                    // 쿠키값이 존재하면 이대로 return 해서 종료
                    return;
                }
            }
        }
        // 쿠키가 존재하지 않으면 이하 실행
        Cookie cookie = new Cookie(cookieBno, bno+"");
        String path = request.getContextPath()+"/GaePan/";
        log.info("path : "+path);
        cookie.setPath(path);
        cookie.setMaxAge(60*60); // 1시간
        response.addCookie(cookie);
        mybatisAdminBoardMapper.updateViewCnt(bno);
    }

    // board에서 글 쓸 때 태그 공격 막기
    public GP_AdminBoardDTO replace(GP_AdminBoardDTO dto){
        dto.setB_title(gpUtil.replaceScript(dto.getB_title()));
        dto.setB_content(gpUtil.replaceScript(dto.getB_content()));
        dto.setB_uid(gpUtil.replaceScript(dto.getB_uid()));

        return dto;
    }
}
