package com.spring.todolist.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {
    private String uid;
    private String uname;
    private String uphoto;
}
