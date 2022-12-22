package com.app.board.service.todo;

import com.app.board.domain.todo.SearchTodo;
import com.app.board.entity.Todo;
import com.app.board.repository.BoardTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private BoardTodoRepository boardTodoRepository;

    public List<Todo> selectAll(int writer){
        return boardTodoRepository.findByWriter_IdxOrderByDueDateAsc(writer);
    }

    public List<Todo> selectActive(int writer){
        return boardTodoRepository.findByWriter_IdxAndFinishedFalseOrderByDueDateAsc(writer);
    }

    public List<Todo> selectByTodo(SearchTodo searchTodo, int writer){
        return boardTodoRepository.findByTodoContainsIgnoreCaseAndWriter_IdxOrderByDueDateAsc(searchTodo.getKeyword(), writer);
    }
}
