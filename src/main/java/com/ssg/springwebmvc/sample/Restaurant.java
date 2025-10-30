package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Restaurant {
    // 하나의 객체를 계속 사용하기에 final( 싱글톤 )
    private final Chef chef;

    @Override public String toString(){
        return "Restaurant(Chef=" + AopUtils.getTargetClass(chef).getName() + ")";
    }
}
