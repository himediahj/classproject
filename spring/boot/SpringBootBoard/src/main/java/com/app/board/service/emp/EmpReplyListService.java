package com.app.board.service.emp;

import com.app.board.domain.emp.ReplyDTO;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpReplyListService {
    @Autowired
    private EmpMapper empMapper;

    public List<ReplyDTO> selectAll(int empno){
        return empMapper.selectAll(empno);
    }
}
