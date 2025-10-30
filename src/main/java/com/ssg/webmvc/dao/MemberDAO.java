package com.ssg.webmvc.dao;

import com.ssg.webmvc.domain.MemberVO;
import com.ssg.webmvc.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception{
        String sql = "select * from t_member where mid = ? and mpw = ?";
        MemberVO vo = null;
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, mid);
        ps.setString(2, mpw);

        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .build();

        return vo;
    }
}
