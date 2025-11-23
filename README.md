# SSG Spring Basic 학습 레포지토리

이 레포지토리는 Spring 프레임워크와 웹 개발 기초를 학습하기 위한 다양한 예제 프로젝트들을 모아둔 공간입니다. 순수 서블릿(Servlet)과 JSP를 사용한 웹 애플리케이션부터 Spring MVC, MyBatis 연동, 의존성 주입(DI) 등 Spring의 핵심 개념을 다루는 예제까지 포함되어 있습니다.

## 📚 프로젝트 구성

각 하위 폴더는 특정 기술 스택이나 학습 목표에 초점을 맞춘 독립적인 프로젝트 또는 예제 모음입니다. 자세한 내용은 각 폴더의 README 파일을 참고하세요.

* **[springEx](./springEx/README.md)**: 순수 Servlet/JSP 기반의 웹 애플리케이션 예제 (계산기, 회원 관리, TODO 앱 등)
* **[springWebmvc](./springWebmvc/README.md)**: Spring MVC 프레임워크를 사용한 웹 애플리케이션 예제 (컨트롤러, MyBatis 연동, DI 등)
* **[webmvc](./webmvc/README.md)**: Servlet/JSP 기반 TODO 애플리케이션 (MVC 패턴)
* **[webmvc_version2](./webmvc_version2/README.md)**: `webmvc` 프로젝트에 로그인/로그아웃 기능 및 필터(Filter)를 추가한 버전

## ⚙️ 주요 학습 내용

* Servlet/JSP를 이용한 웹 프로그래밍 기초
* MVC(Model-View-Controller) 패턴 이해 및 적용
* Spring MVC 프레임워크 기본 구조 및 동작 방식
* 의존성 주입(Dependency Injection, DI) 개념 및 활용 (`@Autowired`, `@RequiredArgsConstructor`)
* MyBatis를 이용한 데이터베이스 연동
* DTO(Data Transfer Object)와 VO(Value Object) 개념 및 활용 (ModelMapper)
* JDBC 및 커넥션 풀 (HikariCP) 사용
* 웹 필터(Filter)를 이용한 공통 기능 처리 (로그인 체크, 인코딩)
* JSTL(JSP Standard Tag Library) 사용법
* JUnit을 이용한 단위 테스트 작성

## ▶️ 실행 방법

각 프로젝트는 독립적으로 실행 가능합니다. 빌드 도구(Gradle)와 웹 서버(Tomcat 등)를 사용하여 각 프로젝트를 빌드하고 배포하여 실행할 수 있습니다. 자세한 설정은 각 프로젝트의 `build.gradle` 파일과 웹 서버 설정을 참고하세요.

## 느낀 점

* 순수 자바 프로그래밍에서 벗어나 gradle을 활용한 스프링 방식의 프로그래밍을 처음 경험할 수 있어서 좋았습니다.
* 그 과정에서 MyBatis를 활용하면 기존의 jdbc 방식과 다르게 코드와 sql문을 분리해서 프로그래밍할 수 있다는 것을 이해할 수 있었고,
* JSP를 활용해 Tomcat으로 웹을 구성하고, SSR 방식으로 페이지를 전환할 수 있다는 것을 배울 수 있었습니다.
* 다만, 자바 백엔드에서 처리한 데이터를 JSP에 띄우는 과정에서 에러가 발생했을 때 그 에러를 찾는 과정에서 많은 어려움을 겪었습니다.
* 기존 자바 콘솔에서 프로그래밍할 때는 콘솔에서 바로 오류 나는 부분이 나타났기에 오류 처리하는 게 비교적 쉬웠지만, JSP에서는 웹에서부터 쭉 추적을 해서 오류나는 부분을 찾아야 했기에 오류 처리에 많은 시간을 투자했었습니다.
* 하지만 이를 통해, 오류를 추적하는 능력을 향상시키고, 코드 작성에 있어서 정확도의 중요성을 깨달을 수 있어서 의미 있었던 시간이었다고 생각합니다. 
