package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "/members/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute Member member) {
        if (memberService.signUp(member) != null)
            return "redirect:/";
        else//TODO 회원가입 실패시 에러 처리
            return "/error";
    }
}
