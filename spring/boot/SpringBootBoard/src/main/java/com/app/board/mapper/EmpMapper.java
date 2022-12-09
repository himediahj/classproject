package com.app.board.mapper;

import com.app.board.domain.emp.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select e.empno, e.ename, e.job, m.ename as mgr, e.hiredate, e.sal, e.comm, d.dname as deptno from emp as e left outer join emp as m on e.mgr=m.empno" +
            " left join dept as d on e.deptno=d.deptno")
    List<EmpDTO> selectAll();

    @Select("select e.empno, e.ename, e.job, m.ename as mgr, e.hiredate, e.sal, e.comm, d.dname as deptno from emp as e left outer join emp as m on e.mgr=m.empno" +
    " left join dept as d on e.deptno=d.deptno where e.empno=#{empno}")
    EmpDTO viewEmp(int empno);
}
