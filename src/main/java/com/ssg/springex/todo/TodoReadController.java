package com.ssg.springex.todo;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/read doGet()");


        req.setCharacterEncoding("UTF-8");
        Long tno = Long.parseLong(req.getParameter("tno"));
        log.info(tno);

        try {
            TodoDTO dto = TodoService.INSTANCE.get(tno);
            req.setAttribute("post", dto);
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
