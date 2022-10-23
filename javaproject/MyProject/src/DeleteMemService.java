import java.sql.Connection;

public class DeleteMemService {

	UserDao dao = new UserDao();
	
	public int deleteMem() {
		int result = 0;
		Connection conn = null;
		
		conn = ConnectionProvider.getConnection();
		
		result = dao.deleteMem(conn, 현재아이디);
		return result;
	}
}
