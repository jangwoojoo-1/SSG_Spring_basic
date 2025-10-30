package com.ssg.springwebmvc.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


// @Autowired 가 있는 필드의 경우 해당 타입의 객체가 스프링의 컨텍스트 내 존재한다면 실행 시 주입됨
// 생성자 주입 방식 : 주입받는 타입을 final로 선언하고 생성자를 통해서 의존성 주입, Lombok의 @RequiredArgsConstructor를 통해서 생성자 자동 생성

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit 버전에서 spring-test 이용하기 위한 설정 어노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RequiredArgsConstructor
public class TimeMapperTests {
    @Autowired(required=false)
    private TimeMapper timeMapper;

    @Autowired(required=false)
    private TimeMapper2 timeMapper2;

    @Test
    public void testTimeMapper(){
        log.info(timeMapper.getTimeNow());
    }

    @Test
    public void testTimeMapper2(){
        log.info(timeMapper2.getNow());
    }

/*    전체 흐름 요약
*     1. XML 파싱 및 컨텍스트 초기화
*     2. Component Scan으로 Bean 등록
*     3. HikariCP 설정 -> 커넥션 풀 생성
*     4. 트랜잭션 매니저 등록
*     5. @Transactional AOP 프록시 활성화
*     6. SqlSessionFactory 생성 -> XML 매퍼 로딩
*     7. Mapper 인터페이스 자동 스캔 및 연결
*     8. 컨텍스트 초기화 완료 -> 애플리케이션 실행
*   */
}
