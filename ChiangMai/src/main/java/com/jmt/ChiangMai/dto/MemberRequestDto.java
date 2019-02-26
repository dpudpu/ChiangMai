package com.jmt.ChiangMai.dto;

import com.jmt.ChiangMai.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private Long id;

    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    private String email;

    @NotBlank(message = "닉네임을 작성해주세요.")
    @Size(min = 4, max = 12, message = "영문,숫자 4~12 또는 한글 2~6자리만 입력가능합니다.")
    private String nickname;

    @NotBlank(message = "패스워드를 작성해주세요.")
//    @Size(min = 8, max = 20, message ="8~20자리만 입력가능합니다.")
    private String password;

    @NotBlank(message = "성별을 선택해주세요.")
    private String gender;

    private LocalDateTime regdate;

//    public Member ToEntity(){
//        return new Member(email, nickname, gender);
//    }
}
