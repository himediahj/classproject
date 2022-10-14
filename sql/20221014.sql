-- 20221014
-- join : 관계있는 테이블의 스키마를 붙이는 것
select * 
from emp, dept
where emp.deptno = dept.deptno;

-- 14행 * 4행 => cross join 의 결과 행

select *
from emp cross join dept;


select emp.ename, dept.dname 
from emp, dept
where emp.deptno = dept.deptno;


-- 테이블 별칭을 이용해서 컬럼 구분
select e.ename, d.dname 
from emp e, dept d
where e.deptno = d.deptno;


-- mysql
select * from emp e inner join dept d on e.deptno=d.deptno;
-- select deptno from emp e inner join dept d on e.deptno=d.deptno; 오류남

select * from emp e inner join dept d using (deptno);
select deptno from emp e inner join dept d using (deptno);

-- using 쓴 결과랑 같이 출력됨
select * from emp natural join dept;

-- inner 생략 가능
select * from emp join dept on emp.deptno=dept.deptno;



-- self join : 자기 자신의 테이블과 조인
-- emp 테이블 => mgr : 상사의 사원번호
-- 각 사원들의 이름과 상사의 이름을 출력
select e1.ename as 사원이름, e2.ename as 상사이름 from emp e1, emp e2 where e1.mgr=e2.empno(+);

-- mysql
select e1.ename, e2.ename from emp e1 left outer join emp e2 on e1.mgr=e2.empno;
select e1.ename, e2.ename from emp e1 right outer join emp e2 on e1.empno=e2.mgr;




-- 'scott' 사원의 사원번호와 이름, 직급, 부서이름, 부서위치 출력
select empno, ename, job, dname, loc
from emp e, dept d
where e.deptno=d.deptno
    and e.ename='SCOTT';

-- inner join 사용해서 출력해보기    
select empno, ename, job, dname, loc
from emp e join dept d
on e.deptno=d.deptno 
where ename='SCOTT';



-- salgrade 테이블 참조해서 사원들의 사번, 이름, 급여, 급여 등급을 출력
select empno, ename, sal, grade 
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

-- inner join 버전
select empno, ename, sal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;


-- table 3개 이상
-- 판매내역 : 판매 정보, 판매 서적의 정보, 고객의 정보
select orderdate, name, bookname, price, saleprice
from book b, customer c, orders o
where o.custid=c.custid and o.bookid=b.bookid
order by orderdate
;