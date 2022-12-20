package com.app.board.service.todo;

import com.app.board.domain.todo.TodoDTO;
import com.app.board.entity.Todo;
import com.app.board.repository.BoardTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoInsertService {
    @Autowired
    private BoardTodoRepository boardTodoRepository;

    public Todo insertTodo(TodoDTO todoDTO){
        Todo todo = todoDTO.toTodoEntity();
//        todo.setDueDate(todoDTO.getDueDate());
        todo.setFinished(false);
        return boardTodoRepository.save(todo);
    }
}
