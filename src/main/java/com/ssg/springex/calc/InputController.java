package com.ssg.springex.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InputController 요청된 doGet()");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/calc/input.jsp"); //원하는 위치로 이동 가
        rd.forward(req, resp); // 서블릿에서 전달된 요청을 다른쪽으로 전달 또는 배포하는 역할을 하는 객체 -> 즉, 객체를 들고 감
    }
}
