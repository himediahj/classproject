package com.todo.todospring.mapper;

import com.todo.todospring.domain.TodoDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface TodoMapper {

    // Todo 전체 리스트
    @Select("select * from todo")
    List<TodoDTO> selectAll() throws SQLException;

    // tno 값으로 하나의 Todo 정보를 가져오는 메소드
    @Select("select * from todo where tno=#{tno}")
    TodoDTO selectByTno(long tno) throws SQLException;

    // todo 정보 입력
    int insertTodo(TodoDTO todo) throws SQLException;

    // todo 정보 수정
    int updateTodo(TodoDTO todo) throws SQLException;

    // todo 정보 삭제
    @Delete("delete from todo where tno=#{tno}")
    int deleteTodo(long tno) throws SQLException;
}
