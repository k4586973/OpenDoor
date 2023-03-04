package createAccountPage;

import java.sql.Date;

import javax.swing.JOptionPane;

public class RrnCheck {

	private String rrn;
	
	public RrnCheck(String rrn) {
		super();
		this.rrn = rrn;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public boolean check() {

		if(rrn.length()!=8) {

			JOptionPane.showMessageDialog(null, "��������� 8�ڸ��� �ƴմϴ�"
					+"\n�ٽ� �Է����ּ���");
			return true;
			}
		
		String year = rrn.substring(0,4);
		String month = rrn.substring(4,6);
		String day = rrn.substring(6,8);
		String dd=year+"-"+month+"-"+day;
		
		try{
			Date.valueOf(dd);
		}catch(IllegalArgumentException e){

			JOptionPane.showMessageDialog(null, "�߸��� ��������Դϴ�"
					+"\n�ٽ� �Է����ּ���");
			return true;
		}
	
		return false;
	}
}
