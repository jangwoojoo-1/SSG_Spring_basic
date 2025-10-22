package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcServlet", value = "/calc")
public class CalcServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("CalcServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CalcServlet doGet");
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CalcServlet doPost");
        doHandle(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("CalcServlet destroy");
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int num1 = Integer.parseInt(req.getParameter("x"));
        int num2 = Integer.parseInt(req.getParameter("y"));
        String operator = req.getParameter("op");

        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>CalcServlet</h1>");
        switch (operator) {
            case "add":
                out.println("<p>출력 : " + num1 + " + " + num2 + " = " + (num1 + num2) + "</p>");
                break;
            case "sub":
                out.println("<p>출력 : " + num1 + " - " + num2 + " = " + (num1 - num2) + "</p>");
                break;
            case "mul":
                out.println("<p>출력 : " + num1 + " * " + num2 + " = " + (num1 * num2) + "</p>");
                break;
            case "div":
                out.println("<p>출력 : " + num1 + " / " + num2 + " = " + (num1 / num2) + "</p>");
                break;
            default:
                out.println("<p>입력이 잘못되었습니다.</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
