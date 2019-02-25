package com.jmt.ChiangMai.config;

import com.jmt.ChiangMai.security.LoginFailureHandler;
import com.jmt.ChiangMai.security.LoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

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
                    .antMatchers("/shops/edit").hasRole("USER")
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/session")
                    .defaultSuccessUrl("/")
                    .successHandler(successHandler())
                    .failureHandler(failureHandler())
                    .usernameParameter("email")
                    .and()
                .logout()
                    .deleteCookies("JSESSIONID")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .rememberMe()
                    .key("uniqueAndSecret")
                    .tokenValiditySeconds(2592000) // 한 달
                    .rememberMeParameter("remember-me")
                    .userDetailsService(userDetailsService)
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
