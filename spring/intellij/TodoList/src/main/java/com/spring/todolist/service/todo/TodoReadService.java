package com.spring.todolist.service.todo;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoReadService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public TodoDTO getTodo(long tno){
        return todoMapper.selectBy(tno);
    }
}
