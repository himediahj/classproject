package com.firstcoding.firstapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {


    public static Connection getConnection() throws Exception {
        // Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "scott", "tiger");

        return conn;
    }
}
