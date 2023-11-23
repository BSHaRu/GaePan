package co.kr.gaepan.service.my;

import co.kr.gaepan.dto.pet.PetAdoptApplyDTO;
import co.kr.gaepan.mapper.my.MyApplyListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyAdoptApplyListService {

    private final MyApplyListMapper myApplyListMapper;

    public List<PetAdoptApplyDTO> applyAll(String uid, int start) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("uid", uid);
        parameters.put("start", start);

        return myApplyListMapper.applyAll(parameters);
    }

    public int selectApplyListCountTotal(String uid) {
        return myApplyListMapper.selectApplyListCountTotal(uid);
    }

    public int getLastPageNum(int total) {

        int lastPageNum = 0;

        if(total % 5 == 0){
            lastPageNum = total / 5;
        }else{
            lastPageNum = total / 5 + 1;
        }

        return lastPageNum;
    }

    // 페이지 그룹
    public int[] getPageGroupNum(int currentPage, int lastPageNum) {
        int currentPageGroup = (int)Math.ceil(currentPage / 5.0);
        int pageGroupStart = (currentPageGroup - 1) * 5 + 1;
        int pageGroupEnd = currentPageGroup * 5;

        if(pageGroupEnd > lastPageNum){
            pageGroupEnd = lastPageNum;
        }

        int[] result = {pageGroupStart, pageGroupEnd};

        return result;
    }

    // 페이지 시작번호
    public int getPageStartNum(int total, int currentPage) {
        int start = (currentPage - 1) * 5;
        return total - start;
    }

    // 현재 페이지 번호
    public int getCurrentPage(String pg) {
        int currentPage = 1;

        if(pg != null){
            currentPage = Integer.parseInt(pg);
        }

        return currentPage;
    }

    // Limit 시작번호
    public int getStartNum(int currentPage) {
        return (currentPage - 1) * 5;
    }
}
