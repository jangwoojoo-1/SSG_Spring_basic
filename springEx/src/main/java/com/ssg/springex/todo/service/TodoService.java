package com.ssg.springex.todo.service;

//객체의 수를 결정할 때 사용한다.
// 현재는 INSTANCE 가 한 개이므로 서비스객체 1개만 운영
// TodoService.INSTANCE 접근
// 객체를 하나만 생성해서 사용 (singleton pattern)
//여러 컨트롤러들이 TodoSerivce 객체를 통해서 원하는 데이터를 주고받는 구조로 구성
// 장점 : 정해진 수만큼 객체를 생성할  수 있다.

import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.util.MapperUtil;
import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        //System.out.println("todoVO : " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
        // register() TodoDTO 파라미터를 받아서 ModelMapper를 통해 TodoVO 객체로 변환을 한 후
        // dao.insert(todoVO) 를 통해 todoVO 객체를 전달하며 등록 기능을 요청
    }


    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList----------------");
        log.info(voList);
        List<TodoDTO> dtoList = voList.stream()
                .map( vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO get(long tno) throws Exception {
        TodoVO vo = dao.selectOne(tno);

        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;
    }
}