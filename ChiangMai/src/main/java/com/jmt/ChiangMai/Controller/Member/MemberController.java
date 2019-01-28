package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
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
        return "/members/login";
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "/members/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute Member member) {
        if (memberService.signUp(member) != null)
            return "redirect:/members/login";
        else//TODO 회원가입 실패시 에러 처리
            return "/error";
    }
}
