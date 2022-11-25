/*
package com.spring.todolist.dao;

import com.spring.todolist.domain.TodoDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao {
    @Override
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {
        List<TodoDTO> list = new ArrayList<>();
        String sql = "select * from todo";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            list.add(rowTodo(rs));
        }
        return list;
    }

    @Override
    public TodoDTO selectBy(Connection conn, long tno) throws SQLException {
        TodoDTO todoDTO = null;
        String sql = "select * from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            todoDTO = rowTodo(rs);
        }
        return todoDTO;
    }

    private TodoDTO rowTodo(ResultSet rs) throws SQLException {
        return new TodoDTO(rs.getLong("tno"), rs.getString("title"), rs.getDate("dueDate").toLocalDate(), rs.getBoolean("finished"));
    }

    @Override
    public int insert(Connection conn, TodoDTO todoDTO) throws SQLException {
        String sql = "insert into todo (title, dueDate) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todoDTO.getTitle());
        pstmt.setDate(2, Date.valueOf(todoDTO.getDueDate()));
        return pstmt.executeUpdate();
    }

    @Override
    public int update(Connection conn, TodoDTO todoDTO) throws SQLException {
        String sql = "update todo set title=?, dueDate=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todoDTO.getTitle());
        pstmt.setDate(2, Date.valueOf(todoDTO.getDueDate()));
        pstmt.setBoolean(3, todoDTO.isFinished());
        pstmt.setLong(4, todoDTO.getTno());
        return pstmt.executeUpdate();
    }

    @Override
    public int delete(Connection conn, long tno) throws SQLException {
        String sql = "delete from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        return pstmt.executeUpdate();
    }
}
*/
