-- 20221018

-- inline view - rownum
-- from 절 뒤에 오는 서브쿼리 -> inline view
-- select -> 결과도 테이블

select rownum, emp.*
from emp
order by hiredate;

-- rownum : 사용자가 생성하는 컬럼이 아니다!, 시스템에서 제공하는 컬럼

select rownum, t.*
from (select * from emp order by hiredate) t
;

-- top3 입사일이 가장 오래된 3명
select rownum, t.*
from (select * from emp order by hiredate) t
where rownum <= 3
;

-- mysql 버전
-- select * from emp order by hiredate limit 0, 3; 0번지부터 3개




-----------------------------------------------------------------------
-- null 값은 밑에서 정의 못함
create table emp02 (
    empno number(4),
    ename varchar2(10) constraint emp02_ename_nn not null,
    job varchar2(9),
    sal number(7,2),
    gender char(1) ,
    deptno number(2) ,
    hiredate date default sysdate,
    constraint emp02_empno_pk primary key (empno),
    constraint emp02_job_uk unique (job),
    constraint emp02_sal_ck check (sal between 500 and 5000),
    constraint emp02_gender_ck check (gender in ('M', 'F')),
    constraint emp02_deptno_fk foreign key (deptno) references dept(deptno)
    );
    
insert into emp02 (empno, ename, sal, job, gender, deptno) values (1111, 'KING', 5000, '대표', 'M', 10);
-- 컬럼 생략했기 때문에 입사날짜까지 넣어줘야 함
insert into emp02 values (1112, 'SON', '대리', 500, 'M', 40, '2022-10-18');
insert into emp02 (empno, ename) values (1113, 'SCOTT');    -- 지정 입력되지 않은 컬럼에는 null값 등록 : 암묵적 입력 방법
insert into emp02 values (1114, 'HOT', null, null, null, null, null);
insert into emp02 values (1115, 'COOL', '', '', '', '', '');
select * from emp02;



--------------------------------------------------------------
-- 데이터의 수정
-- update 테이블 이름 set 컬럼이름=새로운 값, 컬럼이름=새로운 값... where 행 선택 조건

create table emp03 as select * from emp;
select * from emp03;

-- 모든 사원의 부서번호를 30으로 변경
update emp03 set deptno=30;
select * from emp03;

-- 모든 사원의 급여를 10% 인상
update emp03 set sal=sal*1.1;
select * from emp03;

-- 모든 사원의 입사일을 오늘 날짜로 변경
update emp03 set hiredate=sysdate;

drop table emp03;
create table emp03 as select * from emp;

-- 부서 번호가 10번인 사원의 부서번호를 30번으로 변경
update emp03 set deptno=30
where deptno=10;

-- 급여가 3000 이상인 사원들의 급여를 10% 인상
update emp03 set sal=sal*1.1 where sal>=3000;

-- SCOTT 사원을 20번 부서로 이동, 직급을 MANAGER로 변경
update emp03 set deptno=40, job='MANAGER' where ename='SCOTT';

-- SMITH 사원을 SCOTT사원의 부서로 이동
update emp03 set deptno=(select deptno from emp03 where ename='SCOTT') where ename='SMITH';

-- 부서번호가 20번인 부서의 이름과 지역명을 40번인 부서와 동일하게 변경
create table dept01 as select * from dept;
update dept01 set (dname, loc) = (select dname, loc from dept where deptno=40) where deptno=20;


---------------------------------------------------------------------------------
-- 데이터의 삭제
-- delete from 테이블이름 where 행 선택 조건

-- delete 문으로 부서 테이블의 모든 행을 삭제합시다.
delete from dept01;

-- 대표 사퇴
delete from emp03 where empno=7839;
-- 40번 부서 모든 사원 삭제
delete from emp03 where deptno=40;
-- SALES 부서 모든 사원 삭제
delete from emp03 where deptno=(select deptno from dept where dname='SALES');
