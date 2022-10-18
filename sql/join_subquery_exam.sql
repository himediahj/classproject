-- (5) 박지성이 구매한 도서의 출판사수

select count(publisher) from book where bookid in ( select bookid from orders o join customer c on o.custid= c.custid where c.name='박지성');

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select bookname, price, price-saleprice from book b, orders o
where b.bookid=o.bookid
and o.custid = (select custid from customer c where c.name='박지성');


-- (7) 박지성이 구매하지 않은 도서의 이름
select bookname from book where bookid not in (select bookid from orders o join customer c on o.custid=c.custid where c.name='박지성'); 

-- (8) 주문하지 않은 고객의 이름(부속질의 사용)
select name from customer where custid not in (select custid from orders);

-- (9) 주문금액의 총액과 주문의 평균금액
select sum(saleprice) total, avg(saleprice) from orders;

-- (10) 고객의 이름과 고객별 구매액
select (select name from customer c where c.custid=o.custid) name, sum(saleprice) 
from orders o group by custid;


-- (11) 고객의 이름과 고객이 구매한 도서목록
select (select name from customer c where c.custid=o.custid) name, (select bookname from book b where b.bookid=o.bookid) bookname
from orders o;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select * from orders o, book b
where o.bookid=b.bookid
and price-saleprice = (select max(price-saleprice) from orders o, book b where o.bookid=b.bookid)
;

-- (13) 도서의 판매액 평균보다 자신의 구매액평균이 더 높은 고객의이름
-- 11,800원
select name from (select name, avg(saleprice) avg from customer c, orders o where c.custid=o.custid group by name) b
where b.avg > (select avg(saleprice) from orders);


-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
and b.publisher in (select publisher from book where bookid in (select bookid from orders o join customer c on o.custid=c.custid where c.name='박지성'))
and c.name != '박지성';

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name 
from customer c, (select custid, count (distinct publisher) num from book b, orders o
                  where b.bookid=o.bookid
                  group by custid) t
where c.custid=t.custid
and num >=2;
