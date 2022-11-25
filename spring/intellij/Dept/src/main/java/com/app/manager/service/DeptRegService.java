package com.app.manager.service;

import com.app.manager.domain.DeptDTO;
import com.app.manager.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptRegService {
    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int insertDept(DeptDTO deptDTO){
        return deptMapper.insertDept(deptDTO);
    }


    //////////////////////////////////////////////////////////////
    @Transactional
    public int insertDepts(DeptDTO deptDTO){
        deptMapper.insertDept(deptDTO);
        deptMapper.insertDept(new DeptDTO(10, "test", "test")); // deptno pk라 sqlexception 발생할 예정
        // 밑에꺼가 실패하면 위에꺼도 입력이 안되야하는데 입력이 되었음
        // 우리가 원하는건 첫번째도 입력이 안되야함 -> @TRANSACTIONAL
        return 0;
    }
}
