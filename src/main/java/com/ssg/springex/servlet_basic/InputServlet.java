package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="inputServlet", value = "/input")
public class InputServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Input Servlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String[] checkboxs = req.getParameterValues("subject");
        for(String str : checkboxs){
            System.out.println(str);
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet LoginServlet</h1>");
        for(String str : checkboxs){
            out.println("<h2>" + str + "</h2>");
        }
        out.println("</body>");
        out.println("</html>");


    }
}
