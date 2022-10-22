import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao { // Userdata 만들어야됨.

	// 회원가입 dao
	public int insertMem(Connection conn, UserData userdata) {;
		int result = 0;
		String sql = "Insert into user values (?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		// try 묶어주고
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  userdata.getId());
		pstmt.setString(2,  userdata.getPassword);
		pstmt.setString(3,  userdata.getNickname);
		pstmt.setString(4,  userdata.getLoc);
		
		result = pstmt.executeUpdate();
		
		// finally{
		// if(pstmt != null) pstmt.close();
		//}
		return result;
	}
	
	// 회원가입 시 ID 중복체크 dao
	public boolean chkId(Connection conn, String id) {
		
		ResultSet rs = null;
		String sql = "select id from user where id=?";
		boolean result = true;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요.");
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		
		
		return result;
		
	}
	
	// 회원수정 dao
	 public int editMem(Connection conn, UserData userdata, String 현재아이디) {
		int result = 0;
		String sql = "update user set password=?, nickname=?, loc=? where id=" + "'" + 현재아이디 +"'";
		PreparedStatement pstmt = null;
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userdata.getPassword());
		pstmt.setString(2, userdata.getNickname());
		pstmt.setString(3,  userdata.getLoc());
		
		result = pstmt.executeUpdate();
		
		//finally{
		//if(pstmt!=null) pstmt.close();
		//}
		return result;
	}
	 
	 // 회원 탈퇴 dao
	 public int deleteMem(Connection conn, String 현재아이디) {
		 int result = 0;
		 String sql = "delete from user where id=?";
		 PreparedStatement pstmt = null;
		 
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, 현재아이디);
		 
		 result = pstmt.executeUpdate();
	 }
	 
}
