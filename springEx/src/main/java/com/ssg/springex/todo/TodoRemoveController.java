package com.ssg.springex.todo;

import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="todoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private TodoDAO dao = new TodoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // modify.jsp 파일에서 작업 수행 하면 post로 불러와서
        // 그 데이터에 따라 SERVICE 통해 수정 작업 진행
        // Redirect(GET 방식)으로 list로 이동
        req.setCharacterEncoding("UTF-8");
        long tno = Long.parseLong(req.getParameter("readTno"));

        try {
            dao.deleteOne(tno);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
