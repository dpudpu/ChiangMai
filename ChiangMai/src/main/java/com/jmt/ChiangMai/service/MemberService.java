package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    Member signUp(Member member);

    Member login(String email, String password);

    void withdrawMember(String email, String password);

    Member getMember(String email);

    Member getMember(Long id);

    Member modifyMemberInfo(Member member);

    boolean checkPassword(String password);

    Page<Member> getMembers(Pageable pageable);

    Page<Member> getMembersByWord(String searchWord, String searchType, Pageable pageable);

}
