package com.first.app.mapper;

import com.first.app.domain.DeptDTO;
import com.first.app.domain.DeptSearchOption;
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


    //////////////////////////////

    // 검색 타입과 키워드를 받아서 검색 결과 반환
    List<DeptDTO> selectByOption(DeptSearchOption searchOption);

    List<DeptDTO> selectByDeptnos(List<Integer> deptnos);
}
