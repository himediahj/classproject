

 -- 20221012
 
 -- 사용가능한 테이블 정보 ( 별은 전체 출력)
 select * from tab;
 
 -- 테이블의 구조 확인
 desc dept;
 
 
 
 select ename --* 
 from emp;
 
 select deptno, job, sal, ename
 from emp;
 
 
 -- select [distinct] 컬럼 이름, 컬럼 이름, ...
 -- from 테이블 이름
 
 select * from dept;    -- 행을 선택하는 조건이 없기 때문에 모든 행이 결과로 출력
 
 select deptno, dname from dept;
 
 
 select sal, nvl(comm, 0) from emp; -- null값을 0으로 치환
 -- null : 정해지지 않은 값! 
 -- select 표현 영역에서는 산술연산이 가능
 select sal + comm
 from emp;
 
 select sal, sal - 100 from emp;
 
 select sal * 12 from emp;
 
 select sal / 2 from emp;
 
 
 -- 사원 테이블에서 사원의 이름, 월 급여, 연봉 출력
 select ename, sal, sal*12
 from emp;
 
 select ename, sal, sal*12, sal*12+comm
 from emp;
 
 
 -- null의 값을 치환해주는 함수 : nvl(원본데이터, null일 때 치환되는 값)
 select ename, sal, sal*12 yearsal1, sal*12+nvl(comm,0) yearsal2
 from emp;
 
 -- 문자열 연산
 select ename || ' is a ' || job
 from emp;
 
 -- distinct : 중복된 데이터를 생략하고 출력
 select deptno from emp;
 select distinct deptno from emp;
 
 
 -- 행을 찾는 조건
 -- select from where 조건식 
 -- 급여를 3000 이상 받는 사원의 이름과 직급 리스트
 select ename, job from emp where sal >= 3000;
 
 -- 사원 테이블에서 부서번호가 10번인 사원의 리스트를 출력
 -- deptno=10
 select * from emp where deptno=10;
 
 -- 10번 부서 소속이 아닌 사원 리스트 출력
 select * from emp where deptno<>10;
 
 -- 이름으로 검색 => 문자열 작은 따옴표로 표시
 -- ename = 'SCOTT'
 select * from emp where ename='SCOTT'; -- 저장된 문자열은 대소문자를 구별!
 
 select * from emp where hiredate='81/11/17';   -- 날짜 비교시에도 작은 따옴표 사용해서 비교
 
 -- 논리 연산 => 비교연산 여러개 사용해서 결과를 만든다
 -- and, or, not
 -- 10번 부서의 매니저를 검색
 select * from emp where deptno=10 and job='MANAGER';
 
 -- 10번 부서에 소속한 사원들과 매니저들을 출력
 select * from emp where deptno=10 or job='MANAGER';
 
 -- 10번 부서 소속이 아닌 사원들의 리스트
 select * from emp where not deptno=10;
 
 
 
 -- 10번 부서 소속인 사원들 중에서 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급 출력
 select ename, deptno, job from emp where deptno=10 and job='MANAGER';
 
 -- 10번 부서에 소속된 사원이거나 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급 출력
 select ename, deptno, job from emp where deptno=10 or job='MANAGER';
 
 -- 2000~3000 사이 급여 받는 사원의 리스트
 select * from emp where sal>=2000 and 3000>=sal;
 
 select * from emp where sal between 2000 and 3000;
 
 
 -- 1987년에 입사한 사원 리스트
 select * from emp where hiredate between '87/01/01' and '87/12/31';
 
 -- 커미션이 300 이거나 500 이거나 1400인 사원 검색
 select * from emp where comm = 300 or comm = 500 or comm = 1400;
 select * from emp where comm in(300, 500, 1400);
 
 
 -- like 패턴 검색
 -- F로 시작하는 이름 검색
 select * from emp where ename like 'F%';    -- %는 뒤에 없어도 되고 있어도 된다는 뜻 무조건 F로 시작 ex)%F%는 어디든 F 포함
 select * from emp where ename like '%F';   -- F로 끝나는 것
 
 -- '_A%' 무조건 앞에 한자리. %는 없어도 되는데 _는 반드시 있어야 함. 자리수를 나타냄. 두번째 문자는 A고 뒤에는 상관 x
 select * from emp where ename like '__A%';
 
 -- null 여부 확인하는 is null
 -- null 비교연산자 사용 불가능 ex) =null 
 -- select * from emp where comm=null 안나옴
 select * from emp where comm is null;
 
 -- 커미션 받지 않는 사원 출력
 select * from emp where comm is null or comm = 0;
 
 -- 커미션 등록된 사원의 리스트
 select * from emp where comm is not null;
 
 
 -- 결과 행의 정렬 : order by 컬럼 asc | desc
 -- asc : 오름차순, 생략하면 기본값 ascending
 -- desc : 내림차순 descending
 -- 급여 컬럼 기준으로 오름차순 정렬
 select * from emp -- where 절 
 order by sal; -- asc;

-- 이름 내림차순으로 출력
 select * from emp order by ename desc;
 
 -- 입사일이 가장 오래된 순으로 사원의 리스트 출력
 select * from emp order by hiredate;
 
 -- 가장 최근 입사자부터 
 select * from emp order by hiredate desc, job asc;   -- 입사일 같으면 직급 abc순
 
 select * from emp order by sal, ename desc;    -- 샐러리 같으면 이름 내림차순