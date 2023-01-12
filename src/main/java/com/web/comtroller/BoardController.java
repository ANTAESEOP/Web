package com.web.comtroller;

import com.web.domain.Dto.BoardDto;
import com.web.domain.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    // --------------------------------- 전역 객체  ---------------------------------- //
    @Autowired // 스프링 컨테이너 빈 생성 [ 외부에 메모리 위임 ]
    private BoardService boardService; // 서비스 객체 생성
    // --------------------------------- 전역 객체  ---------------------------------- //

    // 글 작성
    @PostMapping("/setboard")
    public boolean setboard( BoardDto boardDto){
        return boardService.setboard(boardDto);
    }
    @GetMapping("/getboard")
    public List<BoardDto> getboard(){
        return boardService.getboard();
    }
    // 글 리스트










}
