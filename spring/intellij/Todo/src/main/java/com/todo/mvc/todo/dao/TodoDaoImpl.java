package com.todo.mvc.todo.dao;

import com.todo.mvc.todo.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TodoDaoImpl implements TodoDao {
    @Override
    public int insert(Connection conn, String title, String dueDate) throws SQLException {
        int result = 0;
        String sql = "insert into todo (title, dueDate) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, dueDate);
        result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {
        List<TodoDTO> list = null;
        String sql = "select * from todo";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            list.add(new TodoDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }
        return list;
    }

    @Override
    public TodoDTO selectBy(Connection conn, long tno) throws SQLException {
        TodoDTO todo = null;
        String sql = "select * from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            todo = new TodoDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
        }
        return todo;
    }

    @Override
    public int update(Connection conn, TodoDTO todoDTO) throws SQLException {
        int result = 0;
        String sql = "update todo set title=? dueDate=? finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todoDTO.getTitle());
        pstmt.setString(2, todoDTO.getDueDate());
        pstmt.setBoolean(3, todoDTO.isFinished());
        pstmt.setLong(4, todoDTO.getTno());
        result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public int delete(Connection conn, long tno) throws SQLException {
        int result = 0;
        String sql = "delete from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        result = pstmt.executeUpdate();
        return result;
    }
}
