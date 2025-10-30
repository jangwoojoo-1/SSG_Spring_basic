import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }


    @Test
    public void testRegister() throws Exception {
        TodoDTO dto = TodoDTO.builder()
                .title("TodoDTO Title 3")
                .dueDate(LocalDate.now())
                .build();

        todoService.register(dto);
    }
}
