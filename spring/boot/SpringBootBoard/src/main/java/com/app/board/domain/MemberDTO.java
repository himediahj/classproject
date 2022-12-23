package com.app.board.domain;

import com.app.board.entity.BoardMember;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {

    private Integer idx;
    @NotBlank
    private String userid;
    private String password;
    private String username;

    public BoardMember toMemberEntity(){
        return BoardMember.builder()
                .idx(idx)
                .userid(userid)
                .password(password)
                .username(username)
                .build();
    }

}
