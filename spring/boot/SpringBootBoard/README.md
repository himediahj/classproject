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


