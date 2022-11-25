package com.app.emp.mapper;

import com.app.emp.domain.DeptDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<DeptDTO> selectAll();
}
