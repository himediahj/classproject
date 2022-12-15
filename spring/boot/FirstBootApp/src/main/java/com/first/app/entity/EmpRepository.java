package com.first.app.entity;

import com.first.app.domain.ListItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
    @Query(value = "select e from Emp e join fetch e.dept") // 테이블 이름이 아니라 엔티티 이름
    List<Emp> findEmpDept();

    @Query(value = "select e from Emp e, Dept d where e.dept=d")
    Page<Emp> findEmpWithDept(Pageable pageable);

    // 게시물 리스트 => 제목 [12] 댓글 개수
    // 게시물[dept] , count 사원 수
    // ex) 10번부서 게시물 옆에 [3]명 이런 식으로 표현하고 싶다
    // outer join하면 10번부서 옆에 emp 정보 쭉 나오는게 몇줄로 반복될 것.. 그러니까 그 emp 개수를 구해..
    @Query(value = "select d, count(e) from Emp e left outer join Dept d on e.dept=d group by d", countQuery = "select count(d) from Dept d")
    public Page<Object[]> listWithCnt(Pageable pageable);

    @Query(value = "select new com.first.app.domain.ListItemDTO(e.empno, e.ename, e.job, d.dname, d.loc) from Emp e, Dept d where e.dept=d")
    List<ListItemDTO> findListItem();
}
