package com.jmt.ChiangMai.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {

    @GetMapping
    public String loginForm(Model model,
                            HttpServletRequest req,
                            @RequestParam(value = "failure", defaultValue = "false") String failure,
                            @RequestParam(value = "email", defaultValue = "") String email) {
        if(failure.equals("true")){
            model.addAttribute("failure", true);
            model.addAttribute("email",email);
        }else {
            String referer = req.getHeader("Referer");
            req.getSession().setAttribute("prevPage", referer);
        }
        return "/session/login";
    }
}
