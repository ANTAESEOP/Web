package com.web.domain.Entity.Member;

import com.web.domain.Dto.MemberDto;
import com.web.domain.Entity.Board.BoardEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당연결된 DB의 테이블과 매핑[연결]
@Table(name="member") // db에서 사용될 테이블 이름
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동번호 부여
    private int mno;            // 회원번호 필드

    @Column(nullable = false) // not null
    private String mid;      // 회원아이디 필드

    @Column(nullable = false)
    private String mpassword;   // 회원비밀번호 필드

    @Column(nullable = false)
    private String mname; // 회원 이름 필드

    @Column(nullable = false)
    private String mphone;      // 회원 전화번호 필드

    @OneToMany(mappedBy = "memberEntity") // [ 1:n] PK 에 해당 어노테이션   mappedBy="fk필드명"
    @Builder.Default // 빌더 사용시 해당 필드의 초기값 설정
    @ToString.Exclude
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();

    }
}

