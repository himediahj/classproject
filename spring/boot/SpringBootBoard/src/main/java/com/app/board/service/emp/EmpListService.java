package com.app.board.service.emp;

import com.app.board.domain.emp.EmpDTO;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpListService {
    @Autowired
    private EmpMapper empMapper;

    public List<EmpDTO> selectAll(){
        return empMapper.selectAll();
    }
}
