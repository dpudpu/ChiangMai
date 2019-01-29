package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.domain.Role;
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
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));

        Member memberInfo = memberRepository.save(member);

        Set<Role> roles = roleRepository.findByName("USER");
        memberInfo.setRoles(roles);

        return memberInfo;
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
    public boolean checkNickname(String nickname) {
        return memberRepository.existsMemberByNickname(nickname);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkEmail(String email) {
        return memberRepository.existsMemberByEmail(email);
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
        BeanUtils.copyProperties(member,memberId);
        return memberId;
    }

    @Override
    @Transactional
    public int modifyMemberRoles(Long id, Long[] roles) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> searchMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> searchMembersByWord(String searchWord, String searchType, Pageable pageable) {
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
    public Member getMember(String email){
        return memberRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id){
        return memberRepository.getOne(id);
    }
}
