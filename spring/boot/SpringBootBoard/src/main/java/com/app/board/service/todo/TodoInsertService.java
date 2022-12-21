package com.app.board.service.todo;

import com.app.board.domain.todo.TodoDTO;
import com.app.board.entity.Todo;
import com.app.board.repository.BoardTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class TodoInsertService {
    @Autowired
    private BoardTodoRepository boardTodoRepository;

    public Todo insertTodo(TodoDTO todoDTO){
        Todo todo = todoDTO.toTodoEntity();
        return boardTodoRepository.save(todo);
    }

}
