package com.ssg.springwebmvc.prof;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit 버전에서 spring-test 이용하기 위한 설정 어노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProfTest {
    @Autowired
    private Classroom classroom;

    @Test
    public void testClassroom() {
        log.info(classroom);
        Assertions.assertNotNull(classroom);
    }
}
