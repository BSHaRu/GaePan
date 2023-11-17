package co.kr.gaepan.service.admin.impl;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.board.BoardCateDTO;
import co.kr.gaepan.mapper.admin.MybatisAdminBoardMapper;
import co.kr.gaepan.service.admin.AdminBoardCateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminBoardCateServiceImpl implements AdminBoardCateService {
    private final MybatisAdminBoardMapper mybatisAdminBoardMapper;


    @Override
    public List<GP_AdminBoardDTO> getCate(String group, int cate) throws Exception{
        List<GP_AdminBoardDTO> dto = mybatisAdminBoardMapper.getCate(group, cate);
        log.info("Service getCate dto : " + dto);
        return dto;
    }

    @Override
    public List<BoardCateDTO> getCateName(String group) throws Exception{
        List<BoardCateDTO> dto = mybatisAdminBoardMapper.getCateName(group);
        return dto;
    }

    @Override
    public List<GP_AdminBoardDTO> cateNameAndTypeName(String group, int cate, int type) throws Exception {
        List<GP_AdminBoardDTO> dto = mybatisAdminBoardMapper.cateNameAndTypeName(group, cate, type);
        return null;
    }
}
