package com.app.emp.service;

import com.app.emp.domain.DeptDTO;
import com.app.emp.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptListService {
    @Autowired(required = false)
    private DeptMapper deptMapper;

    public List<DeptDTO> getList(){
        return deptMapper.selectAll();
    }
}
