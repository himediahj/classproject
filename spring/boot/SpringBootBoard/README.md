## 1. 프로젝트 주제
 - 게시판 만들기
## 2. 사용 기술
 - Java 17  
 - Spring Boot 2.7.6 
 - Thymeleaf  
 - Gradle  
 - MyBatis  
 - Spring Data JPA 
 - MySQL 8.0 
 - Spring Security 
## 3. ERD<br>
![제목 없는 다이어그램 drawio (1)](https://user-images.githubusercontent.com/113006963/209071245-503d5463-6da1-4332-bafd-ad3fb0e1ca68.png)
## 4. 핵심 기능
회원가입과 로그인 기능이 있으며, 사진과 함께 글을 쓸 수 있고 댓글을 쓸 수 있습니다.<br>
내가 쓴 Todo 할 일만 볼 수 있습니다.
## 5. 화면 설명
<details>
<summary>회원가입</summary>

![merge_from_ofoct](https://user-images.githubusercontent.com/113006963/209277509-7429e6d0-4ca5-47c9-a1f2-27b55afd0605.jpg)
- 아이디 중복 검사가 가능합니다.
</details>
<details>
<summary>로그인</summary>

![로그인](https://user-images.githubusercontent.com/113006963/209075540-19b9826c-9125-4833-b6d1-9c5be98c38d8.JPG)
 - SecurityFilterChain을 통하여 권한에 따른 접속을 제한합니다.<br>
 - User 권한을 가진 사용자들은 Board와 Todo 메뉴에 접근이 가능합니다. 따라서 해당 메뉴 접속 시 로그인은 필수입니다.<br>
</details>
<details>
 <summary>Board 메뉴</summary>
 
 </details>
 <details>
 <summary>Emp 메뉴</summary>
 
 ### (1) Emp 리스트
 ![emp](https://user-images.githubusercontent.com/113006963/209284372-7ea202ca-f05c-42fc-8f59-fa04a210d6e8.JPG)
 - https://www.lesstif.com/dbms/oracle-mysql-emp-dept-table-schema-test-data-18219073.html 테스트 용도로 EMP 테이블과 DEPT 테이블을 생성해서 두 테이블을 조인시켜 리스트를 출력합니다.
 ### (2) 상세보기
 ![EMP상세보기](https://user-images.githubusercontent.com/113006963/209285276-2eb5ea50-341c-4196-9d1d-81368a248216.JPG)
 - 이름을 클릭하면 정보를 볼 수 있고, 별점과 댓글을 남길 수 있는 페이지입니다.
 ### (3) 댓글 수정, 삭제
 ![merge_from_ofoct (3)](https://user-images.githubusercontent.com/113006963/209286027-a92cb6b9-d5dc-4fa9-844d-3b197ee8bc86.jpg)
 - 모달창을 띄워 값을 가져오고, 값을 변경하여 수정이 반영되도록 합니다.
 - confirm창을 띄워 삭제 여부를 묻고 삭제합니다.
 </details>
 <details>
 <summary>Todo 메뉴</summary>
 
 ### (1) Todo 페이지
 ![todo](https://user-images.githubusercontent.com/113006963/209280242-ec1635d7-d176-489e-a27b-08e8880c9a5d.JPG)
 - 할일과 기한을 등록하면 리스트에 추가됩니다.
 - 내가 쓴 todo 리스트만 보게 하기 위해 Repository에서 작성자 컬럼을 조건으로 하는 쿼리를 생성해서 ajax를 통해 리스트를 불러옵니다.
 - 미완료 된 todo는 D-day가 보이게 하고, 하단에 진행중인 todo만 볼 수 있는 버튼을 따로 생성합니다.
 ### (2) Todo 수정
 ![todo수정](https://user-images.githubusercontent.com/113006963/209282145-69926671-8300-44f4-8c00-a60d18403b69.JPG)
 - 모달창을 띄워 값을 가져오고, 값을 변경하여 수정이 반영되도록 합니다.
 ### (3) Todo 검색
![사본 -검색결과](https://user-images.githubusercontent.com/113006963/209283536-ba746820-45d4-458c-9877-871a843f0444.jpg)
 - 'es'만 검색했을 때 'es'를 포함하는 Todo 검색 결과를 출력합니다.
 ### (4) Todo 삭제
![merge_from_ofoct (2)](https://user-images.githubusercontent.com/113006963/209284016-5db446f6-c7d8-4459-afda-7c10dc6524f4.jpg)
 - confirm창을 띄워 삭제 여부를 묻고 삭제합니다.
 </details>
 <details>
 <summary>Account 메뉴</summary>
 
 ![merge_from_ofoct (1)](https://user-images.githubusercontent.com/113006963/209279395-4d28abd1-95b5-4130-8445-1272ce756791.jpg)
 - 비로그인 상태에서는 **로그인**, **회원가입**이 보이고, 로그인 상태에서는 **ID**와 **user이름**, **로그아웃**이 보입니다.
 </details>

