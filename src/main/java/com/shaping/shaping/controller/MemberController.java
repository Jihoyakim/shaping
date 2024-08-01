package com.shaping.shaping.controller;

import com.shaping.shaping.domain.MemberDto;
import com.shaping.shaping.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/signUpForm")
    public String signUpForm(){
        return "/member/signUpForm";
    }

    @GetMapping(value = "/loginPage")
    public String login(){
        return "/member/loginPage";
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestParam("name") String name,
//                                    @RequestParam("password") String password,
//                                    @RequestParam("email") String email,
//                                    @RequestParam("tel") String tel,
//                                    @RequestParam("sex") boolean sex,
//                                    @RequestParam("postcode") int postcode,
//                                    @RequestParam("roadAddress") String roadAddress,
//                                    @RequestParam("jibunAddress") String jibunAddress,
//                                    @RequestParam("detailA") String detailA) {
//
//        Address address = new Address(postcode,roadAddress,jibunAddress,detailA);
//
//        Member member = new Member(name,password,email,tel,sex, RoleType.USER, MemberStatus.Y, address);
//
//        memberService.signUp(member);
//
//        return new ResponseEntity<>("회원가입 성공!",HttpStatus.OK);
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody MemberDto memberDto) {
        // 회원가입 로직 처리
        memberService.signUp(memberDto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "회원가입 성공!"); // 성공 메시지
        response.put("redirectUrl", "/"); // 리다이렉트할 URL

        return new ResponseEntity<>(response, HttpStatus.CREATED); // JSON 응답 반환

    }

}
