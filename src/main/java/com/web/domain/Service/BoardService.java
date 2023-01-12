package com.web.domain.Service;

import com.web.domain.Dto.BoardDto;
import com.web.domain.Entity.Board.BoardEntity;
import com.web.domain.Entity.Board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    // ------------------------------------------------------ //
    @Autowired
    private BoardRepository boardRepository; // 보드 리포지토리
    // ------------------------------------------------------ //


    @Transactional
    public boolean setboard(BoardDto boardDto){
        BoardEntity entity = boardRepository.save(boardDto.toEntity());
        return true;
    }

    @Transactional
    public List<BoardDto> getboard(){
        List<BoardEntity> entityList = boardRepository.findAll();
        List<BoardDto> dtolist = new ArrayList<>();
        entityList.forEach( e -> dtolist.add( e.toDto() ) );
        return dtolist;
    }
}
