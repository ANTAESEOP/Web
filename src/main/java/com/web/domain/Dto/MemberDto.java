package com.web.domain.Dto;

import com.web.domain.Entity.Member.MemberEntity;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {

    private int mno;            // 회원 번호
    private String mid;         // 회원 아이디
    private String mpassword;   // 회원 비밀번호
    private String mname;       // 회원 이름
    private String mphone;         // 회원 전화번호

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();
    }
}

