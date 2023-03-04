package createAccountPage;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import openDoorVo.OpenDoorVO;

public class IDCheck {

	private String id;
	
	private ArrayList<OpenDoorVO> memberlist;

	public IDCheck(String id, ArrayList<OpenDoorVO> memberlist) {
		super();
		this.id = id;
		this.memberlist = memberlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<OpenDoorVO> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(ArrayList<OpenDoorVO> memberlist) {
		this.memberlist = memberlist;
	}

	public boolean check() {

		if(id==null||id.length()==0) {
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
			return true;
		}else if(!(id.equals(id.replace(" ", "")))) {
			JOptionPane.showMessageDialog(null, "������ ���̵� ��� �Ұ����մϴ�"
					+"\n�ٽ� �Է����ּ���");
			return true;
		}else if(id.length()>32){
			JOptionPane.showMessageDialog(null, "���̵�� �ִ� 32�� ���� �����մϴ�"
				+"\n�ٽ� �Է����ּ���");
			return true;
		}else {
			for(OpenDoorVO ODV : memberlist) {
			if(id.equals(ODV.getId())) {

				JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�"
						+"\n�ٽ� �Է����ּ���");
				return true;
			}
		}}
			
		return false;						
	}

}
	


