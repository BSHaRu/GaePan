package co.kr.gaepan.controller.cs;


import co.kr.gaepan.dto.board.BoardDTO;
import co.kr.gaepan.dto.cs.PageRequestDTO;
import co.kr.gaepan.dto.cs.PageResponseDTO;
import co.kr.gaepan.service.cs.CsBoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "cs/index"; // return 시작할 때 / 붙이지 않기
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
    public String noticeView(Model model, int bno) {

        // 글 조회
        BoardDTO boardDTO= csBoardService.findByNo(bno);
        log.info("boardDTO : " + boardDTO);

        model.addAttribute(boardDTO); // 속성이름 없이 바로 설정하는 건 이렇게 DTO만 가능한가봄

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
    public String qnaView(Model model, int bno) {

        // 글 조회
        BoardDTO boardDTO= csBoardService.findByNo(bno);
        log.info("boardDTO : " + boardDTO);
        //답변 조회
        BoardDTO response = csBoardService.findByParent(bno);
        log.info("response : " + response);

        model.addAttribute(boardDTO); // 속성이름 없이 바로 설정하는 건 이렇게 DTO만 가능한가봄
        model.addAttribute("response", response);

        return "cs/qna/view";
    }
    @GetMapping("/qna/write")
    public String qnaWrite(){

        return "cs/qna/write";
    }
    @PostMapping("/qna/write")
    public String qnaWrite(BoardDTO boardDTO){ // DTO 받을 때 regDate값은 자동으로 지정되는 건가??

        csBoardService.insertInquiry(boardDTO);

        // 가독성 위해 String.format 활용
        // return String.format("redirect:/cs/qna/list?group=%s&cate=%s", boardDTO.getGroup(), boardDTO.getCate());
        return "redirect:/cs/qna/list?group=" + boardDTO.getGroup() + "&cate=" + boardDTO.getCate();  // 파라미터 안 보내면 오류나겠지??

    }

}

