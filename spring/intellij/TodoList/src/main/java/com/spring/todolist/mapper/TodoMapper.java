package com.spring.todolist.mapper;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.domain.TodoSearchOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoDTO> selectAll();
    TodoDTO selectBy(long tno);
    int insert(TodoDTO todoDTO);
    int update(TodoDTO todoDTO);
    int delete(long tno);

    List<TodoDTO> selectByTitle(TodoSearchOption todoSearchOption);
}
