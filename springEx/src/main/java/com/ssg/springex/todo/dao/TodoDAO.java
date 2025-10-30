package com.ssg.springex.todo.dao;

import com.ssg.springex.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TodoDAO {

    public String getTime(){
        String now = null;

        try(Connection conn = ConnectionUtil.INSTANCE.getConnection();){
            PreparedStatement pstmt = conn.prepareStatement("select now()");

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                now = rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return now;
    }

    // 자동 클로즈가 보장되는 코드
    // 종속적이긴 함
    public String getTime2() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        String now = rs.getString(1);
        return now;
    }


    public void insert(TodoVO todoVO) throws Exception{
        String sql = "insert into todo(title, dueDate, finished) values(?,?,?)";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todoVO.getTitle());
        pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        pstmt.setBoolean(3, todoVO.isFinished());
        int result = pstmt.executeUpdate();

    }

    public List<TodoVO> selectAll() throws Exception{
        String sql = "select * from todo";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();
        while(rs.next()){
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(long tno) throws Exception {
        String sql = "select * from todo where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        TodoVO vo = TodoVO.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();
        return vo;
    }

    public void deleteOne(Long tno) throws Exception {
        String sql = "delete from todo where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        pstmt.executeUpdate();

    }

    public void updateOne(TodoVO todoVO) throws Exception{
        String sql = "update todo set title = ?, dueDate = ?, finished = ? where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todoVO.getTitle());
        pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        pstmt.setBoolean(3, todoVO.isFinished());
        pstmt.setLong(4, todoVO.getTno());

        pstmt.executeUpdate();
    }
}
