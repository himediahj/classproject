package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		
		// 1. 드라이버 로드 ( 생략 가능 )
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";	
			//String dbUrl = "jdbc:mysql://localhost:3306/project";	// 맨 마지막 스키마 이름
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			
			if(conn != null) {
				System.out.println("데이터베이스 연결!!!");
				conn.close();
			}
			
			// 3. Statement 또는 PreparedStatement 
			// 4. ResultSet

			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
