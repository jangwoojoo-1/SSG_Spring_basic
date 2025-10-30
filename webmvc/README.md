# Webmvc: Servlet/JSP 기반 TODO 애플리케이션 (MVC 패턴)

이 프로젝트는 **Servlet과 JSP**를 사용하여 **MVC(Model-View-Controller) 패턴**을 적용한 기본적인 TODO(할 일 목록) 웹 애플리케이션입니다.

`springEx` 프로젝트의 `todo` 패키지와 유사하지만, 별도의 프로젝트로 분리되어 MVC 패턴 구조 학습에 집중합니다.

## 📚 주요 내용

* **Controller**: 각 기능별 서블릿 (목록, 등록, 조회, 수정, 삭제)
* **Service**: 비즈니스 로직 처리 (싱글톤 패턴)
* **DAO**: 데이터베이스 연동 (JDBC, HikariCP)
* **DTO/VO**: 데이터 객체 정의
* **View**: JSP와 JSTL을 이용한 화면 구현
* **계산기 예제 포함**: 간단한 계산기 기능 서블릿 컨트롤러(프로젝트와는 무관)

## 🛠️ 기술 스택

* Java
* Servlet API
* JSP, JSTL
* JDBC
* HikariCP
* Lombok
* ModelMapper
* Log4j2
* JUnit
* Tomcat
* Gradle
