import java.sql.Connection;

public class InsertMemService {

	UserDao dao = new UserDao();
	
	public int insertMem(UserData userdata) {
		int result = 0;
		Connection conn = null;
		
		// 프로바이더는 potato.util에 있음
		conn = ConnectionProvider.getConnection();
		
		result = dao.insertMem(conn, userdata);
		
		return result;
	}
	
//	public boolean signUp(UserData userdata) {
//		Connection conn = null;
//		boolean result = false;
//		
//		conn = ConnectionProvider.getConnection();
//		
//		if(dao.insertMem(conn, userdata)==1)
//			result = true;
//		
//		return result;
//	}
}
