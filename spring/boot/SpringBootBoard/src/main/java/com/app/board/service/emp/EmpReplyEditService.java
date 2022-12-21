package com.app.board.service.emp;

import com.app.board.domain.emp.ReplyDTO;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpReplyEditService {
    @Autowired
    private EmpMapper empMapper;

    public int update(ReplyDTO replyDTO){
        return empMapper.updateReply(replyDTO);
    }
}
