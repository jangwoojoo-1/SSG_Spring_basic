package com.ssg.springex.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


// DTO 용도 : 여러 개의 데이터를 묶어서 하나의 객체로 구성
//  서비스 객체 메소드들의 파라미터나 리턴 타입으로 사용됨
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long tno;  //todo 고유값
    private String title;   //할일 제목
    private LocalDate dueDate;  //등록 시간
    private boolean finished; //할일을 체크
}
