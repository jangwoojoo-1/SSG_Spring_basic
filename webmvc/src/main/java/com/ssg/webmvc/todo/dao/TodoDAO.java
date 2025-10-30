package com.ssg.webmvc.todo.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
}
