package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.SearchControls;

import openDoorDBCon.*;
import openDoorVo.*;


public class UpdateAccountDAO {
	
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public UpdateAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}

	public ArrayList<OpenDoorVO> lolidpw(String id,String pw){
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "select * from member where  id = ? and pw = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id1 = rs.getString("id");
			String pw1 = rs.getString("pw");
			String name = rs.getString("name");	
			String gender =rs.getString("gender");
			Date rrn = rs.getDate("rrn");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String tel = rs.getString("tel");
			String pwq = rs.getString("pwq");
			String pwa = rs.getString("pwa");
			
			OpenDoorVO open = new OpenDoorVO(id1,pw1,name,gender,rrn,job,prop,tel,pwq,pwa);
		}
			
			
			
			
	}
	
	
	
	public boolean update_gogek(String pw1, String pwconfirm1, String job1, int prop1, String tel1, String pwq1,
			String pwa1, String pwaconfirm1) {
		
		
		
		
		return false;
	}
	
	
	

}
