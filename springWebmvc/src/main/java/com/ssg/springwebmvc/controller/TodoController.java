package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list(){
        log.info("TODO list Controller!");
    }

    @RequestMapping(value = "/register", method= RequestMethod.GET)
    public void register(){
        log.info("TodoController Register method ~");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO){
        log.info("Post TOdo register...");
        log.info(todoDTO);
    }

    @GetMapping("/ex01")
    public void ex01(String name, int age) {
        log.info("ex01에서 수집한 파라미터");
        log.info("name: " + name);
        log.info("age: " + age);
    }
}
