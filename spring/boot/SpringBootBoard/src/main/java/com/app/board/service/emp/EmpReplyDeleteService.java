package com.app.board.service.emp;

import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpReplyDeleteService {

    @Autowired
    private EmpMapper empMapper;

    public int delete(int rno){
        return empMapper.deleteReply(rno);
    }
}
