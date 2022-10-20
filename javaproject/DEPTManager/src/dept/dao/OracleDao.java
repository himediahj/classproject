package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;

public class OracleDao implements Dao {

	@Override
	public List<Dept> select(Connection conn) throws SQLException {

		// 결과 데이터
		List<Dept> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement(); // 변수 없으니까 statement, 있으면 preparestatement

			String sql = "select * from dept";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 각 행의 데이터를 Dept 객체로 생성 -> List에 추가

				// list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"),
				// rs.getString("loc")));
				list.add(rowToDept(rs));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}

		}

		return list;
	}

	@Override
	public Dept selectByDeptno(Connection conn, int deptno) throws SQLException {
		Dept dept = null;

		String sql = "select * from dept where deptno=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 물음표에 10을 넣을거야

			// Select의 결과를 담고 있는 객체
			rs = pstmt.executeQuery();

			// 행이 한개 나오는 경우는 반복시키지 않고 if로
			if (rs.next()) {
				dept = rowToDept(rs);
			}
		} finally {

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return dept;
	}

	private Dept rowToDept(ResultSet rs) throws SQLException {

		return new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
	}

	@Override
	public int insert(Connection conn, Dept dept) throws SQLException {
		int result = 0; // 반영된 개수 반환

		PreparedStatement pstmt = null;

		// 입력 처리
		String sql = "insert into dept values (?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			result = pstmt.executeUpdate();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
		}

		return 0;
	}

	@Override
	public int update(Connection conn, Dept dept) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update dept set dname =?, loc=? where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return result;
	}

	@Override
	public int delete(Connection conn, int deptno) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;

		// 삭제 처리

		String sql = "delete dept where deptno=?";

		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);

		result = pstmt.executeUpdate();
		} finally {
			if(pstmt !=null)
				pstmt.close();
		}

	

		return result;
	}

}
