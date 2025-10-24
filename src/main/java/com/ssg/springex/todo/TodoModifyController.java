package com.ssg.springex.todo;

import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    private TodoDAO dao = new TodoDAO();
    private ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // modify.jsp 파일 불러옴
        req.setCharacterEncoding("UTF-8");

        long tno = Long.parseLong(req.getParameter("readTno"));


        try {
            TodoDTO dto = modelMapper.map(dao.selectOne(tno), TodoDTO.class);
            req.setAttribute("post", dto);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // modify.jsp 파일에서 작업 수행 하면 post로 불러와서
        // 그 데이터에 따라 SERVICE 통해 수정 작업 진행
        // Redirect(GET 방식)으로 list로 이동
        req.setCharacterEncoding("UTF-8");
        long tno = Long.parseLong(req.getParameter("readTno"));
        String title = req.getParameter("readTitle");
        LocalDate date = LocalDate.parse(req.getParameter("readDueDate"));
        boolean finished = Boolean.parseBoolean(req.getParameter("readFinished"));

        TodoVO vo = TodoVO.builder()
                .tno(tno)
                .title(title)
                .dueDate(date)
                .finished(finished)
                .build();

        try {
            dao.updateOne(vo);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
