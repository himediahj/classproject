package com.firstcoding.todo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {

    private long tno;
    private String title;
    private String dueDate;
    private boolean finished;
}
