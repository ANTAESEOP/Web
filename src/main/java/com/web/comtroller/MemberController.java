package com.web.comtroller;

import com.web.domain.Dto.MemberDto;
import com.web.domain.Service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/member")
public class MemberController {
    // --------------------------------- 전역 객체  ---------------------------------- //
    @Autowired // 스프링 컨테이너 빈 생성 [ 외부에 메모리 위임 ]
    private MemberSerivce memberService; // 서비스 객체 생성
    // --------------------------------- 전역 객체  ---------------------------------- //

    @PostMapping("/setmember")
    public int setmember( @RequestBody MemberDto memberDto){
        int result = memberService.setmember(memberDto);
        return result;
    }

}
