package com.ssg.webmvc.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// t odo 하위에 있는 모든 클래스 접근하려면 웹 필터 통해야 한다는 것
@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Login doFilter....................");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        if(session.getAttribute("loginInfo") == null) {
            response.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}

// Filter 인터페이스 import 할 때, javax.servlet 의 Filter 인터페이스 사용
// Filter 인터페이스는 doFilter() 추상 메서드 => 필터가 필터링에 필요한 로직구현하는 부분이다.
// @WebFilter 어노테이션을 통해 특정 경로를 지정해서 해당 경로로 요청(request)에 대해서 doFilter()를 실행하는 구조
// LoginCheckFilter는 /todo/* 브라우저에서 /todo/... 모든 경로에 대해 필터링을 수행하겠다는 의미
// doFilter() (filterchain) 경로를 이용해서 다음 목적지로 이동하여 필터링을 시도할 수 있다.