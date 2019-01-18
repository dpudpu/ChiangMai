package com.jmt.ChiangMai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/members/login")
                    .loginProcessingUrl("/members/login").permitAll()
                    .defaultSuccessUrl("/")
                    .successHandler(successHandler())
                    .usernameParameter("email")
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .headers(); //  headers ( ) 메서드로 보안 헤더를 활성화하면 브라우저가 더 이상 페이지를 캐시하지 않습니다;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new LoginSuccessHandler("/");
    }
}
