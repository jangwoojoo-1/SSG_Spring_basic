package com.ssg.springwebmvc.prof;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class Classroom {
    private final Professor professor;
}
