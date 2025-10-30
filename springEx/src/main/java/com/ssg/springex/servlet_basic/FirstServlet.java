package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "firstServlet", value="/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("FirstServlet init() 메서드 호출");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do Get 메서드 호출");

        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> My Servlet - JJW </h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 메서드 호출");
    }
}
