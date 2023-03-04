package loginPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import selectMemberPage.AdminSelect;
import updateAcconutPage.AdminUpdate;
import updateAcconutPage.ClientUpdate;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin(null, null);
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
	public AdminLogin(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ������ ������ �ȳ� Label
		JLabel infoLb = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0\uC785\uB2C8\uB2E4.");
		infoLb.setFont(new Font("����", Font.BOLD, 20));
		infoLb.setBounds(291, 64, 202, 56);
		contentPane.add(infoLb);
		
		// ȸ�� ���� ��ȸ Btn
		JButton aReadBtn = new JButton("\uD68C\uC6D0\uC870\uD68C");
		aReadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminSelect(id, pw).setVisible(true);
			}
		});
		aReadBtn.setFont(new Font("����", Font.BOLD, 15));
		aReadBtn.setBounds(112, 223, 119, 44);
		contentPane.add(aReadBtn);
		
		// ȸ�� ���� ���� Btn
		JButton aUpdateBtn = new JButton("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		aUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new AdminUpdate().setVisible(true);
			}
		});
		aUpdateBtn.setFont(new Font("����", Font.BOLD, 15));
		aUpdateBtn.setBounds(308, 223, 152, 44);
		contentPane.add(aUpdateBtn);
		
		// ȸ�� ���� ���� Btn
		JButton aDeleteBtn = new JButton("\uD68C\uC6D0 \uAC15\uD1F4");
		aDeleteBtn.setFont(new Font("����", Font.BOLD, 15));
		aDeleteBtn.setBounds(528, 223, 119, 44);
		contentPane.add(aDeleteBtn);
		
		// �α׾ƿ� Btn-----------------------------------------------
		JButton aLogoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		aLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		aLogoutBtn.setFont(new Font("����", Font.BOLD, 15));
		aLogoutBtn.setBounds(308, 340, 152, 44);
		contentPane.add(aLogoutBtn);
		//-----------------------------------------------�α׾ƿ�Btn-end
		
	}
}
