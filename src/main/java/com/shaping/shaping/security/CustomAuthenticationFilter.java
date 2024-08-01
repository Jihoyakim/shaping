package com.shaping.shaping.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final CustomUserDetailService customUserDetailService;

    private final AuthenticationManager authenticationManager;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new AuthenticationException("이메일 또는 비밀번호를 입력하세요.") {};
        }

        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(email);

        if(!password.equals(customUserDetails.getPassword())) {
            throw new AuthenticationException("비밀번호를 확인해주세요.") {};
        }
//        String passwordWithNoOp = "{noop}" + password;

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password,customUserDetails.getAuthorities());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        // 로그인 성공 시 처리 로직
        HttpSession session = request.getSession();
        session.setAttribute("username", authResult.getName());

        response.sendRedirect("/"); // 로그인 성공 시 이동할 URL
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        // 로그인 실패 시 처리 로직

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8"); // 문자 인코딩 설정
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized 상태 코드
        response.getWriter().write("{\"error\": \"" + failed.getMessage() + "\"}");
    }
}
