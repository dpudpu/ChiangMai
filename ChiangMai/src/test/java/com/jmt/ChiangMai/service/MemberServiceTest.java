package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void 회원가입() {
        Member member = new Member().builder()
                .email("test@test")
                .gender("남자")
                .id(101L)
                .nickname("testNick")
                .password("1234")
                .build();

        System.out.println("----------------------");
        if (memberService.signUp(member) != null) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }

        System.out.println(memberService.login("test@test", "1234") != null ? 1 : 2);
    }

    @Test
    public void 전체조회() {
        Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "regdate");
        Page<Member> members = memberService.searchMembers(pageable);

        for (Member m : members)
            System.out.println(m.getEmail() + " / " + m.getPassword());
        System.out.println(members.getTotalElements());
        System.out.println(members.getTotalPages());
    }

    @Test
    public void 이메일또는닉네임검색() {
        Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "regdate");
        String searchType = "email";
        String searchWord = "dpudpu";
        Page<Member> members = memberService.searchMembersByWord(searchWord, searchType, pageable);

        for (Member m : members)
            System.out.println(m.getEmail() + " / " + m.getPassword());
        System.out.println(members.getTotalElements());
        System.out.println(members.getTotalPages());

        searchType = "nickname";
        searchWord = "대준";
        members = memberService.searchMembersByWord(searchWord, searchType, pageable);

        for (Member m : members)
            System.out.println(m.getNickname() + " / " + m.getPassword());
        System.out.println(members.getTotalElements());
        System.out.println(members.getTotalPages());
    }

    @Test
    public void 회원수정() {
        Member member = memberService.login("dpudpu11@gmail.com", "1234");
        member.setPassword("3456");
        Member member1 = memberService.modifyMemberInfo(member);

        System.out.println(member1.getPassword());
        this.회원가입();
        this.전체조회();
    }

    @Test
    public void 회원탈퇴() {
        memberService.withdrawMember("dpudpu11@gmail.com", "1234");
        this.전체조회();
    }


}
