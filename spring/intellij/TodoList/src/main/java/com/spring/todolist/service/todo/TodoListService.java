package com.spring.todolist.service.todo;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.domain.TodoSearchOption;
import com.spring.todolist.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TodoListService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public List<TodoDTO> getList(){
        return todoMapper.selectAll();
    }

    public List<TodoDTO> getSearchList(TodoSearchOption searchOption){
        log.info("getSearchList Service ...");
        return todoMapper.selectByOption(searchOption);
    }

}
