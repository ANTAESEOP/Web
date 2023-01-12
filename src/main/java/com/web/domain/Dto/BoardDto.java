package com.web.domain.Dto;

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
}
