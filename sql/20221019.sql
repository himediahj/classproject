-- 20221019

-- Transaction : 일의 단위 => 여러 DML 들을 묶어둔 것
-- commit : 작업의 완료 => 데이터의 물리적 저장
-- rollback : 작업 실패 => 마지막 물리적 저장 상태로 복귀

create table dept02 as select * from dept;

-- DDL 작업 후 자동 COMMIT

select * from dept02;
-- 트랜젝션 시작
insert into dept02 values (50, '개발', 'Seoul');
insert into dept02 values (60, '기획', '판교');
update dept02 set loc='Jeju' where deptno=60;

rollback;
select * from dept02; -- 입력한 것들 2개 사라짐! 

insert into dept02 values (50, '개발', 'Seoul');
insert into dept02 values (60, '기획', '판교');
update dept02 set loc='Jeju' where deptno=60;
commit;
select * from dept02;
rollback;
select * from dept02; -- 커밋했으니까 rollback해도 입력한 것들 다 들어있음!




----------------------------------------------------------------------------------------
-- 가상테이블 => View
-- 데이터를 제한할 수 있고, 복잡한 sql을 단순하게 처리할 수 있다

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호 출력하기 위한 select문을 하나의 뷰로
select empno, ename, deptno from emp where deptno=30;

-- View 생성
create or replace view emp_view30
as
select empno, ename, deptno from emp where deptno=30;

select * from emp_view30
where ename = 'JAMES';


select * from user_views;
select view_name, text from user_views;

drop view emp_view30;
select * from user_view;    -- 삭제되서 안 뜬다




-----------------------------------------------------------------------------------------
-- sequence : 자동 숫자 생성기
create sequence seq_dept_deptno
start with 10
increment by 10;

-- 새로운 값을 생성 : nextval -> 다음 값을 생성해서 반환
select seq_dept_deptno.nextval from dual;   -- 10 나옴
select seq_dept_deptno.nextval from dual;   -- 20 나옴
select seq_dept_deptno.currval from dual;   -- 현재 가지고 있는 가장 마지막 값 나옴


-- 시퀀스 삭제
drop sequence seq_Dept_deptno;


create table dept04 as select * from dept where 1=0;    -- 행 말고 스키마만 가져오기

select * from dept04;
create sequence seq_dept_deptno
start with 10
increment by 10;

insert into dept04 values (seq_dept_deptno.nextval, '개발', '서울');
select * from dept04;
insert into dept04 values (seq_dept_deptno.nextval, '개발', '서울');    -- 일련번호 10씩 증가
select * from dept04;


create sequence seq_emp_empno;
select seq_emp_empno.nextval from dual; -- default 1부터 1씩 증가




------------------------------------------------------------------------------------
-- index : 검색의 성능을 향상시킬 때 사용

drop table emp01;
create table emp01 as select * from emp;

insert into emp01 select * from emp01;  

insert into emp01 (empno, ename) values (1111, 'SON');

select * from emp01 where ename='SON';


-- index 생성
create index index_emp01_ename on emp01(ename);

select /*+ index(emp01 index_emp01_ename)*/ * from emp01 where ename='SON';

-- index 삭제
-- drop index 인덱스이름;
drop index index_emp01_ename;

commit;

insert into dept values (50, '개발', 'Seoul');

update dept set dname ='기획', loc='제주' where deptno=50;

delete dept where deptno=50;

rollback;

