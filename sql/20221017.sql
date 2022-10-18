-- 20221017

-- 서브쿼리

-- SCOTT이 소속된 부서이름 출력
select d.dname
from emp e, dept d
where e.deptno=d.deptno
and e.ename='SCOTT';

select deptno from emp where ename = 'SCOTT';
select dname from dept where deptno=20;

-- 서브쿼리 이용한 부서 찾기
select dname from dept 
where deptno= (select deptno from emp where ename = 'SCOTT');


-- 스칼라 부속질의
select custid, (select name 
                from customer cs
                where od.custid=cs.custid) as name
from orders od
group by custid;


-- 마당서적의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액 출력)
select (select name from customer cs where od.custid=cs.custid) as name, sum(saleprice) as total
from orders od
group by custid;


-- 인라인 뷰 : from 절 뒤에 쓰여지는 서브쿼리 => 가상 테이블
-- 고객번호가 2 이하인 고객의 판매액
select od.custid, sum(saleprice) total
from orders od, ( select custid, name from customer where custid<=2 ) cs
where cs.custid=od.custid
group by od.custid;

select * from (select empno, ename, job, hiredate from emp)
where ename='SCOTT';


-- 중첩 질의
-- 평균 급여보다 더 많은 급여 받는 사원 검색
select ename
from emp
where sal > (select avg(sal) from emp);


-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액
select orderid, saleprice from orders
where saleprice <= (select avg(saleprice) from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해 주문번호, 고객번호, 금액
select orderid, custid, saleprice from orders
where saleprice > (select avg(saleprice) from orders);

-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원이기에 서브 쿼리 결과 중에서 하나라도 일치하면 참인 결과를 구하는
select * from emp
where deptno in (select distinct deptno from emp where sal >= 3000);

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액 구하기
select sum(saleprice) from orders 
where custid in (select custid from customer where address like '대한민국%');

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액
-- ALL 연산자는 모든 값이 true
select orderid, saleprice from orders
where saleprice > all ( select saleprice from orders where custid=3 );

select orderid, saleprice from orders
where saleprice > (select max(saleprice) from orders where custid=3);

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액
select sum(saleprice) from orders od
where exists (select * from customer cs where cs.custid=od.custid and address like '%대한민국%');




-------------------------------------------------------------------------------------------------

-- DDL : 정의어 => 객체를 정의하는 명령어
-- 데이터의 저장 공간 생성 => create table 테이블 이름 ( 컬럼이름 컬럼타입 [제약조건], 컬럼이름 컬럼타입 [제약조건, ...);

create table ddl_test (
    no number(3) not null unique,
    name varchar2(10),
    birth date default sysdate);
    
-- 사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 컬럼으로 구성된 emp01 테이블 생성
create table emp01 (
    empno number(4),
    ename varchar(10),
    sal number(7,2));

desc emp01;
insert into emp01 (empno, ename, sal) values (1111, 'SON', 1000);

select * from emp01;


-- as : 서브 쿼리 이용해서 기존 테이블의 구조로 생성, 데이터 저장 (제약조건은 copy되지 않는다)
create table emp02
as
select * from emp;

desc emp02;



-- 원하는 컬럼만 카피해서 생성
create table emp03
as
select empno, ename, job, hiredate from emp;

desc emp03;
select * from emp03;


create table emp04
as
select empno, ename, job from emp where deptno=20;

desc emp04;
select * from emp04;


-- 스키마만 복사한 테이블
create table emp05
as
select * from emp where 1=0;

desc emp05;
select * from emp05;



-- 테이블의 컬럼 수정
-- alter table 테이블 이름 add => 컬럼 추가
desc emp01;
-- job 컬럼 추가
alter table emp01 add (job varchar2(9));
select * from emp01;

-- alter table 테이블 이름 modify => 컬럼 수정
alter table emp01 modify (job varchar2(30) default 'manager');
alter table emp01 modify (job default 'dev');
-- null 값이 있는 경우 not null 제약은 추가 불가
alter table emp01 modify (job not null);
desc emp01;
select * from emp01;

-- alter table 테이블 이름 drop => 컬럼 삭제
alter table emp01 drop column job;
desc emp01;




-- 테이블 객체 삭제
drop table emp01;
drop table emp02;

-- 테이블의 모든 행을 삭제 (되돌릴 수 없음)
select * from emp03;
truncate table emp03;
desc emp03;

-- 테이블의 이름 변경 : rename 기존테이블이름 to 새로운 테이블 이름
select * from emp03;
rename emp03 to test03;
select * from test03;



create table emp01 (
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    deptno number(2)
    );

insert into emp01 (job, deptno) values ('MANAGER', 20);
select * from emp01;

drop table emp01;


-- not null 제약 조건은 컬럼 정의 위치에서 제약조건 정의
create table emp01 (
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
    );
    
-- null 삽입할 수 없어서 오류 발생
insert into emp01 (job, deptno) values ('MANAGER', 20);

insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
select * from emp01;

drop table emp01;


-- unique 제약 조건
create table emp01 (
    empno number(4) not null unique,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
    );

desc emp01;
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
-- 무결성 제약 조건 위배 (empno unique)
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);

drop table emp01;


-- not null unique = 기본키 제약 조건 pk
create table emp01 (
    empno number(4) primary key,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
    );
    
desc emp01;
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
drop table emp01;




-- 기본키 제약 조건의 이름 등록
create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
    );
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
-- SCOTT.EMP01_EMPNO_PK에 위배된다고 알려줌
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
drop table emp01;


