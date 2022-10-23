import java.sql.Connection;

public class chkIdService {

	UserDao dao = new UserDao();
	
	public String chkId() {
		String id = null;
		boolean run = true;
		Connection conn = null;
		
		conn = ConnectionProvider.getConnection();
		
		while(run) {
			System.out.println("ID >> ");
			id = InputString.scan.nextLine();
			run = dao.chkId(conn, id);
		}
		return id;
	}
}
