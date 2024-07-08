package com.shaping.shaping.service;

import com.shaping.shaping.domain.Member;
import com.shaping.shaping.mapper.MemberMapper;
import com.shaping.shaping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member signUp(Member member){
//      return memberRepository.save(member);
        memberMapper.addMember(member);

        return memberMapper.findById(member.getId());
    }
    public Member findMember(Long id){
        return memberRepository.findMemberById(id);
    }
}
