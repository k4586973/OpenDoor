package openDoorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import openDoorDBCon.OpenDoorDBCon;

public class CheckAccountDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 

	public CheckAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}
	
	// id, pw �޾Ƽ� ȸ�� ���� üũ
	public boolean memberCheck(String id, String pw) throws SQLException {
		boolean check = false;
		String resultId = null;
		String resultPw = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			resultId = rs.getString("id");
			resultPw = rs.getString("pw");
		}
		if(id.equals(resultId)&&pw.equals(resultPw)) {
			return check = true;
		}
		return check;
	}
	
}
