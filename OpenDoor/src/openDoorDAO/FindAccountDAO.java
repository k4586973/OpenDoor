package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import openDoorDBCon.*;
import openDoorVo.*;

public class FindAccountDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public FindAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}
	
	// ���̵� ã�� : param(name, tel) , rtn(id)
	public String getId(String inputName, String inputTel) throws SQLException {
		String id = null;
		String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND TEL = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputName);
		pstmt.setString(2, inputTel);
		rs = pstmt.executeQuery();
		
		if(rs.next()) 
			id = rs.getString(1);
		return id;
	}// getId-end------
	
	// �н����� ã�� : param(id) , rtn(ArrayList<OpenDoorVO>)
	// �Է��� id�� �ִ��� Ȯ���ϰ� All ���� �ޱ�
	public ArrayList<OpenDoorVO> getIdInfo(String searchId) throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, searchId);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			Date rrn = rs.getDate("rrn");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String tel = rs.getString("tel");
			String face = rs.getString("face");
			String pwq = rs.getString("pwq");
			String pwa = rs.getString("pwa");
			
			OpenDoorVO mem = new OpenDoorVO(id,pw,name,gender,rrn,job,prop,tel,face,pwq,pwa); 
			memArray.add(mem);
		}
		return memArray;
	}// getIdInfo-end------
	
	// �н����� ã�� : param(id) , rtn(pwa)
	// �ش� id�� pw �н� ������ �� ���
	public String getPwa(String inputId) throws SQLException {
		String pwa = null;
		String sql = "SELECT PWA FROM MEMBER WHERE ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputId);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			pwa = rs.getString(1);
		return pwa;
	}

	// �н����� ã�� : param(id) , rtn(pw)
	// �ش� id�� ����� �����ֱ�
	public String getPw(String findId) throws SQLException {
		String pw = null;
		String sql = "SELECT PW FROM MEMBER WHERE ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, findId);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			pw = rs.getString(1);
		return pw;
	}
}
