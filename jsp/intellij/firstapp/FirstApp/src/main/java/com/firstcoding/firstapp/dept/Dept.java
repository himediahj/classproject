package com.firstcoding.firstapp.dept;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor  // 매개변수 없는 default 생성자
@Getter
@Setter
@ToString
@Builder
public class Dept {
    private int deptno;
    private String dname;
    private String loc;

}
