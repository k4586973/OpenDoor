package createAccountPage;

import javax.swing.JOptionPane;

public class LengthCheck {

	private String str;
	
	public LengthCheck(String str) {
		super();
		this.str = str;
	}

	public String getName() {
		return str;
	}

	public void setName(String str) {
		this.str = str;
	}

	public boolean check() {
		if(str==null||str.length()==0) {
			JOptionPane.showMessageDialog(null, "�Է����� ���� ������ �ֽ��ϴ�");
			return true;
		}else if(str.replace(" ", "").length()==0) {
			JOptionPane.showMessageDialog(null, "�Է����� ���� ������ �ֽ��ϴ�");
			return true;
		}
		else if(str.length()>32) {

			JOptionPane.showMessageDialog(null, "�ִ� 32�ڱ��� �Է� �����մϴ�"
					+"\n�ٽ� �Է����ּ���");
			return true;
		}
	
		return false;
	}
}
