package com.todo.todospring.dao;

import com.todo.todospring.domain.TodoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    public List<TodoDTO> selectAll(Connection conn) throws SQLException;
    public TodoDTO selectBy(Connection conn, long tno) throws SQLException;
    public int insert(Connection conn, TodoDTO todo) throws SQLException;
    public int update(Connection conn, TodoDTO todo) throws SQLException;
    public int delete(Connection conn, long tno) throws SQLException;
}
