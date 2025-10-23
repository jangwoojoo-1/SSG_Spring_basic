package com.ssg.springex.member;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class HikariCP {
    private static HikariDataSource ds;


    private HikariCP(){}

    // getInstance()
    public static HikariDataSource getInstance() {
        if (ds == null) {
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

        return ds;
    }
}
