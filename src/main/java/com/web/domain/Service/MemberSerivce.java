package com.web.domain.Service;

import com.web.domain.Dto.MemberDto;
import com.web.domain.Entity.Member.MemberEntity;
import com.web.domain.Entity.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.io.Console;

@Service
public class MemberSerivce {

    // ------------------------------------------------------ //
    @Autowired
    private MemberRepository memberRepository; // 맴버 리포지토리
    // ------------------------------------------------------ //

    // 회원가입
    @Transactional
    public int setmember(MemberDto memberDto){
        MemberEntity entity = memberRepository.save( memberDto.toEntity());
        System.out.println(memberDto);
        return 1;
    }

}
