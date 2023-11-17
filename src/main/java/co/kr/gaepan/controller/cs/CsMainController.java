package co.kr.gaepan.controller.cs;


import co.kr.gaepan.dto.cs.PageRequestDTO;
import co.kr.gaepan.dto.cs.PageResponseDTO;
import co.kr.gaepan.service.cs.CsBoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cs/*")
@Controller
@Log4j2
public class CsMainController {

    @Autowired
    private CsBoardService csBoardService;

    @GetMapping("/index")
    public String index(){
        return "cs/index"; // return 시작할 때 / 붙이지 않기w
    }
    @GetMapping("/qna/list")
    public String qnaList(Model model, PageRequestDTO pageRequestDTO){ // DTO 속성으로 group, cate 있으므로 파라미터 받을 수 있음

        // pg 값이 변경될 때마다 호출하여 offset 갱신
        pageRequestDTO.updateOffset();
        // ToString 이용해서 pageRequestDTO 속성 확인
        log.info("qnaList...1 : " + pageRequestDTO);

        PageResponseDTO pageResponseDTO = csBoardService.findByGroupAndCate(pageRequestDTO);
        log.info("pageResponseDTO : " + pageResponseDTO);

        model.addAttribute(pageResponseDTO);

        return "cs/qna/list";
    }
    @GetMapping("/qna/view")
    public String qnaView() {

        return "cs/qna/view";
    }
    @GetMapping("/qna/write")
    public String qnaWrite(){

        return "cs/qna/write";
    }
    @GetMapping("/notice/list")
    public String noticeList(Model model, PageRequestDTO pageRequestDTO){ // DTO 속성으로 group, cate 있으므로 파라미터 받을 수 있음

        // pg 값이 변경될 때마다 호출하여 offset 갱신
        pageRequestDTO.updateOffset();
        // ToString 이용해서 pageRequestDTO 속성 확인
        log.info("noticeList...1 : " + pageRequestDTO);

        PageResponseDTO pageResponseDTO = csBoardService.findByGroupAndCate(pageRequestDTO);
        log.info("pageResponseDTO : " + pageResponseDTO);

        model.addAttribute(pageResponseDTO);

        return "cs/notice/list";
    }
    @GetMapping("/notice/view")
    public String noticeView(){

        return "cs/notice/view";
    }
    @GetMapping("/faq/list")
    public String faqList(Model model, PageRequestDTO pageRequestDTO){ // DTO 속성으로 group, cate 있으므로 파라미터 받을 수 있음

        // pg 값이 변경될 때마다 호출하여 offset 갱신
        pageRequestDTO.updateOffset();
        // ToString 이용해서 pageRequestDTO 속성 확인
        log.info("faqList...1 : " + pageRequestDTO);

        PageResponseDTO pageResponseDTO = csBoardService.findByGroupAndCate(pageRequestDTO);
        log.info("pageResponseDTO : " + pageResponseDTO);

        model.addAttribute(pageResponseDTO);

        return "cs/faq/list";
    }
}

