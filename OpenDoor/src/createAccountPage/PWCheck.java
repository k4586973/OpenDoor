package createAccountPage;

import javax.swing.JOptionPane;

public class PWCheck {

	String pw;

	public PWCheck(String pw) {
		super();
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean check() {
		if(pw==null||pw.length()==0) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
			return true;
		}else if(!(pw.equals(pw.replace(" ", "")))) {
			JOptionPane.showMessageDialog(null, "������ ��й�ȣ�� ��� �Ұ����մϴ�"
					+"\n�ٽ� �Է����ּ���");
			return true;
		}else if(pw.length()>32){
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �ִ� 32�� ���� �����մϴ�"
				+"\n�ٽ� �Է����ּ���");
			return true;
		}
		return false;
	}
}
