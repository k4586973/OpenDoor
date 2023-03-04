package createAccountPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import openDoorDAO.CreateAccountDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import java.awt.Color;

public class CreateAccountPage extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JTextField PWTextField;
	private JTextField PWConfirmTextField;
	private JTextField NameTextField;
	private JTextField RRNTextField;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private JTextField JobTextField;
	private JTextField PropTextField;
	private JTextField TelTextField;
	private JTextField PWQTextField;
	private JTextField PWATextField;
	private JTextField PWAConfirmTextField;
	
	
	String ID;
	String PW;
	String name;
	String gender="";
	String RRNS;
	String job;
	int prop;
	String tel;
	String face=null;
	String PWQ;
	String PWA;
	String genderN;
	String propS;
	String PWConfirm;
	String PWAConfirm;
	
	Scanner sc=new Scanner(System.in);
	
	CreateAccountDAO ODD = new CreateAccountDAO();
	ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args){

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountPage frame = new CreateAccountPage();
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
	public CreateAccountPage() throws ClassNotFoundException, SQLException {
		setAutoRequestFocus(false);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDTextField = new JTextField();
		IDTextField.setForeground(Color.LIGHT_GRAY);
		IDTextField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		IDTextField.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		
		//힌트표시
		new Hint(IDTextField).hint();
		
		IDTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ID=IDTextField.getText();
			}
		});
		IDTextField.setBounds(12, 29, 137, 21);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		
		JLabel IDLabel = new JLabel("\uC544\uC774\uB514");
		IDLabel.setBounds(12, 10, 57, 15);
		contentPane.add(IDLabel);
		
		JLabel PWLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PWLabel.setBounds(12, 60, 57, 15);
		contentPane.add(PWLabel);
		
		PWTextField = new JTextField();
		PWTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PW=PWTextField.getText();
			}
		});
		new Hint(PWTextField).hint();
		PWTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWTextField.setForeground(Color.LIGHT_GRAY);
		PWTextField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWTextField.setBounds(12, 85, 159, 21);
		contentPane.add(PWTextField);
		PWTextField.setColumns(10);
		
		JLabel PWConfirmLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		PWConfirmLabel.setBounds(12, 116, 97, 15);
		contentPane.add(PWConfirmLabel);
		
		PWConfirmTextField = new JTextField();
		PWConfirmTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				PWConfirm=PWConfirmTextField.getText();
			}
		});
		new Hint(PWConfirmTextField).hint();
		PWConfirmTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWConfirmTextField.setForeground(Color.LIGHT_GRAY);
		PWConfirmTextField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWConfirmTextField.setBounds(12, 141, 159, 21);
		contentPane.add(PWConfirmTextField);
		PWConfirmTextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("\uC774\uB984");
		NameLabel.setBounds(12, 172, 57, 15);
		contentPane.add(NameLabel);
		
		NameTextField = new JTextField();
		NameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				name=NameTextField.getText();
			}
		});
		new Hint(NameTextField).hint();
		NameTextField.setToolTipText("\uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NameTextField.setForeground(Color.LIGHT_GRAY);
		NameTextField.setText("\uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NameTextField.setBounds(12, 197, 137, 21);
		contentPane.add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel GenderLabel = new JLabel("\uC131\uBCC4");
		GenderLabel.setBounds(12, 228, 57, 15);
		contentPane.add(GenderLabel);
		
		JLabel RRNLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C(8\uC790\uB9AC\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		RRNLabel.setBounds(12, 284, 188, 15);
		contentPane.add(RRNLabel);
		
		RRNTextField = new JTextField();
		RRNTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				RRNS=RRNTextField.getText();
			}
		});
		new Hint(RRNTextField).hint();
		RRNTextField.setToolTipText("\uC608\uC2DC : 19990101");
		RRNTextField.setForeground(Color.LIGHT_GRAY);
		RRNTextField.setText("\uC608\uC2DC : 19990101");
		RRNTextField.setBounds(12, 309, 116, 21);
		contentPane.add(RRNTextField);
		RRNTextField.setColumns(10);
		
		JRadioButton MaleRadioButton = new JRadioButton("\uB0A8");
		MaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MaleRadioButton.isSelected()) {
					gender="남";
				}
			}
		});

		buttonGroupGender.add(MaleRadioButton);
		MaleRadioButton.setBounds(7, 249, 37, 23);
		contentPane.add(MaleRadioButton);
		
		JRadioButton FemaleRadioButton = new JRadioButton("\uC5EC");
		FemaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FemaleRadioButton.isSelected()) {
					gender="여";
				}
			}
		});
		buttonGroupGender.add(FemaleRadioButton);
		FemaleRadioButton.setBounds(48, 249, 37, 23);
		contentPane.add(FemaleRadioButton);
		
		JLabel JobLabel = new JLabel("\uC9C1\uC5C5");
		JobLabel.setBounds(330, 10, 57, 15);
		contentPane.add(JobLabel);
		
		JobTextField = new JTextField();
		JobTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				job=JobTextField.getText();
			}
		});
		new Hint(JobTextField).hint();
		JobTextField.setToolTipText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setForeground(Color.LIGHT_GRAY);
		JobTextField.setText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setBounds(330, 29, 137, 21);
		contentPane.add(JobTextField);
		JobTextField.setColumns(10);
		
		JLabel PropLabel = new JLabel("\uC7AC\uC0B0");
		PropLabel.setBounds(330, 60, 57, 15);
		contentPane.add(PropLabel);
		
		PropTextField = new JTextField();
		PropTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				propS=PropTextField.getText();
			}
		});
		new Hint(PropTextField).hint();
		PropTextField.setToolTipText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setForeground(Color.LIGHT_GRAY);
		PropTextField.setText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setBounds(330, 85, 137, 21);
		contentPane.add(PropTextField);
		PropTextField.setColumns(10);
		
		JLabel TelLabel = new JLabel("\uC804\uD654\uBC88\uD638('\uD558\uC774\uD508(-)'\uC744 \uD3EC\uD568\uD55C 13\uC790\uB9AC\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		TelLabel.setBounds(330, 116, 329, 15);
		contentPane.add(TelLabel);
		
		TelTextField = new JTextField();
		TelTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tel=TelTextField.getText();
			}
		});
		new Hint(TelTextField).hint();
		TelTextField.setToolTipText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setForeground(Color.LIGHT_GRAY);
		TelTextField.setText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setBounds(330, 141, 137, 21);
		contentPane.add(TelTextField);
		TelTextField.setColumns(10);
		
		JLabel PWQLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC \uC9C8\uBB38");
		PWQLabel.setBounds(330, 228, 137, 15);
		contentPane.add(PWQLabel);
		
		PWQTextField = new JTextField();
		PWQTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWQ=PWQTextField.getText();
			}
		});
		new Hint(PWQTextField).hint();
		PWQTextField.setToolTipText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setForeground(Color.LIGHT_GRAY);
		PWQTextField.setText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setBounds(330, 250, 292, 21);
		contentPane.add(PWQTextField);
		PWQTextField.setColumns(10);
		
		JLabel PWALabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5");
		PWALabel.setBounds(330, 284, 180, 15);
		contentPane.add(PWALabel);
		
		PWATextField = new JTextField();
		PWATextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWA=PWATextField.getText();
			}
		});
		new Hint(PWATextField).hint();
		PWATextField.setToolTipText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setForeground(Color.LIGHT_GRAY);
		PWATextField.setText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setBounds(330, 309, 292, 21);
		contentPane.add(PWATextField);
		PWATextField.setColumns(10);
		
		JLabel PWAConfirmLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5 \uD655\uC778");
		PWAConfirmLabel.setBounds(330, 340, 205, 15);
		contentPane.add(PWAConfirmLabel);
		
		PWAConfirmTextField = new JTextField();
		PWAConfirmTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWAConfirm=PWAConfirmTextField.getText();
			}
		});
		new Hint(PWAConfirmTextField).hint();
		PWAConfirmTextField.setToolTipText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setForeground(Color.LIGHT_GRAY);
		PWAConfirmTextField.setText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setBounds(330, 365, 292, 21);
		contentPane.add(PWAConfirmTextField);
		PWAConfirmTextField.setColumns(10);
		
		JButton createAccountBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		createAccountBtn.addMouseListener(new MouseAdapter() {
			ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
			public void mouseClicked(MouseEvent e) {
				
				if(PW==null||PWConfirm==null||PWA==null||PWAConfirm==null) {
					JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다"
							+"\n다시 확인해주세요");
					return;
				}
				else if(!(PW.equals(PWConfirm))) {
					JOptionPane.showMessageDialog(null, "'비밀번호'와 '비밀번호 확인'이 일치하지 않습니다"
							+"\n다시 확인해주세요");
					return;
				}else if(!(PWA.equals(PWAConfirm))) {
					JOptionPane.showMessageDialog(null, "'비밀번호 분실 질문에 대한 답'과\n'비밀번호 분실 질문에 대한 답 확인'이 일치하지 않습니다"
							+"\n다시 확인해주세요");
					return;
				}
				
				//id입력
				if(new IDCheck(ID,memberlist).check()
						||new PWCheck(PW).check()
						||new LengthCheck(name).check()
						||new LengthCheck(job).check()
						||new LengthCheck(PWA).check()
						||new LengthCheck(PWQ).check()
						||new GenderCheck(gender).check()
						||new RrnCheck(RRNS).check()
						||new PropCheck(propS).check()
						||new TelCheck(tel).check()) {
					return;
					
				}

				//회원등록
				boolean createAccount = ODD.insert(ID,PW,name,gender,RRNS,job,propS,tel,face,PWQ,PWA);
				
				if(createAccount) {
					String id = IDTextField.getText();
					String pw = PWTextField.getText();
					JOptionPane.showMessageDialog(null, "회원가입 성공");
					setVisible(false);
					new AfterCreateAccount(id, pw).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "회원가입 실패");
				}
			}
		});
		createAccountBtn.setBounds(183, 487, 97, 23);
		contentPane.add(createAccountBtn);
		
		JButton cancelButton = new JButton("\uCDE8\uC18C");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		cancelButton.setBounds(413, 487, 97, 23);
		contentPane.add(cancelButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
