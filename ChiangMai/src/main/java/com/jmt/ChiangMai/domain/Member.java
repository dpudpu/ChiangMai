package com.jmt.ChiangMai.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "닉네임을 작성해주세요.")
    @Size(min = 4, max = 12, message = "영문,숫자 4~12 또는 한글 2~6자리만 입력가능합니다.")
    @Column(unique = true, nullable = false)
    private String nickname;

    @NotBlank(message = "패스워드를 작성해주세요.")
//    @Size(min = 8, max = 20, message ="8~20자리만 입력가능합니다.")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @NotBlank(message = "성별을 선택해주세요.")
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date regdate;

    @OneToMany(mappedBy = "member")
    private Set<Review> reviews;

    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "favorites",
            joinColumns=@JoinColumn(name="member_id"),
            inverseJoinColumns = @JoinColumn(name="shop_id"))
    private Set<Shop> shops;

}
