package com.shaping.shaping.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfig{

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // csrf 비활성화
                .formLogin(AbstractHttpConfigurer::disable) // form 로그인 비활성화
                .authorizeHttpRequests(authorieRequest ->
                        authorieRequest
//                                .requestMatchers(AntPathRequestMatcher.antMatcher("/member/login")).authenticated() // 여긴 권한
                                .anyRequest().permitAll() // 권한 없음
                )
                .headers( headersConfigurer ->
                        headersConfigurer
                                .frameOptions(
                                        HeadersConfigurer.FrameOptionsConfig::sameOrigin
                                )
                );
        return http.build();
    }

}
