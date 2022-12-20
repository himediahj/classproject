package com.app.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "boardtodo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer tno;

    @Column
    private String todo;

    @ManyToOne
    @JoinColumn(name = "writer")
    private BoardMember writer;

    @Column(name = "duedate")
    private LocalDate dueDate;

    @Column
    private boolean finished;


}
