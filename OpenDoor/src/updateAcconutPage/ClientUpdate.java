package updateAcconutPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import openDoorDAO.UpdateAccountDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClientUpdate extends JFrame {

	private JPanel a111;
	private JTextField pw;
	private JTextField pwconfirm;
	private JTextField job;
	private JTextField prop;
	private JTextField tel;
	private JTextField pwq;
	private JTextField pwa;
	private JTextField pwaconfirm;
	private JTextField pwTex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUpdate frame = new ClientUpdate(null,null);
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
	public ClientUpdate(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		a111 = new JPanel();
		a111.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(a111);
		a111.setLayout(null);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBounds(12, 27, 80, 37);
		a111.add(idLabel);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(12, 205, 80, 37);
		a111.add(nameLabel);
		
		JLabel genderbel = new JLabel("\uC131\uBCC4");
		genderbel.setHorizontalAlignment(SwingConstants.CENTER);
		genderbel.setBounds(12, 279, 80, 37);
		a111.add(genderbel);
		
		JLabel rrnLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638 \uC55E\uC790\uB9AC");
		rrnLabel.setBounds(12, 391, 127, 37);
		a111.add(rrnLabel);
		
		pwconfirm = new JTextField();
		pwconfirm.setColumns(10);
		pwconfirm.setBounds(12, 134, 143, 37);
		a111.add(pwconfirm);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(315, 27, 189, 37);
		a111.add(job);
		
		prop = new JTextField();
		prop.setColumns(10);
		prop.setBounds(315, 87, 189, 37);
		a111.add(prop);
		
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(315, 148, 189, 37);
		a111.add(tel);
		
		pwq = new JTextField();
		pwq.setColumns(10);
		pwq.setBounds(315, 266, 189, 37);
		a111.add(pwq);
		
		pwa = new JTextField();
		pwa.setColumns(10);
		pwa.setBounds(315, 328, 189, 37);
		a111.add(pwa);
		
		pwaconfirm = new JTextField();
		pwaconfirm.setColumns(10);
		pwaconfirm.setBounds(315, 391, 189, 37);
		a111.add(pwaconfirm);
		
		JLabel jobbelLabel = new JLabel("\uC9C1\uC5C5");
		jobbelLabel.setBounds(516, 27, 80, 37);
		a111.add(jobbelLabel);
		
		JLabel propbelLabel = new JLabel("\uC7AC\uC0B0");
		propbelLabel.setBounds(516, 85, 80, 37);
		a111.add(propbelLabel);
		
		JLabel telbelLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telbelLabel.setBounds(516, 148, 80, 37);
		a111.add(telbelLabel);
		
		JLabel pwqbelLAbel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30 \uC9C8\uBB38");
		pwqbelLAbel.setBounds(516, 266, 116, 37);
		a111.add(pwqbelLAbel);
		
		JLabel pwableLAbel = new JLabel("\uC9C8\uBB38 \uB2F5");
		pwableLAbel.setBounds(516, 328, 80, 37);
		a111.add(pwableLAbel);
		
		JLabel pwaconfirmbelLAbel = new JLabel("\uC9C8\uBB38\uB2F5 \uC7AC\uD655\uC778");
		pwaconfirmbelLAbel.setBounds(516, 391, 80, 37);
		a111.add(pwaconfirmbelLAbel);
		
		JButton ok = new JButton("\uD68C\uC6D0\uC815\uBCF4\uBCC0\uACBD");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pw1 = pwTex.getText();
				String pwconfirm1 = pwconfirm.getText();
				String job1 = job.getText();
				String propTxt = prop.getText();
				int prop1 = Integer.parseInt(prop.getText());
				String tel1 = tel.getText();
				String pwq1 = pwq.getText();
				String pwa1 = pwa.getText();
				String pwaconfirm1 = pwaconfirm.getText();
			
				
				if(!(pw1.equals(pwconfirm1))){
					JOptionPane.showMessageDialog
					(null,"'비밀번호'와 '비밀번호 확인'이 일치하지 않습니다"
							+"\n다시 확인해주세요");
				}else if(!(pwa1.equals(pwaconfirm1))) {
					JOptionPane.showMessageDialog
					(null,"'비밀번호 질문 답'과 '비밀번호 질문 답'이 일치하지 않습니다"
							+"\n다시 확인해주세요");

				}else if(pw1.trim().isEmpty() || pwconfirm1.trim().isEmpty() || job1.trim().isEmpty()
						|| propTxt.trim().isEmpty() || tel1.trim().isEmpty()
						|| pwq1.trim().isEmpty() || pwa1.trim().isEmpty() || pwaconfirm1.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"빈칸확인 후 입력해주세요");
				}else {
					try {
						UpdateAccountDAO memDAO = new UpdateAccountDAO();
						boolean mem1 = memDAO.update_gogek
								(pw1, pwconfirm1, job1, prop1, tel1, pwq1, pwa1, pwaconfirm1); 
						setVisible(false);
						new AfterClientUpdate().setVisible(true);
					
					} catch (ClassNotFoundException | SQLException e1) {
					
						e1.printStackTrace();
					}
				}
				}
			});
		ok.setBounds(112, 474, 151, 57);
		a111.add(ok);
		
		JButton end = new JButton("\uCDE8\uC18C");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new Exc().setVisible(true);	
			}
		});
		end.setBounds(334, 474, 151, 57);
		a111.add(end);
		
		JLabel pwbel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwbel.setBounds(165, 74, 80, 37);
		a111.add(pwbel);
		
		JLabel pwqabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwqabel.setBounds(167, 134, 80, 37);
		a111.add(pwqabel);
		
		pwTex = new JTextField();
		pwTex.setBounds(12, 74, 143, 37);
		a111.add(pwTex);
		pwTex.setColumns(10);
	}

}
