package com.app.board.service.emp;

import com.app.board.domain.emp.EmpDTO;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpViewService {
    @Autowired
    private EmpMapper empMapper;

    public EmpDTO readEmp(int empno){
        return empMapper.viewEmp(empno);
    }
}
