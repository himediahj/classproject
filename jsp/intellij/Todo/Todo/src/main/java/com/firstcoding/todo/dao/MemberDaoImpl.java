package com.firstcoding.todo.dao;

import com.firstcoding.todo.domain.MemberDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
    public int insertMem (Connection conn, MemberDTO member) throws SQLException {
        String sql = "insert into member (uid, pw) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getUid());
        pstmt.setString(2, member.getPw());
        int result = pstmt.executeUpdate();
        return result;
    }

    public MemberDTO searchByUidPw (Connection conn, String uid, String pw) throws SQLException {
        String sql = "select * from member where uid=? and pw=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uid);
        pstmt.setString(2, pw);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        MemberDTO member = null;
        if(rs.next()){
            member = MemberDTO.builder()
                    .idx(rs.getInt(1))
                    .uid(rs.getString(2))
                    .pw(rs.getString(3))
                    .uuid(rs.getString(4))
                    .build();
        }
        return member;
    }
}
