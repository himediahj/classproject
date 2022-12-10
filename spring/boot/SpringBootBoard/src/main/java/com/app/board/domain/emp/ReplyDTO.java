package com.app.board.domain.emp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {
    private int rno;
    private int empno;
    private int star;
    private String reply;
    private String replyer;
    private String replydate;
    private String updatedate;
}
