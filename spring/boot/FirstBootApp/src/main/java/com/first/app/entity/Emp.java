package com.first.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer empno;

    @Column
    private String ename;

    @Column
    private String job;

    @Column
    private Integer mgr;    // king은 상사가 없으니까 null이 들어오더라도 Integer는 0으로 자동변환해줌 int는 null 처리를 못 해줌

    @Column
    private LocalDate hiredate;

    @Column
    private Double sal;

    @Column
    private Double comm;

    /*@Column
    private Integer deptno;*/

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
}
