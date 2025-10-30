package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="memberRegister", value = "/dgmemberRegister")
public class MemberRegister extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("user_id");
        String pwd = req.getParameter("user_pwd");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>MemberRegisterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>MemberRegisterServlet</h1>");
        out.println("<h2>id:"+id+"</h2>");
        out.println("<h2>pwd:"+pwd+"</h2>");
        out.println("<h2>gender:"+gender+"</h2>");
        out.println("<h2>hobbies</h2>");
        for(String str : hobbies){
            out.println("<h2>- " + str + "</h2>");
        }
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
