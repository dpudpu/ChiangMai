package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    Member signUp(Member member);

    Member login(String email, String password);

    void withdrawMember(String email, String password);

    boolean checkNickname(String nickname);

    boolean checkEmail(String email);

    boolean checkPassword(String password);

    Member modifyMemberInfo(Member member);

    int modifyMemberRoles(Long id, Long[] roles);

    Page<Member> searchMembers(Pageable pageable);

    Page<Member> searchMembersByWord(String searchWord, String searchType, Pageable pageable);

}