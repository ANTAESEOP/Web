package com.web.domain.Entity.Board;

import com.web.domain.Dto.BoardDto;
import com.web.domain.Entity.Member.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Entity // Entity 정의
@Table(name = "board") // 테이블명 정의
@AllArgsConstructor // 풀생성자
@NoArgsConstructor // 깡통 ( 빈 생성자 )
@Getter // 호출
@Setter // 저장
@Builder // builder
@ToString
public class BoardEntity {
    // 1. 필드
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int bno;            // 게시물 번호

    @Column(nullable = false)
    private String btitle;      // 게시물 제목

    @Column(nullable = false , columnDefinition = "TEXT")
    private String bcontent;    // 게시물 내용

    @ManyToOne
    @JoinColumn(name="mno")
    @ToString.Exclude
    private MemberEntity memberEntity;

/*    // 연관관계2 [ 카테고리번호[pk] <--양방향--> 게시물번호[fk]
    @ManyToOne
    @JoinColumn(name="bcno")
    @ToString.Exclude
    private BcategoryEntity bcategoryEntity;*/

    // 1. 형번환
    public BoardDto toDto(){
        // * 빌더 패턴을 이용한 객체 생성
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }
}

