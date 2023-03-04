package findAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.ClientLogin;
import main.Main;
import openDoorDAO.FindAccountDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AfterFindPW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterFindPW frame = new AfterFindPW(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AfterFindPW(String id) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FindAccountDAO findDao = new FindAccountDAO();
		String pw = findDao.getPw(id);
		String hidePw = pw.replaceAll("(?<=.{2}).", "*");
		
		// ã�� ���̵�, ��� �ȳ� Label
		JLabel infoLb = new JLabel(id+"���� ��й�ȣ��"+
		hidePw+"�Դϴ�.");
		infoLb.setFont(new Font("����", Font.ITALIC, 20));
		infoLb.setBounds(101, 102, 542, 45);
		contentPane.add(infoLb);
		
		// �ٷ� �α����ϱ� Btn
		JButton directLgnBtn = new JButton("\uBC14\uB85C \uB85C\uADF8\uC778\uD558\uAE30");
		directLgnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientLogin(id, pw).setVisible(true);
			}
		});
		directLgnBtn.setFont(new Font("����", Font.BOLD, 20));
		directLgnBtn.setBounds(253, 204, 254, 45);
		contentPane.add(directLgnBtn);
		
		// �������� �̵��ϱ� Btn
		JButton lgnPgBtn = new JButton("\uBA54\uC778 \uD398\uC774\uC9C0");
		lgnPgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		lgnPgBtn.setFont(new Font("����", Font.BOLD, 15));
		lgnPgBtn.setBounds(316, 327, 128, 45);
		contentPane.add(lgnPgBtn);
		
	}
}
