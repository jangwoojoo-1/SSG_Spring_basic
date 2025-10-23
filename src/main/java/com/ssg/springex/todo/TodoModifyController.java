package com.ssg.springex.todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // modify.jsp 파일 불러옴
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // modify.jsp 파일에서 작업 수행 하면 post로 불러와서
        // 그 데이터에 따라 SERVICE 통해 수정 작업 진행
        // Redirect(GET 방식)으로 list로 이동
    }
}
