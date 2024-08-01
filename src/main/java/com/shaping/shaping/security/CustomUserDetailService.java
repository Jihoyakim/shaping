package com.shaping.shaping.security;

import com.shaping.shaping.domain.Member;
import com.shaping.shaping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByEmail(email);
        if (member == null || member.getEmail() == null || member.getEmail().isEmpty()) {
            throw new UsernameNotFoundException("이메일에 해당하는 회원을 찾을 수 없습니다. ");
        }
        return new CustomUserDetails(member);
    }
}
