package com.ssg.springex.member;

import com.ssg.springex.servlet_basic.MemberRegister;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberRegisterController", value="/servlet_basic/memberRegister")
public class MemberRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDao memberDao = new MemberDao();
        MemberVO memberVO = new MemberVO();

        req.setCharacterEncoding("UTF-8");

        memberVO.setId(req.getParameter("user_id"));
        memberVO.setPwd(req.getParameter("user_pwd"));
        memberVO.setGender(req.getParameter("gender"));
        memberVO.setHobby(req.getParameterValues("hobby"));

        boolean isTrue = memberDao.joinMembership(memberVO);

        String msg = "";
        if (isTrue) {
            msg = memberVO.getId() + " 님 회원가입 성공하였습니다.";
        } else {
            msg = "다시 시도해주세요";
        }

        // 5. request 객체에 결과 메시지 저장
        req.setAttribute("message", msg);

        // 6. result.jsp 페이지로 포워딩(forward)
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/result.jsp");
        dispatcher.forward(req, resp);
    }
}
