package com.todo.todospring.service;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
@Log4j2
public class TodoService {
    @Autowired(required = false)
    private TodoMapper todoMapper;


    public List<TodoDTO> getTodoList() {

        log.info("TodoService getTodoList...");
        List<TodoDTO> list = null;
        try {
             list = todoMapper.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public TodoDTO getTodoRead(long tno) {
        log.info("TodoService getTodoRead...");
        TodoDTO todo = null;
        try {

            todo = todoMapper.selectByTno(tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return todo;
    }

    public int getTodoRegister(TodoDTO todo) {
        log.info("TodoService getTodoRegister...");
        int result = 0;
        try {

            result = todoMapper.insertTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int getTodoModify(TodoDTO todo) {
        log.info("TodoService getTodoModify...");
        int result = 0;
        try {

            result = todoMapper.updateTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int getTodoRemove(long tno) {
        log.info("TodoService getTodoRemove...");
        int result = 0;
        try {

            result = todoMapper.deleteTodo(tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
