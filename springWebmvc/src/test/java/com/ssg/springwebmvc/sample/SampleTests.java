package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;


// @Autowired 가 있는 필드의 경우 해당 타입의 객체가 스프링의 컨텍스트 내 존재한다면 실행 시 주입됨
// 생성자 주입 방식 : 주입받는 타입을 final로 선언하고 생성자를 통해서 의존성 주입, Lombok의 @RequiredArgsConstructor를 통해서 생성자 자동 생성

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit 버전에서 spring-test 이용하기 위한 설정 어노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RequiredArgsConstructor
public class SampleTests {
     //Spring에서 사용하는 의존성 주입 어노테이션
    @Autowired
    private SampleService sampleService; // SampleService 를 멤버 변수로 선연
    // 만일 지정된 빈이 존재한다면 이곳에 주입해 주기를 원함
    @Autowired
    private Restaurant restaurant;

    @Autowired
    private DataSource dataSource;
    
    @Test
    public void testSampleService(){
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testRestaurant() {
        log.info(restaurant);
        Assertions.assertNotNull(restaurant);
    }

    // 스프링은 필요한 객체를 스프링이 주입해 주기 때문에 개별적으로 클래스를 작성해서 빈으로 등록해 두기만 하면 원하는 곳에서 쉽게 다른 객체를 사용할 수 있다.

    @Test
    public void testDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }
}
