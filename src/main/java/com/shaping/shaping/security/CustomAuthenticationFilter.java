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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new AuthenticationException("이메일 또는 비밀번호를 입력하세요.") {};
        }

        email = email.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);

        return authenticationManager.authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        // 로그인 성공 시 처리 로직
        HttpSession session = request.getSession();
        session.setAttribute("username", authResult.getName());

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        String roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)

                .collect(Collectors.joining(","));

        session.setAttribute("userRole", roles);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);

        session.setAttribute("SPRING_SECURITY_CONTEXT", context);

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
