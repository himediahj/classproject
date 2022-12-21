package com.app.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "boardmember")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idx;

    @Column
    private String userid;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String role;

    @Column(insertable = false)
    private LocalDateTime regdate;

    @Column(insertable = false)
    private LocalDateTime editdate;


}
