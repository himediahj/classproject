package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.entity.Board;
import com.app.board.repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardViewService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    public Board selectBoardDTO(int bno){
        return boardRepository.findById(bno).get();
        // return boardMapper.selectByBno(bno);
    }

}
