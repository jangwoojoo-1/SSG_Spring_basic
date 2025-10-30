package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Locale;

@Controller    // 해당 클래스가 스프링 MVC 에서 컨트롤러 역할을 한다. 스프링의 빈으로 등록
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(){
        log.info("hello springwebmvc!");
    }

    @GetMapping("/ex01")
    public void ex01(String name, int age) {
        log.info("ex01에서 수집한 파라미터");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex02")
    public void ex02(@RequestParam(name="name", defaultValue = "lalala") String name,
                     @RequestParam(name="age", defaultValue = "10") int age){
        log.info("ex02에서 수집한 파라미터");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex03")
    public void ex03(LocalDate dueDate){
        log.info("ex03에서 수집한 파라미터");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex04")
    public void ex04(Model model){
        log.info("ex04 Model 파라미터");
        model.addAttribute("message", "Hello Spring MVC");
    }

    @GetMapping("/ex04_1")
    public void ex04_1(TodoDTO todoDTO, Model model){
        log.info(todoDTO);
        model.addAttribute("todoDTO", todoDTO);
    }

    @GetMapping("/ex05")
    public String ex05(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name", "jk");
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex06";
    }

    @GetMapping("/ex06")
    public void ex06(){}

    @GetMapping("/ex07")
    public void ex07(int m1, String m2){
        log.info("m1: " + m1);
        log.info("m2: " + m2);
    }
}

/*
* 서블릿 MVC의 경우
* Servlet 상속받아서 doGet()/doPost() 오버라이드하여 사용함
*
* 스프링 MVC의 경우
* 하나의 컨트롤러를 이용하여
* 여러 경로의 호출을 모두 처리할 수 있ㄷ
* */
