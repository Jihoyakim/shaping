package com.shaping.shaping.config;

import com.shaping.shaping.security.CustomAuthenticationFilter;
import com.shaping.shaping.security.CustomAuthenticationProvider;
import com.shaping.shaping.security.CustomUserDetailService;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailService customUserDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // 비밀번호 암호화
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public AuthenticationManager authenticationManager() {
        CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider(customUserDetailService, passwordEncoder());
        return new ProviderManager(Collections.singletonList(customAuthenticationProvider));
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        customAuthenticationFilter.setFilterProcessesUrl("/member/auth");

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequest ->
                        authorizeRequest
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() //  스프링 부트 3.0부터 적용된 스프링 시큐리티 6.0 부터 forward 방식 페이지 이동에도 default로 인증이 걸리도록 변경되어서 JSP나 타임리프 등 컨트롤러에서 화면 파일명을 리턴해 ViewResolver가 작동해 페이지 이동을 하는 경우 위처럼 설정을 추가하셔야 합니다.
                                .requestMatchers("/","/member/signup","/member/loginPage","/member/auth","/member/signUpForm").permitAll()
                                .requestMatchers("/error","/resources/**","/webapp/**","/checkRole","/session-info").permitAll()
                                .requestMatchers(("/admin/**")).hasRole("ADMIN")
                                .anyRequest().authenticated()

                )
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(log ->
                        log.logoutUrl("/member/logout")
                                .logoutSuccessUrl("/?logout=true")
                                .deleteCookies("JSESSIONID")
                                .invalidateHttpSession(true) // 세션 무효화
                                .permitAll()
                )
                .headers(headersConfigurer ->
                        headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )
                .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        firewall.setAllowUrlEncodedDoubleSlash(true);
        firewall.setAllowBackSlash(true);
        return firewall;
    }
}
