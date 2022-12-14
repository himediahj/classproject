package com.first.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dept")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Dept {
    @Id // 필수!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mysql mariaDB -> autoIncrement 기능과 같다
    @Column
    private Integer deptno;

    @Column(length = 20, nullable = false)
    private String dname;

    @Column(length = 20, nullable = false)
    private String loc;
}
