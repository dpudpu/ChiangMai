package com.jmt.ChiangMai.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class MemberDetails extends User {
    private String nickname;
    private Long id;

    public MemberDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, true, true, true, true, authorities);
    }
}

