package loginPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import selectMemberPage.ClientSelect;
import updateAcconutPage.ClientUpdate;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLogin frame = new ClientLogin(null, null);
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
	public ClientLogin(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ȯ�� �ȳ� Label
		JLabel wellcomeLb = new JLabel(id+"�� ȯ���մϴ٢�");
		wellcomeLb.setFont(new Font("����", Font.BOLD, 20));
		wellcomeLb.setBounds(217, 83, 393, 50);
		contentPane.add(wellcomeLb);
		
		// Client ��ȸ Btn
		JButton CSearchBtn = new JButton("\uC870\uD68C");
		CSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientSelect(id, pw).setVisible(true);
			}
		});
		CSearchBtn.setFont(new Font("����", Font.BOLD, 20));
		CSearchBtn.setBounds(133, 211, 100, 50);
		contentPane.add(CSearchBtn);
		
		// Client ���� Btn
		JButton cUpdateBtn = new JButton("\uAC1C\uC778\uC815\uBCF4 \uC218\uC815");
		cUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientUpdate(id,pw).setVisible(true);
			}
		});
		cUpdateBtn.setFont(new Font("����", Font.BOLD, 15));
		cUpdateBtn.setBounds(329, 211, 149, 50);
		contentPane.add(cUpdateBtn);
		
		// Client ���� Btn
		JButton cDeleteBtn = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		cDeleteBtn.setFont(new Font("����", Font.BOLD, 15));
		cDeleteBtn.setBounds(584, 211, 100, 50);
		contentPane.add(cDeleteBtn);
		
		// Logout Btn --> Main �̵� -----------------------------------
		JButton cLogoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		cLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		cLogoutBtn.setFont(new Font("����", Font.BOLD, 15));
		cLogoutBtn.setBounds(329, 349, 149, 48);
		contentPane.add(cLogoutBtn);
		//-----------------------------------log-out Btn-end
		
	}
}
