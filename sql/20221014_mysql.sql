select empno, ename, job, dname, loc
from emp e join dept d
on e.deptno=d.deptno 
where ename='SCOTT';




select empno, ename, sal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;



-- table 3개 참조
select orderdate, name, bookname, price, saleprice
from orders o join customer c
on o.custid=c.custid
join book b
on o.bookid=b.bookid
where name='박지성'
;


select name, count(*) as 구매회수
from orders o join customer c
on o.custid=c.custid
join book b
on o.bookid=b.bookid
group by name
;