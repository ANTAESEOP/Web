package com.web.domain.Dto;

import com.web.domain.Entity.Board.BoardEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int bno;            // 글 번호
    private String btitle;      // 글 제목
    private String bcontent;    // 글 내용

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }
}
