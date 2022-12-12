package com.app.board.service.emp;

import com.app.board.domain.emp.ReplyDTO;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpReplyReadService {
    @Autowired
    private EmpMapper empMapper;

    public ReplyDTO selectByRno(int rno){
        return empMapper.selectByRno(rno);
    }
}
