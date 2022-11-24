package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    // dao 역할

    List<DeptDTO> selectAll();

    DeptDTO selectByDeptno(int deptno);

    int insertDept(DeptDTO deptDTO);

    int updateDept(DeptDTO deptDTO);

    int deleteByDeptno(int deptno);
}
