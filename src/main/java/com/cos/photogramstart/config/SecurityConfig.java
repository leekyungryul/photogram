package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean // IoC 등록 (해당 메서드의 리턴되는 오브젝트를 IoC로 등록)
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음)
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .loginProcessingUrl("/auth/signin") // POST 요청이 들어오면 스프링 시큐리티가 로그인 프로세스 진행
                .defaultSuccessUrl("/");

    }
}
