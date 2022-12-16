package com.app.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer bno;

    @Column
    private String title;

    @Column
    private String content;

    @Column(updatable = false)
    private String writer;

    @Column
    private String photo;

    @Column(insertable = false, updatable = false) // 테이블에서 자동으로 default값 들어가니까, 수정할 때 제외되어야 하니까
    private LocalDate regdate;

    @Column(insertable = false)
    private LocalDate updatedate;

}
