package com.firstcoding.todo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {
    private int idx;
    private String uid;
    private String pw;
    private String uuid;
}
