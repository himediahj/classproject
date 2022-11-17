package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginRequest {
    private String uid; // 파라미터 이름과 동일시켜놓음!
    private String pw;
}
