package com.spring.todolist.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
    private int idx;
    private String uid;
    private String pw;
    private String uuid;
    private String uname;
    private String uphoto;

    public LoginInfo toLoginInfo(){
        return LoginInfo.builder()
                .uid(this.uid)
                .uname(this.uname)
                .uphoto(this.uphoto)
                .build();
    }
}
