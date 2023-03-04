package createAccountPage;

import javax.swing.JOptionPane;

public class TelCheck {

	private String tel;

	public TelCheck(String tel) {
		super();
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public boolean check() {

		if(tel.length()!=13) {

			JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ �˸��� �ʽ��ϴ�"
					+"'������(-)'�� ������ 13�ڸ��� �ۼ����ּ���");
			return true;
			}
		else if(!(tel.substring(3,4).equals("-")&tel.substring(8,9).equals("-"))) {

			JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ �˸��� �ʽ��ϴ�"
					+"'������(-)'�� ������ 13�ڸ��� �ۼ����ּ���");
			return true;
		}
		
		try{
			Integer.parseInt(tel.substring(0,3));
			Integer.parseInt(tel.substring(4,8));
			Integer.parseInt(tel.substring(9,13));
		}catch(IllegalArgumentException e){

			JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ �˸��� �ʽ��ϴ�"
					+"'������(-)'�� ������ 13�ڸ��� �ۼ����ּ���");
			return true;
		}
	
		return false;
	}
}
