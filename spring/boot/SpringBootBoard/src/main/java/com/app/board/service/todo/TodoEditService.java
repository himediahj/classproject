package com.app.board.service.todo;

import com.app.board.domain.todo.TodoDTO;
import com.app.board.entity.Todo;
import com.app.board.repository.BoardTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoEditService {
    @Autowired
    private BoardTodoRepository boardTodoRepository;

    public int updateTodo(TodoDTO todoDTO){
        Todo todo = todoDTO.toTodoEntity();
        return boardTodoRepository.save(todo) != null? 1 : 0;
    }
}
