package com.app.manager.service;

import com.app.manager.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptDelService {
    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int delete(int deptno){
        return deptMapper.deleteByDeptno(deptno);
    }
}
