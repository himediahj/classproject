package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {
		
		// 1. 드라이버 로드 ( 생략 가능 )
		
		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";	
			//String dbUrl = "jdbc:mysql://localhost:3306/project";	// 맨 마지막 스키마 이름
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			
//			if(conn != null) {
//				System.out.println("데이터베이스 연결!!!");
//				//conn.close();
//			}
			
			// 3. Statement 또는 PreparedStatement 
			
			
			String sql = "select * from dept where deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);	// 첫번째 물음표에 10을 넣을거야
			
			// Select의 결과를 담고 있는 객체
			ResultSet rs = pstmt.executeQuery();
			
		
			// 행이 한개 나오는 경우는 반복시키지 않고 if로 
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
		
				
				System.out.printf("%d \t %s \t %s\n", deptno, dname, loc);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			
			// 4. ResultSet

			
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
