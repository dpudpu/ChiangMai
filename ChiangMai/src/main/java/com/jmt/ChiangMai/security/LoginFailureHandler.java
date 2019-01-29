package com.jmt.ChiangMai.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect("/session?failure=true&email="+request.getParameter("email"));

        // 왜 POST로 전송되지? (Request method 'POST' not supported)
//        request.setAttribute("email",request.getParameter("email"));
//        request.setAttribute("failure",true);
//        request.getRequestDispatcher("/members/login").forward(request,response);
    }
}
