package com.jmt.ChiangMai.security;

import com.jmt.ChiangMai.domain.Member;
import com.jmt.ChiangMai.domain.Role;
import com.jmt.ChiangMai.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    public final MemberService memberService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberService.getMember(email);
        if(member==null)
            throw new UsernameNotFoundException(email+" is not found !");

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        member.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));

        MemberDetails memberDetails = new MemberDetails(email, member.getPassword(), authorities);
        memberDetails.setId(member.getId());
        memberDetails.setNickname(member.getNickname());

        return memberDetails;
    }
}
