package com.app.board.mapper;

import com.app.board.domain.emp.EmpDTO;
import com.app.board.domain.emp.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select e.empno, e.ename, e.job, m.ename as mgr, e.hiredate, e.sal, e.comm, d.dname as deptno from emp as e left outer join emp as m on e.mgr=m.empno" +
//            " left join dept as d on e.deptno=d.deptno")
//    List<EmpDTO> selectAll();

    @Select("select e.empno, e.ename, e.job, m.ename as mgr, e.hiredate, e.sal, e.comm, d.dname as deptno from emp as e left outer join emp as m on e.mgr=m.empno" +
    " left join dept as d on e.deptno=d.deptno order by e.ename limit #{start},#{count}")
    List<EmpDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from emp")
    Integer totalCount();

    @Select("select e.empno, e.ename, e.job, m.ename as mgr, e.hiredate, e.sal, e.comm, d.dname as deptno from emp as e left outer join emp as m on e.mgr=m.empno" +
    " left join dept as d on e.deptno=d.deptno where e.empno=#{empno}")
    EmpDTO viewEmp(int empno);



    ////////////////// 댓글 /////////////////
    @Insert("insert into emp_reply (empno, star, reply, replyer) values (#{empno}, #{star}, #{reply}, #{replyer})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
    int insertReply(ReplyDTO replyDTO);

    @Select("select * from emp_reply where rno=#{rno}")
    ReplyDTO selectByRno(int rno);

    @Select("select * from emp_reply where empno=#{empno}")
    List<ReplyDTO> selectAll(int empno);

    @Delete("delete from emp_reply where rno=#{rno}")
    int deleteReply(int rno);

    @Update("update emp_reply set star=#{star}, reply=#{reply} where rno=#{rno}")
    int updateReply(ReplyDTO replyDTO);
}
