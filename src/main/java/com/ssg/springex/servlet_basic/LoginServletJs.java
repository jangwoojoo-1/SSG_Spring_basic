package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="LoginServletJs", value="/login3")
public class LoginServletJs extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("LoginServletJs init");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet doPost() 메서드 호출");
        doHandle(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet doGet() 메서드 호출");
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doHandle 메서드 호출");
        req.setCharacterEncoding("UTF-8");

        String user_id = req.getParameter("user_id");
        String user_pwd = req.getParameter("user_pwd");
        String user_address = req.getParameter("user_address");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String data = "<html>";
        data+="<body>";
        data += "<h1>" + user_id + "</h1>";
        data += "<p>" + user_pwd + "</p>";
        data += "<p>" + user_address + "</p>";
        data += "<a href=\"http://localhost:8080/login2.html\">로그인 화면</a>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }
}