package com.ssg.webmvc.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

// VO (Value Object)
@Getter // 읽기만
@Builder //객체 생성시 빌더 패턴을 이용하기 위해 추가
@ToString //객체 값 확인
public class TodoVO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
