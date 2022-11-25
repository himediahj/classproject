package com.spring.todolist.service.todo;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoRegService {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    public int insertTodo(TodoDTO todoDTO){
        return todoMapper.insert(todoDTO);
    }
}