create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) constraint emp01_ename_nn not null,
    job varchar2(9) constraint emp01_job_uk unique,
    deptno number(2)
    );
    
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 20);
insert into emp01 (empno, ename, job, deptno) values (1112, null, 'MANAGER', 20);
insert into emp01 (empno, ename, job, deptno) values (1112, 'KING', 'MANAGER', 20);
insert into emp01 (empno, ename, job, deptno) values (1112, 'KING', 'DEV', 20);
select * from emp01;
drop table emp01;



-- 외래키 제약 조건 정의 references 테이블이름 (pk키)
create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) constraint emp01_ename_nn not null,
    job varchar2(9) constraint emp01_job_uk unique,
    deptno number(2) constraint emp01_deptno_fk references dept(deptno)
    );

select * from dept;
-- deptno 40번까지라서 제약조건 위배
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 60);
insert into emp01 (empno, ename, job, deptno) values (1111, 'SON', 'MANAGER', 10);
insert into emp01 (empno, ename, job, deptno) values (1112, 'KING', 'DEVS', 20);
drop table emp01;


-- check 제약
create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) constraint emp01_ename_nn not null,
    job varchar2(9) constraint emp01_job_uk unique,
    sal number(7,2) constraint emp01_sal_ck check (sal between 500 and 5000),
    gender char(1) constraint emp01_gender_ck check (gender in ('M', 'F')),
    deptno number(2) constraint emp01_deptno_fk references dept(deptno)
    );

desc emp01;    
insert into emp01 values (1111, 'SON', 'MANAGER', 100, 'A', 20);
insert into emp01 values (1111, 'SON', 'MANAGER', 100, 'M', 20);
insert into emp01 values (1111, 'SON', 'MANAGER', 5100, 'M', 20);
insert into emp01 values (1111, 'SON', 'MANAGER', 500, 'M', 20);
drop table emp01;


-- default 없는 컬럼의 null 입력
create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) constraint emp01_ename_nn not null,
    job varchar2(9) constraint emp01_job_uk unique,
    sal number(7,2) constraint emp01_sal_ck check (sal between 500 and 5000),
    gender char(1) constraint emp01_gender_ck check (gender in ('M', 'F')),
    deptno number(2) constraint emp01_deptno_fk references dept(deptno),
    hiredate date 
    );
    
insert into emp01 (empno, ename, sal, gender, job, deptno) values (1111, 'KING', 5000, 'M', 'MANAGER', 10);
select * from emp01;
insert into emp01 (empno, ename, sal, gender, job, deptno, hiredate) values (1112, 'son', 500, 'M', 'dev', 20, sysdate);
select * from emp01;
drop table emp01;


-- default : 암묵적인 null 값 입력 시 기본으로 저장할 값을 정의
create table emp01 (
    empno number(4) constraint emp01_empno_pk primary key,
    ename varchar2(10) constraint emp01_ename_nn not null,
    job varchar2(9) constraint emp01_job_uk unique,
    sal number(7,2) constraint emp01_sal_ck check (sal between 500 and 5000),
    gender char(1) constraint emp01_gender_ck check (gender in ('M', 'F')),
    deptno number(2) constraint emp01_deptno_fk references dept(deptno),
    hiredate date default sysdate
    );
    
insert into emp01 (empno, ename, sal, gender, job, deptno) values (1111, 'KING', 5000, 'M', 'MANAGER', 10);
select * from emp01;
drop table emp01;