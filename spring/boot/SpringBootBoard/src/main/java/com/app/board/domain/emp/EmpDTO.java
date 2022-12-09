package com.app.board.domain.emp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpDTO {
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private double sal;
    private double comm;
    private String deptno;
}
