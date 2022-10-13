-- 20221013

-- 함수 : 단일행 함수, 집합 함수

select ename, sal, nvl(comm,0) as comm
from emp
where nvl(comm,0) >= 0; 

-- 문자 함수
select lower('SCOTT') from dual;

select ename, lower(ename) from emp;

select upper('scott') from dual;

select initcap('scott') from dual; -- 앞에 있는 첫문자를 대문자로

-- substr(원본, 시작포인트, 반환할 개수)
select substr('안녕하세요. 손흥민입니다.', 2, 3) from dual;    -- 녕하세 출력
select substr('안녕하세요. 손흥민입니다.', 5) from dual;   -- 5번째부터 나머지 다 출력

select length('안녕하세요. 손흥민입니다.') from dual;  -- 문자열 개수 반환

-- lpad, rpad 특정 자리수 지정하고 자리수에 데이터가 없는 경우 특정 패턴으로 채우는 함수
-- 부서번호 10을 00010, 00020, 00030, 00040 이렇게 만들고 싶어, 10AAA, 20AAA, 30AAA
select dname, deptno, lpad(deptno, 5, '0'), rpad(deptno, 5, 'A')
from dept;

-- 공백 제거
select '     ABC', trim('     ABC'), '     ABC     ', trim('     ABC     ') from dual;

select replace('Steven King', 'Steven', 'S.')
from dual;

select replace('Steven King', 'Steven ', '') from dual; -- King 만 출력



-- 숫자 함수
select -10, abs(-10)    -- absolute 절대값
from dual;

-- 소수점 잘라내서 정수로 만들기
select 2.1, floor(2.9)  
from dual;

-- 소수점 첫째자리까지 반올림, -1은 4에서 반올림, 자리수 없으면 반올림 해서 정수만
select 1234.567, round(1234.567, 1), round(1234.527, 1), round(1234.527, -1), round(1235.12, -1), round(1235.527)
from dual;

-- 반올림 없이 자리수 잘라내기
select 1234.567, trunc(1234.567, 1), trunc(1234.567, -1), trunc(1234.567)
from dual;

-- 나머지 구하기
select mod(1,3), mod(2, 3), mod(3, 3), mod(0, 3), mod(3, 0)
from dual;



-- 날짜 함수

-- 현재 날짜 출력
select sysdate
from dual;

-- 몇 개월 차이인지
select months_between(sysdate, '21/12/13')
from dual;

select add_months(sysdate, 2) from dual;
select add_months(sysdate, -2) from dual;

-- 일요일이 1번이라 다가오는 일요일 날짜를 출력해줌
select next_day(sysdate, 1) from dual;
-- 달의 마지막 날짜를 출력해줌
select last_day(sysdate) from dual;
-- 오후 12시가 지나서 반올림해서 내일 날짜가 나옴
select round(sysdate) from dual;
select trunc(sysdate) from dual;



-- 변환 함수

-- to_char(원본, 'format')    2022.10.13. 14:39
-- date => varchar2
select sysdate, to_char(sysdate, 'yyyy.mm.dd. hh24:mi:ss') from dual;

-- number => varchar2
select to_char(123456789, '000000000000') 
      ,to_char(123456789, '999,999,999,999') 
      ,to_char(123456789, 'L999,999,999,999') from dual;
      
select ename, sal, to_char(sal*1400, 'L999,999,999,999') as wonSal from emp;

-- varchar2 => date
-- to_date(문자열, '날짜형식') 
select to_date('1999-12-13', 'yyyymmdd')
from dual;

-- varchar2 => number
select to_number('20,000', '999,999,999,999') - to_number('10,000', '999,999,999,999')
from dual;


-- decode 함수 => 여러가지 비교를 통해 결과 출력 (switch-case와 유사)
select ename, deptno, decode(deptno, 10, 'ACCOUNTING'
                                   , 20, 'RESEARCH'
                                   , 30, 'SALES'
                                   , 40, 'OPERATIONS') as dname
from emp;



select distinct job from emp;
-- 직급에 따라 급여를 인상하도록 하자. 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다.
-- king은 직급이 president라 null값 나오니까 nvl 처리

select 
    ename, job, sal,
    nvl(
    decode(job, 'ANALYST', sal*1.05,
                'SALESMAN', sal*1.1,
                'MANAGER', sal*1.15,
                'CLERK', sal*1.2)
    , sal) as upsal
from emp;


-- case ~ when ~ then
select ename, deptno,
case when deptno = 10 then 'ACCOUNTING'
     when deptno = 20 then 'research'
     when deptno = 30 then 'sales'
     when deptno = 40 then 'operations'
end as dname
from emp;


-----------------------------------------------------------------------------
-- 그룹함수, 집합함수, 집계함수, 다중행 함수
-- sum, avg, count, max, min
-- null 제외하고 연산 됨

-- 회사 모든 사원의 급여 총액 : 월 지출액
select sum(sal)
from emp;

select sum(comm), count(comm), avg(comm) from emp;
select round(avg(sal), 2) from emp;

-- 최고 급여
select max(sal) from emp;
select min(sal) from emp;

-- 전체 사원의 수
select count(*) from emp;

-- 부서의 개수
select count(*) from dept;

-- 직급의 수
select count(distinct job) from emp;

