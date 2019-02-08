package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.domain.Role;
import com.jmt.ChiangMai.exception.ValidCustomException;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public Member signUp(Member member) {
        verifyDuplicateEmail(member.getEmail());
        verifyDuplicateNickname(member.getNickname());

        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));

        Member memberInfo = memberRepository.save(member);

        Set<Role> roles = roleRepository.findByName("USER");
        memberInfo.setRoles(roles);

        return memberInfo;
    }

    private void verifyDuplicateEmail(String email) {
        if (memberRepository.existsMemberByEmail(email)) {
            throw new ValidCustomException("이미 사용중인 이메일주소입니다", "email");
        }
    }

    private void verifyDuplicateNickname(String nickname) {
        if (memberRepository.existsMemberByNickname(nickname)) {
            throw new ValidCustomException("이미 사용중인 닉네임입니다", "nickname");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Member login(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void withdrawMember(String email, String password) {
        Member member = memberRepository.findByEmailAndPassword(email, password);
        if (member != null)
            memberRepository.delete(member);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkPassword(String password) {
        return memberRepository.existsMemberByPassword(password);
    }

    @Override
    @Transactional
    public Member modifyMemberInfo(Member member) {
        Member memberId = memberRepository.getOne(member.getId());
        BeanUtils.copyProperties(member, memberId);
        return memberId;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> getMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> getMembersByWord(String searchWord, String searchType, Pageable pageable) {
        Page<Member> members = null;
        switch (searchType) {
            case "email":
                members = memberRepository.findByEmailContaining(searchWord, pageable);
                break;
            case "nickname":
                members = memberRepository.findByNicknameContaining(searchWord, pageable);
                break;
        }
        return members;
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id) {
        return memberRepository.getOne(id);
    }
}
