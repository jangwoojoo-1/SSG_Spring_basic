package com.ssg.springex.member;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

public class MemberDao {
    private static HikariDataSource ds;
    static{
        // HikariCP 설정
        try {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/memberDB?serverTimezone=Asia/Seoul&charEncoding=UTF-8");
            config.setUsername("root");
            config.setPassword("mysql1234");

            ds = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean joinMembership(MemberVO memberVO) {
        String sql = "insert into memberinfo(id, password, gender, hobby) values(?,?,?,?)";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, memberVO.getId());
            pstmt.setString(2, memberVO.getPwd());
            pstmt.setString(3, memberVO.getGender());
            pstmt.setString(4, Arrays.toString(memberVO.getHobby())); // 합쳐진 문자열을 저장

            int result = pstmt.executeUpdate();
            if(result > 0)return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
