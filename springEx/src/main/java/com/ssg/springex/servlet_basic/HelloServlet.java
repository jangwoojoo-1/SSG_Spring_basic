package com.ssg.springex.servlet_basic;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.time.LocalTime.now;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("HelloServlet init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("HelloServlet doGet");
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doPost");
        doHandle(req, resp);
    }

    public void destroy() {
        System.out.println("destroy() 메서드 호출");
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HelloServlet</h1>");
        out.println("<h2>안녕하세요, 서블릿!</h2>");
        out.println("<p>" + formattedDateTime + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}