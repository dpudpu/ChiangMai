package com.jmt.ChiangMai.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**", "/css/**", "/script/**", "/images/**", "/fonts/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //isAuthenticated() - Returns true if the user is not anonymous
        //isFullyAuthenticated() - Returns true if the user is not an anonymous or a remember-me user
        http
                .authorizeRequests()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/members/login")
                    .defaultSuccessUrl("/")
                    .successHandler(successHandler())
                    .failureHandler(failureHandler())
                    .usernameParameter("email")
                    .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .headers(); //  headers ( ) 메서드로 보안 헤더를 활성화하면 브라우저가 더 이상 페이지를 캐시하지 않습니다;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new LoginSuccessHandler("/");
    }
    @Bean
    public AuthenticationFailureHandler failureHandler() { return new LoginFailureHandler();
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

}
