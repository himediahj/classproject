package com.firstcoding.firstapp.dept;

import com.firstcoding.firstapp.util.ConnectionUtil;
import com.mysql.cj.protocol.Resultset;
import lombok.Cleanup;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
    public List<Dept> selectAll(Connection conn) throws SQLException {

        String sql = "Select * from dept";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);  // Cleanup close 대신해줌
        @Cleanup ResultSet rs = pstmt.executeQuery();
        List<Dept> result = new ArrayList<>();


        while(rs.next()){
            result.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }


        return result;
    }
}
