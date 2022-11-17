package com.todo.mvc.todo.service;

import com.todo.mvc.todo.dao.TodoDao;
import com.todo.mvc.todo.dao.TodoDaoImpl;

public class TodoService {
    private final TodoDao todoDao;

    private static TodoService instance = new TodoService();

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }
    public TodoService() {
        this.todoDao = new TodoDaoImpl();
    }

    public static TodoService getInstance(){
        return instance;
    }
}
