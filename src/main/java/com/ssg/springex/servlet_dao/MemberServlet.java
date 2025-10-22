package com.ssg.springex.servlet_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDao dao = new MemberDao(); //SQL문으로 조회할 MemberDAO 객체를 생성
        List<MemberVO> memberList = dao.listMembers(); //listMembers() 메서드를 통해서 회원정보를 조회한 후, 조회 결과인 회원정보 리스트를 전달 받음

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>meberList</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border=1><tr align='center' bgcolor='lightgreen'> ");
        out.println("<th>ID</th><th>Name</th><th>Email</th><th>가입일</th></tr>");
        for(int i = 0; i < memberList.size(); i++){
            String id = memberList.get(i).getId();
            String name = memberList.get(i).getName();
            String email = memberList.get(i).getEmail();
            Date joinDate = memberList.get(i).getJoinDate();

            out.println("<tr><td>" + id + "<td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
