# Webmvc Version 2: TODO 앱 + 로그인 기능 및 필터

이 프로젝트는 `webmvc` 프로젝트를 기반으로 **로그인/로그아웃 기능**과 **서블릿 필터(Filter)**를 추가하여 웹 애플리케이션의 인증 및 공통 처리 기능을 학습하는 버전입니다.

## 📚 주요 변경 및 추가 사항

### 1. 로그인/로그아웃 기능
* **LoginController**: 로그인 폼 표시 및 로그인 처리 (세션 사용)
* **LogOutController**: 로그아웃 처리 (세션 무효화)
* **MemberService/DAO**: 회원 정보 조회 및 인증 로직
* **MemberDTO/VO**: 회원 데이터 객체
* 로그인 뷰 페이지 (`login.jsp`)

### 2. 서블릿 필터 (`filter/`)
* **UTF8Filter**: 모든 요청에 대해 UTF-8 인코딩 설정
* **LoginCheckFilter**: 특정 경로(`/todo/*`) 접근 시 로그인 여부 확인 및 리다이렉트
* `web.xml`에 필터 등록 및 매핑 설정

### 3. TODO 애플리케이션 (`todo/`)
* 기존 `webmvc` 프로젝트의 TODO 기능 유지 (Controller, Service, DAO, DTO/VO, View)

### 4. 기타
* `calc` 패키지: 계산기 예제 포함
* 테스트 코드 (`src/test/`)

## 🛠️ 기술 스택

* Java
* Servlet API, JSP, JSTL
* Servlet Filter API
* JDBC
* HikariCP
* Lombok
* ModelMapper
* Log4j2
* JUnit
* Tomcat
* Gradle
