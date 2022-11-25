package com.spring.todolist.domain;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {
    private long tno;

    @NotEmpty(message = "필수 입력값입니다.")
    private String title;

    @Future
    private LocalDate dueDate;
    private boolean finished;
}
