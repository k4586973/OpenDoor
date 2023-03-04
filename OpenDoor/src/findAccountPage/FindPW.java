package findAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import openDoorDAO.FindAccountDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FindPW extends JFrame {

	private JPanel contentPane;
	private JTextField inputIDTxt;
	private JTextField pwaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPW frame = new FindPW();
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
	public FindPW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ���̵� �Է� Label
		JLabel inputIDLb = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		inputIDLb.setFont(new Font("����", Font.BOLD, 15));
		inputIDLb.setBounds(179, 69, 178, 28);
		contentPane.add(inputIDLb);
		
		// ���̵� ��ȸ ��) ��� �н� ����(pwq) ǥ��
		JLabel pwqLb = new JLabel("(\uD574\uB2F9 \uC544\uC774\uB514\uB97C \uC870\uD68C\uD558\uC2DC\uBA74 \uC9C8\uBB38\uC774 \uD45C\uC2DC\uB429\uB2C8\uB2E4.)");
		pwqLb.setFont(new Font("����", Font.ITALIC, 15));
		pwqLb.setBounds(110, 194, 574, 41);
		contentPane.add(pwqLb);
		
		// ���̵� �Է��ϴ� txtfield
		inputIDTxt = new JTextField();
		inputIDTxt.setFont(new Font("����", Font.ITALIC, 14));
		inputIDTxt.setBounds(179, 107, 300, 41);
		contentPane.add(inputIDTxt);
		inputIDTxt.setColumns(10);
		
		// ���̵� ��ȸ Btn
		JButton findBtn = new JButton("\uAC80\uC0C9");
		findBtn.setFont(new Font("����", Font.BOLD, 15));
		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findId = inputIDTxt.getText();
				if(findId.trim().isEmpty()||findId==null) { // �� ĭ�̶��
					JOptionPane.showMessageDialog(null, "���̵� �Է��� �ּ���.");
				}else { // ���̵� �Է��� �ߴٸ�
					try {
						FindAccountDAO findDao = new FindAccountDAO();
						ArrayList<OpenDoorVO> memArray = findDao.getIdInfo(findId);
						if(memArray.isEmpty()) { // ��ġ�ϴ� ���̵� ���� ��
							JOptionPane.showMessageDialog(null, "�ش� ���̵� �������� �ʽ��ϴ�.");
						}else {// ��ġ�ϴ� ���̵� ���� ��
							String pwq = memArray.get(0).getPwq();
							pwqLb.setText(pwq);
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		findBtn.setBounds(475, 107, 91, 41);
		contentPane.add(findBtn);
		
		// pwa �� 
		JLabel pwaLb = new JLabel("\uC9C8\uBB38\uC774 \uD45C\uC2DC\uB418\uBA74 \uC544\uB798\uC758 \uCE78\uC5D0 \uB2F5\uC744 \uC791\uC131\uD574 \uC8FC\uC138\uC694.");
		pwaLb.setFont(new Font("����", Font.BOLD, 15));
		pwaLb.setBounds(179, 234, 351, 41);
		contentPane.add(pwaLb);
		
		// pwq ���� �Է��ϴ� txtfield
		pwaTxt = new JTextField();
		pwaTxt.setFont(new Font("����", Font.ITALIC, 15));
		pwaTxt.setBounds(179, 285, 390, 41);
		contentPane.add(pwaTxt);
		pwaTxt.setColumns(10);
		
		// ��й�ȣ �˻� Btn
		JButton findPWBtn = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		findPWBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findId = inputIDTxt.getText();
				String inputPwa = pwaTxt.getText();
				if(findId.trim().isEmpty()||findId==null // �� ĭ�̶��
						||inputPwa.trim().isEmpty()||inputPwa==null) { 
					JOptionPane.showMessageDialog(null, "��ĭ�� Ȯ���� �ּ���.");
				}else { // ���̵� �Է��� �ߴٸ�
					try { 
						FindAccountDAO findDao = new FindAccountDAO();
						String pwa = findDao.getPwa(findId);
						if(pwa.equals(inputPwa)) { // ���̵�� ��ȸ�� ��� �Է��� ���� ������
							setVisible(false); // --> ���� �������� �̵�
							new AfterFindPW(findId).setVisible(true);
						}else{ // ���� ���� �ʴٸ�
							JOptionPane.showMessageDialog(null, "���� ��ġ���� �ʽ��ϴ�.");
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		findPWBtn.setFont(new Font("����", Font.BOLD, 15));
		findPWBtn.setBounds(272, 353, 215, 41);
		contentPane.add(findPWBtn);
		
		// ��� Btn -> Main �̵�---------------------------------
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("����", Font.BOLD, 17));
		cancelBtn.setBounds(272, 423, 215, 41);
		contentPane.add(cancelBtn);
		//---------------------------------���Btn-end
		
		
	}
}
