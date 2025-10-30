# SpringEx: Servlet/JSP 기초 및 TODO 애플리케이션

이 프로젝트는 Spring 프레임워크를 학습하기 전 단계로, **순수 서블릿(Servlet)과 JSP**를 사용하여 웹 애플리케이션의 기본 구조와 동작 원리를 익히는 예제 모음입니다.

## 📚 주요 내용

### 1. 서블릿 기초 (`servlet_basic/`)
* `@WebServlet` 어노테이션을 이용한 서블릿 매핑
* GET/POST 요청 처리 (`doGet`, `doPost`)
* HTML 폼 데이터 처리 (`request.getParameter`)
* JSP 페이지로 포워딩 (`request.getRequestDispatcher`, `forward`)

### 2. DAO 패턴 적용 (`servlet_dao/`)
* 회원 정보(Member) CRUD 기능을 위한 DAO(Data Access Object)와 VO(Value Object) 구현
* 서블릿에서 DAO를 사용하여 데이터 처리 로직 분리

### 3. Spring MVC 스타일 컨트롤러 (`calc/`)
* 간단한 계산기 기능을 Spring MVC의 컨트롤러와 유사한 구조로 구현

### 4. 회원 가입 기능 (`member/`)
* HikariCP를 이용한 커넥션 풀 설정 및 사용
* 회원 가입 폼 처리 및 데이터베이스 연동

### 5. TODO 애플리케이션 (`todo/`)
* **MVC 패턴** 기반의 TODO(할 일 목록) 웹 애플리케이션
* **Controller**: 각 기능별 서블릿 (목록, 등록, 조회, 수정, 삭제)
* **Service**: 비즈니스 로직 처리 (싱글톤 패턴)
* **DAO**: 데이터베이스 연동 (JDBC, HikariCP)
* **DTO/VO**: 데이터 전달 객체 및 값 객체
* **Util**: ModelMapper를 사용한 DTO-VO 변환 유틸리티
* **View**: JSP와 JSTL을 사용한 화면 구현

### 6. 테스트 (`src/test/`)
* JUnit을 사용한 DAO 및 Service 계층 단위 테스트

## 🛠️ 기술 스택

* Java
* Servlet API
* JSP, JSTL
* JDBC
* HikariCP (Connection Pool)
* Lombok
* ModelMapper
* Log4j2
* JUnit
* Tomcat
* Gradle
