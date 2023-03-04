package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import createAccountPage.CreateAccountPage;
import findAccountPage.FindID;
import findAccountPage.FindPW;
import loginPage.AdminLogin;
import loginPage.ClientLogin;
import openDoorDAO.CheckAccountDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField idTxt;
	// private JTextField pwTxt;
	private JPasswordField pwTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ����Ʈ ���� Label
		JLabel siteLb = new JLabel("\u25C8Open Door\u25C8");
		siteLb.setFont(new Font("����", Font.BOLD, 30));
		siteLb.setBounds(205, 49, 231, 49);
		contentPane.add(siteLb);
		
		// ���̵� �Է¶�
		idTxt = new JTextField();
		idTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idTxt.setText(null);
			}
		});
		idTxt.setFont(new Font("����", Font.ITALIC, 15));
		idTxt.setText("\uC544\uC774\uB514");
		idTxt.setBounds(176, 168, 203, 49);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		// �н����� �Է¶�
		// pwTxt = new JTextField();
		pwTxt = new JPasswordField(); // ��� �Է� * ǥ�ø� ���� PasswordField�� ����
		pwTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pwTxt.setText(null);
			}
		});
		pwTxt.setFont(new Font("����", Font.ITALIC, 15));
		pwTxt.setText("\uBE44\uBC00\uBC88\uD638");
		pwTxt.setBounds(176, 227, 203, 49);
		contentPane.add(pwTxt);
		pwTxt.setColumns(10);
		pwTxt.setEchoChar('*');
		
		// �α��� ��ư
		JButton loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTxt.getText();
				String pw = pwTxt.getText();
				if(id.trim().isEmpty()||id==null|| // ����ִ� ���� �ִٸ�
						pw.trim().isEmpty()||pw==null) {
					JOptionPane.showMessageDialog(null, "��ĭ�� �Է��ϼ���");
				}else if(id.equals("���̵�")||pw.equals("��й�ȣ")) { // txtfield�� �⺻ txt�� ���� ���
					JOptionPane.showMessageDialog(null, "���̵�� ��� ��� �Է��ϼ���.");
				}else if(id.equals("admin")&&pw.equals("admin")){
					setVisible(false);
					new AdminLogin(id, pw).setVisible(true);
				}else { // ȸ�� ���̵� ã��
					try {
						CheckAccountDAO checkDao = new CheckAccountDAO();
						boolean check = checkDao.memberCheck(id, pw);
						if(check) {
							setVisible(false);
							new ClientLogin(id, pw).setVisible(true);;
						}else {
							JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���̵�� ����� �����ϴ�.");
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		loginBtn.setFont(new Font("����", Font.BOLD, 18));
		loginBtn.setBounds(391, 168, 91, 108);
		contentPane.add(loginBtn);
		
		// ���̵� ã�� ��ư
		JButton findIDBtn = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		findIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FindID().setVisible(true);
			}
		});
		findIDBtn.setFont(new Font("����", Font.BOLD, 11));
		findIDBtn.setBounds(176, 296, 100, 38);
		contentPane.add(findIDBtn);
		
		// �н����� ã�� ��ư
		JButton findPWBtn = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		findPWBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FindPW().setVisible(true);
			}
		});
		findPWBtn.setFont(new Font("����", Font.BOLD, 10));
		findPWBtn.setBounds(279, 296, 100, 38);
		contentPane.add(findPWBtn);
		
		// ȸ������ ��ư
		JButton createAcntBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		createAcntBtn.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					new CreateAccountPage().setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		createAcntBtn.setFont(new Font("����", Font.BOLD, 13));
		createAcntBtn.setBounds(391, 295, 91, 38);
		contentPane.add(createAcntBtn);
		
		// ���� ��ư
		JButton extiBtn = new JButton("\uD504\uB85C\uADF8\uB7A8 \uC885\uB8CC");
		extiBtn.addActionListener(new ActionListener() { // ���� ��ư Ŭ���� ���α׷� ���� �̺�Ʈ
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		extiBtn.setFont(new Font("����", Font.BOLD, 15));
		extiBtn.setBounds(205, 421, 231, 38);
		contentPane.add(extiBtn);
		
	}
}
