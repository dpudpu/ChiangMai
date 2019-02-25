package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public String signUpForm() {
        return "/members/signUp";
    }

    @PostMapping
    @ResponseBody
    public Member signUp(@Valid @ModelAttribute Member member) {
        return memberService.signUp(member);
    }

    @GetMapping("/{memberId}")
    public String getMemberInfo(@PathVariable Long id) {
        // TODO view
        Member member = memberService.getMember(id);
        return null;
    }

    @GetMapping("/modify/{memberId}")
    public String modify(@PathVariable Long id, Model model) {
        // TODO view
        model.addAttribute(memberService.getMember(id));
        return null;
    }

    @PutMapping("/{memberId}")
    public String modify(@PathVariable Member member) {
        // TODO view
        Member memberInfo = memberService.modifyMemberInfo(member);
        return "redirect:/members/" + memberInfo.getId();
    }

    @DeleteMapping("/{memberId}")
    public String delete() {
        return "redirect:/";
    }
}
