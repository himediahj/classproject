package com.app.board.service.todo;

import com.app.board.repository.BoardTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoDeleteService {
    @Autowired
    private BoardTodoRepository boardTodoRepository;

    public int deleteTodo(int tno){
        return boardTodoRepository.deleteByTno(tno);
    }
}
