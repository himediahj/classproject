package com.app.emp.service;

import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDelService {
    @Autowired(required = false)
    private EmpMapper empMapper;

    public int delete(int empno){
        return empMapper.deleteByEmpno(empno);
    }
}
