package findAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import openDoorDAO.FindAccountDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FindID extends JFrame {

	private JPanel contentPane;
	private JTextField inputNameTxt;
	private JTextField inputTelTxt;
	private JLabel findNameLb;
	private JLabel findTelLb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindID frame = new FindID();
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
	public FindID() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ���̵� �Է� Label
		findNameLb = new JLabel("\uC774\uB984 \uC785\uB825");
		findNameLb.setFont(new Font("����", Font.BOLD, 15));
		findNameLb.setBounds(207, 140, 167, 25);
		contentPane.add(findNameLb);
		
		// ���̵� �Է� txtfield
		inputNameTxt = new JTextField();
		inputNameTxt.setFont(new Font("����", Font.ITALIC, 13));
		inputNameTxt.setBounds(207, 172, 167, 37);
		contentPane.add(inputNameTxt);
		inputNameTxt.setColumns(10);
		
		// ��ȭ��ȣ �Է� Label
		findTelLb = new JLabel("\uC804\uD654\uBC88\uD638 \uC785\uB825");
		findTelLb.setFont(new Font("����", Font.BOLD, 15));
		findTelLb.setBounds(207, 219, 167, 25);
		contentPane.add(findTelLb);
		
		// ��ȭ��ȣ �Է� txtfield
		inputTelTxt = new JTextField();
		inputTelTxt.setFont(new Font("����", Font.ITALIC, 13));
		inputTelTxt.setBounds(207, 247, 167, 37);
		contentPane.add(inputTelTxt);
		inputTelTxt.setColumns(10);
		
		// ���̵� ã�� Btn
		JButton findIDBtn = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		findIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = inputNameTxt.getText();
				String inputTel = inputTelTxt.getText();
				if(inputName.trim().isEmpty()||inputName==null|| // ��ĭ�� �Էµ��� ��츦 ����
						inputTel.trim().isEmpty()||inputTel==null) {
					JOptionPane.showMessageDialog(null, "��ĭ�� Ȯ���ϼ���.");
				}
				else { // ��ĭ�� �Էµ��� �ʾ��� ��
					try {
						FindAccountDAO findDao = new FindAccountDAO();
						String id = findDao.getId(inputName, inputTel);
						if(id==null) { // �̸�, ��ȭ��ȣ�� ��ġ�ϴ� ȸ���� ���� ���
							JOptionPane.showMessageDialog(null, "�̸��� ��ȭ��ȣ�� �ٽ� Ȯ���ϼ���.");
						}else { // �� �� ��ġ�ϴ� ȸ���� �ִ� ��� --> ������ �̵�
							setVisible(false);
							new AfterFindID(id).setVisible(true);
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		findIDBtn.setFont(new Font("����", Font.BOLD, 15));
		findIDBtn.setBounds(390, 172, 126, 112);
		contentPane.add(findIDBtn);
		
		// �������� �ǵ��ư���(���) Btn---------------------------
		JButton cancleBtn = new JButton("\uCDE8\uC18C");
		cancleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		cancleBtn.setFont(new Font("����", Font.BOLD, 15));
		cancleBtn.setBounds(285, 345, 167, 45);
		contentPane.add(cancleBtn);
		// --------------------------- ��� Btn-end
		
	}
}
