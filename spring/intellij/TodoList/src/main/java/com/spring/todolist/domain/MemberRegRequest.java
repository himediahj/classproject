package com.spring.todolist.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberRegRequest {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String uid;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String pw;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z가-힣]{1,64}", message = "빈값이나 공백이 들어갈 수 없습니다.")
    private String uname;
    private MultipartFile uphoto;

    public Member toMember(){
        Member member = Member.builder()
                .uid(this.uid)
                .pw(this.pw)
                .uname(this.uname)
                .build();
        return member;
    }
}
