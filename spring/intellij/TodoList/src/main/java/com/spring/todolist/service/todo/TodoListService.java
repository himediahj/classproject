package com.spring.todolist.service.todo;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public List<TodoDTO> getList(){
        return todoMapper.selectAll();
    }
}
