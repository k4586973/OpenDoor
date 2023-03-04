package selectMemberPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.AdminLogin;
import openDoorDAO.SelectMemberDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminSelect extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSelect frame = new AdminSelect(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminSelect(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ȸ�� �˻� �� 
		JLabel readLabel = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9");
		readLabel.setFont(new Font("����", Font.BOLD, 25));
		readLabel.setBounds(189, 72, 151, 98);
		contentPane.add(readLabel);
		
		// ���� �˻� Label
		JLabel aSearchLb = new JLabel("<\uAC1C\uBCC4 \uC870\uD68C>");
		aSearchLb.setFont(new Font("����", Font.BOLD, 15));
		aSearchLb.setBounds(189, 168, 91, 23);
		contentPane.add(aSearchLb);
		
		// ȸ�� �˻� comboBox
		String search[] = {"(����)","���̵�� �˻�","�̸����� �˻�","����ó�� �˻�"};
		JComboBox<String> combo;
		JComboBox readCbx = new JComboBox(search);
		readCbx.setBounds(189, 201, 151, 23);
		contentPane.add(readCbx);
		
		// ȸ�� �˻� textField
		textField = new JTextField();
		textField.setBounds(365, 202, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// ȸ�� �˻� ��ư Ŭ�� �� �̺�Ʈ 
		JButton aReadBtn = new JButton("\uAC80\uC0C9");
		aReadBtn.setFont(new Font("����", Font.BOLD, 14));
		aReadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // �˻� ��ư ���� �� Ű���� �˻�
				String selectedValue = readCbx.getSelectedItem().toString();
				String textValue = textField.getText();
				
				// 1. ���̵�� �˻�
				if(selectedValue.equals("���̵�� �˻�")) {
					// 1) �� ĭ�� ���� ���� �ʿ� �ȳ�
					// 2) ������ ���� ��쿡�� �� �������� ��ȸ ���
						if(textValue.trim().isEmpty()||textValue==null) {
							JOptionPane.showMessageDialog(null, "�Է��� �ʿ��մϴ�.");
						}
						else {// ������ ���� ��� ó��
							try {
								SelectMemberDAO selDao = new SelectMemberDAO();
								ArrayList<OpenDoorVO> memArray = selDao.getAllInfo();
								if(memArray.isEmpty()) {
									JOptionPane.showMessageDialog(null, "�ش� ���̵� �������� �ʽ��ϴ�.");
								}else {// MemberList â���� �̵�
									setVisible(false); // ���� â �� ���̰�
									new AdminMemberList(memArray, id, pw).setVisible(true);
								}
							}catch(Exception e1) {
								e1.printStackTrace();
							}
						}
				}
				// 2. �̸����� �˻�
				else if(selectedValue.equals("�̸����� �˻�")) {
					if(textValue.trim().isEmpty()||textValue==null) {
						JOptionPane.showMessageDialog(null, "�Է��� �ʿ��մϴ�.");
					}
					else {// ������ ���� ��� ó��
						try {
							SelectMemberDAO memDao = new SelectMemberDAO();
							ArrayList<OpenDoorVO> memArray = memDao.getNameInfo(textValue);
							if(memArray.isEmpty()) {
								JOptionPane.showMessageDialog(null, "�ش� �̸��� �������� �ʽ��ϴ�.");
							}else {// MemberList â���� �̵�
								setVisible(false); // ���� â �� ���̰�
								new AdminMemberList(memArray, id, pw).setVisible(true);
							}
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				// 3. ����ó�� �˻�
				else if(selectedValue.equals("����ó�� �˻�")) {
					if(textValue.trim().isEmpty()||textValue==null) {
						JOptionPane.showMessageDialog(null, "�Է��� �ʿ��մϴ�.");
					}
					else if(textValue.length()<=11) {
						JOptionPane.showMessageDialog(null, "'000-0000-0000' �������� �Է��� �ּ���");
					}
					else {// ������ ���� ��� ó��
						try {
							SelectMemberDAO memDao = new SelectMemberDAO();
							ArrayList<OpenDoorVO> memArray = memDao.getTelInfo(textValue);
							if(memArray.isEmpty()) {
								JOptionPane.showMessageDialog(null, "�ش� ��ȭ��ȣ�� �������� �ʽ��ϴ�.");
							}else {// MemberList â���� �̵�
								setVisible(false); // ���� â �� ���̰�
								new AdminMemberList(memArray, id, pw).setVisible(true);
							}
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				// 4. (����) �ɼǿ��� ������ ���� ���
				else {
					JOptionPane.showMessageDialog(null, "�ɼ��� �������ּ���.");
				}
			}
		});
		aReadBtn.setBounds(458, 201, 91, 23);
		contentPane.add(aReadBtn);
		
		// ��ü ��ȸ ��ư Ŭ�� event
		JButton readAllButton = new JButton("\uC804\uCCB4 \uC870\uD68C");
		readAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SelectMemberDAO memDao = new SelectMemberDAO();
					ArrayList<OpenDoorVO> memArray = memDao.getAllInfo(); // ��ü ����
					setVisible(false); // ���� â �� ���̰�
					new AdminMemberList(memArray, id, pw).setVisible(true); 
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		readAllButton.setFont(new Font("����", Font.BOLD, 13));
		readAllButton.setBounds(249, 269, 91, 23);
		contentPane.add(readAllButton);
		
		// ��� ��ư 
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin(id, pw).setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("����", Font.BOLD, 13));
		cancelBtn.setBounds(365, 269, 91, 23);
		contentPane.add(cancelBtn);
		
	}
}
