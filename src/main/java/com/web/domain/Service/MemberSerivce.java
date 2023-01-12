package com.web.domain.Service;

import com.web.domain.Dto.MemberDto;
import com.web.domain.Entity.Member.MemberEntity;
import com.web.domain.Entity.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.Console;
import java.util.List;

@Service
public class MemberSerivce {

    // ------------------------------------------------------ //
    @Autowired
    private MemberRepository memberRepository; // 맴버 리포지토리
    @Autowired
    private HttpServletRequest request;
    // ------------------------------------------------------ //

    // 회원가입
    @Transactional
    public int setmember(MemberDto memberDto){
        MemberEntity entity = memberRepository.save( memberDto.toEntity());
        System.out.println(memberDto);
        return entity.getMno();
    }
    @Transactional
    public int getmember(MemberDto memberDto){
        List<MemberEntity> entityList = memberRepository.findAll();
        for(MemberEntity entity : entityList){
            if(entity.getMid().equals(memberDto.getMid())){
                if(entity.getMpassword().equals(memberDto.getMpassword())){
                    request.getSession().setAttribute("loginMno" , entity.getMno());

                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }








}
