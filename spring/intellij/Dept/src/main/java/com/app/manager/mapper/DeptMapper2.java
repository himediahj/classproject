package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper2 {
    // dao 역할

    @Select("select * from dept")   // DeptMapper.xml에 작성한 것과 같음. 잘 바뀌지 않는 간단한 코드들은 어노테이션 사용. 변경 개선 가능성 있으면 xml로 빼기
    List<DeptDTO> selectAll();

    @Select("select * from dept where deptno=#{deptno}")
    DeptDTO selectByDeptno(int deptno);

    @Insert("insert into values (#{deptno}, #{dname}, #{loc}")
    int insertDept(DeptDTO deptDTO);

    @Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
    int updateDept(DeptDTO deptDTO);

    @Delete("delete from dept where deptno=#{no}")  // 파라미터 하나니까 어떠한 이름 가능
    int deleteByDeptno(int deptno);
}
