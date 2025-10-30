# SpringWebmvc: Spring MVC 기초 및 MyBatis 연동

이 프로젝트는 **Spring MVC 프레임워크**를 사용하여 웹 애플리케이션을 개발하는 기본적인 방법을 학습하는 예제 모음입니다. Spring의 핵심 기능인 의존성 주입(DI), MyBatis를 이용한 데이터베이스 연동 등을 다룹니다.

## 📚 주요 내용

### 1. Spring MVC 기본 설정
* `web.xml`: DispatcherServlet 설정
* `servlet-context.xml`: 컴포넌트 스캔, ViewResolver, 정적 자원 매핑 등 설정
* `root-context.xml`: Service, DAO, DataSource, MyBatis 설정 (HikariCP, `SqlSessionFactoryBean`)

### 2. 컨트롤러 (`controller/`)
* `@Controller`, `@RequestMapping`, `@GetMapping`, `@PostMapping` 어노테이션 활용
* 요청 파라미터 처리 (`@RequestParam`, DTO 바인딩)
* Model 객체를 이용한 데이터 전달
* RedirectAttributes를 이용한 리다이렉트 시 데이터 전달
* 데이터 형식 변환 (Formatter): `LocalDate` 타입 처리
* 예외 처리 (`@ControllerAdvice`, `@ExceptionHandler`)

### 3. 의존성 주입 (DI) 예제 (`sample/`, `prof/`)
* `@Component`, `@Service`, `@Repository` 어노테이션
* `@Autowired`, `@RequiredArgsConstructor` (Lombok) 를 이용한 의존성 주입

### 4. MyBatis 연동 (`mapper/`, `resources/mappers/`)
* Mapper 인터페이스와 XML 매퍼 파일을 이용한 SQL 실행
* `@MapperScan` 설정 (`root-context.xml`)

### 5. TODO 애플리케이션 (Spring MVC 버전)
* `TodoController`를 중심으로 Spring MVC 구조에 맞게 TODO 기능 구현
* DTO 사용 및 유효성 검증 (향후 추가 가능)
* JSP 뷰 페이지

### 6. 테스트 (`src/test/`)
* JUnit과 Spring TestContext Framework를 이용한 DI 및 MyBatis 연동 테스트

## 🛠️ 기술 스택

* Java
* Spring MVC
* Servlet API, JSP, JSTL
* MyBatis
* HikariCP
* Lombok
* Log4j2
* JUnit, Spring Test
* Tomcat
* Gradle
