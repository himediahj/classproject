-- (5) 박지성이 구매한 도서의 출판사수

select count(publisher) from book where bookid in ( select bookid from orders o join customer c on o.custid= c.custid where c.name='박지성');

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select bookname, price from book where bookid in (select bookid from orders o join customer c on o.custid= c.custid where c.name='박지성');

select bookname, price, price-saleprice 
from book b, orders o
where b.bookid in (select bookid from orders o join customer c on o.custid= c.custid where c.name='박지성');

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
select (select name from customer c where c.custid=o.custid) name
from orders o;

-- (12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

-- (13) 도서의 판매액 평균보다 자신의 구매액평균이 더 높은 고객의이름

-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

select * from customer;
select * from orders;
select * from book;

select bookname, price, price-(select saleprice from orders from book where bookid= ;

-- 6번 못했엉.