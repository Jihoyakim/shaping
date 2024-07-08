package com.shaping.shaping.controller;

import com.shaping.shaping.domain.Member;
import com.shaping.shaping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/signUpForm")
    public String signUpForm(){
        return "/member/signUpForm";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "/member/login";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestParam("name") String name,
                                    @RequestParam("password") String password,
                                    @RequestParam("email") String email,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("sex") boolean sex) {
        Member member = new Member(name,password,email,tel,sex);
        memberService.signUp(member);
        return new ResponseEntity<>("회원가입 성공!",HttpStatus.OK);
    }


}
