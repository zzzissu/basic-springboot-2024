package com.zzzissu.backboard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// 스프링 시큐리티 핵심파일!
// 생성 1
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http. -> 버전이 바뀔때 마다 자주 바뀜
        // http://localhost:8080/** 로그인 하지 않고도 접근할 수 있는 권한을 주겠다.
        http
            .authorizeHttpRequests((atr) -> atr.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
            // CSRF 위변조 공격을 막는 부분 해제, 특정 URL은 csrf공격 리스트에서 제거
            .csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
            //h2-console 페이지가 frameset, frame으로 구성 CORS와 유사한 옵션추가
            .headers((headers) -> headers
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN  // ignoringRequestMatchers 영역에 있는 프레임이니까 해제해줘.
                )))
                // 로그인 url을 지정 ~/member/login, 로그인 성공하면 루트로 변경
                .formLogin((fl) -> fl.loginPage("/member/login").defaultSuccessUrl("/"))
            ;

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 암호화를 빈으로 생성
    }
}
