package com.shaping.shaping.service;

import com.shaping.shaping.domain.Member;
import com.shaping.shaping.domain.MemberDto;
import com.shaping.shaping.enums.MemberStatus;
import com.shaping.shaping.enums.RoleType;
import com.shaping.shaping.mapper.MemberMapper;
import com.shaping.shaping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

//    public Member signUp(Member member){
////      return memberRepository.save(member);
//        memberMapper.addMember(member);
//
//        return memberMapper.findById(member.getId());
//    }
    public void signUp(MemberDto memberDto){

        Member member = new Member(memberDto, RoleType.USER, MemberStatus.Y);
        memberRepository.save(member);
//        memberMapper.addMember(member);
    }
    public Member findMember(Long id){
        return memberRepository.findMemberById(id);
    }

    public Member findMemberByEmail(String email){ return memberRepository.findMemberByEmail(email);}
}
