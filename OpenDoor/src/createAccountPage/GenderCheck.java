package createAccountPage;

import javax.swing.JOptionPane;

public class GenderCheck {

	private String gender;
	
	public GenderCheck(String gender) {
		super();
		this.gender = gender;
	}

	public String getGenderN() {
		return gender;
	}

	public void setGenderN(String gender) {
		this.gender = gender;
	}

	public boolean check() {
		if(gender.equals("��")) {
			return false;
		}else if(gender.equals("��")) {
			return false;
		}
		
		JOptionPane.showMessageDialog(null, "������ �߸��Ǿ����ϴ�"
				+"\n�ٽ� �������ּ���");
		return true;
	}
}
