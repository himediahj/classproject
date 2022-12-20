package com.app.board.domain.todo;

import com.app.board.entity.BoardMember;
import com.app.board.entity.Todo;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {
    private int tno;
    private String todo;
    private Integer writer;
    private LocalDate dueDate;
    private boolean finished;

    public Todo toTodoEntity(){
        return Todo.builder()
                .tno(tno)
                .todo(todo)
                .writer(BoardMember.builder().idx(writer).build())
                .dueDate(dueDate)
                .finished(finished)
                .build();
    }
}
