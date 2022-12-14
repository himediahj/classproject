package com.first.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
    Dept findByDeptno(Integer deptno);

    List<Dept> findByDnameLikeOrderByLocAsc(String dname);

    List<Dept> findByDeptnoGreaterThanAndDnameLikeAndLocLikeOrderByDeptnoDesc(Integer deptno, String dname, String loc);

    @Query("select d from Dept d where d.loc like :loc")
    List<Dept> findByLocLike(@Param("loc") String loc);

    @Query("select d from Dept d where d.deptno between :deptnoStart and :deptnoEnd")
    List<Dept> findByDeptnoBetween(@Param("deptnoStart") Integer deptnoStart, @Param("deptnoEnd") Integer deptnoEnd);




}
