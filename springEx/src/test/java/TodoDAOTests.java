import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;


// Connection 부분은 항상 테스트 진행하고 작업 시작해야 함.
public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO vo = TodoVO.builder()
                .title("sample Title todo...")
                .dueDate(LocalDate.now())
                .build();
        todoDAO.insert(vo);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO vo = todoDAO.selectOne(1L);
        System.out.println(vo);
    }

    @Test
    public void testUpdate() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(1)
                .title("sample Title todo... 1L")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoDAO.updateOne(vo);
    }

    @Test
    public void testDelete() throws Exception {
        todoDAO.deleteOne(1L);
    }
}
