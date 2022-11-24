package com.app.emp.service;

import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmpReadService {
    @Autowired(required = false)
    private EmpMapper empMapper;

    public EmpDTO getRead(int empno){
        return empMapper.selectByEmpno(empno);
    }
}
