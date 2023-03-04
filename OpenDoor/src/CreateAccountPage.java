package createAccountPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

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
	int PWSwitch=0; 
	
	JLabel IDCheckLabel = new JLabel("");
	JLabel PWCheckLabel = new JLabel("");
	JLabel PWCCheckLabel = new JLabel("");
	JLabel NameCheckLabel = new JLabel("");
	JLabel RRNCheckLabel = new JLabel("");
	JLabel jobCheckLabel = new JLabel("");
	JLabel propCheckLabel = new JLabel("");
	JLabel telCheckLabel = new JLabel("");
	JLabel telCheckLabel2 = new JLabel("");
	JLabel PWQCheckLabel = new JLabel("");
	JLabel PWACheckLabel = new JLabel("");
	JLabel PWACCheckLabel = new JLabel("");
	
	Scanner sc=new Scanner(System.in);
	
	CreateAccountDAO ODD = new CreateAccountDAO();
	ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
	private JPasswordField PWPasswordField;
	private JPasswordField PWCPasswordField;
	

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
		setBounds(100, 100, 1051, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDTextField = new JTextField();
		IDTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				ID=IDTextField.getText();

				switch(new IDCheck(ID,memberlist).checkInt()) {
				case 1: IDCheckLabel.setText("���̵� �Է����ּ���");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 2: IDCheckLabel.setText("������ ���̵� ��� �Ұ����մϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 3: IDCheckLabel.setText("���̵�� �ִ� 32�� ���� �����մϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 4: IDCheckLabel.setText("�ߺ��� ���̵� �Դϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 0: IDCheckLabel.setText("��� ������ ���̵� �Դϴ�");
				IDCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
			}
		});
		IDTextField.setForeground(Color.LIGHT_GRAY);
		IDTextField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		IDTextField.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		
		//��Ʈǥ��
		new Hint(IDTextField).hint();
		
		IDTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ID=IDTextField.getText();

				switch(new IDCheck(ID,memberlist).checkInt()) {
				case 1: IDCheckLabel.setText("���̵� �Է����ּ���");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 2: IDCheckLabel.setText("������ ���̵� ��� �Ұ����մϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 3: IDCheckLabel.setText("���̵�� �ִ� 32�� ���� �����մϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 4: IDCheckLabel.setText("�ߺ��� ���̵� �Դϴ�");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 0: IDCheckLabel.setText("��� ������ ���̵� �Դϴ�");
				IDCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
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
		
		PWTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=1;
			}

			@Override
			public void focusLost(FocusEvent e) {
				PW=PWTextField.getText();
				
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("��й�ȣ�� �Է����ּ���");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("������ ��й�ȣ�� ��� �Ұ����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("��й�ȣ�� �ִ� 32�� ���� �����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("��� ������ ��й�ȣ �Դϴ�");
				PWCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		PWTextField.setVisible(false);
		PWTextField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		
		PWTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PW=PWTextField.getText();
				
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("��й�ȣ�� �Է����ּ���");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("������ ��й�ȣ�� ��� �Ұ����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("��й�ȣ�� �ִ� 32�� ���� �����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("��� ������ ��й�ȣ �Դϴ�");
				PWCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
				
			}
		});

		
		new Hint(PWTextField).hint();
		PWTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWTextField.setForeground(Color.LIGHT_GRAY);
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
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
				
			}
		});
		PWConfirmTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=2;
			}

			@Override
			public void focusLost(FocusEvent e) {
				PWConfirm=PWConfirmTextField.getText();
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		PWConfirmTextField.setVisible(false);
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
		NameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				name=NameTextField.getText();
				switch(new LengthCheck(name).checkInt()) {
				case 1: NameCheckLabel.setText("�̸��� �Է����ּ���");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 2: NameCheckLabel.setText("�̸��� �ִ� 32�� ���� �����մϴ�");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 0: NameCheckLabel.setText("üũ �Ϸ�");
				NameCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
			}
		});
		NameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				name=NameTextField.getText();
				switch(new LengthCheck(name).checkInt()) {
				case 1: NameCheckLabel.setText("�̸��� �Է����ּ���");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 2: NameCheckLabel.setText("�̸��� �ִ� 32�� ���� �����մϴ�");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 0: NameCheckLabel.setText("üũ �Ϸ�");
				NameCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
				
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
		RRNTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				RRNS=RRNTextField.getText();
				switch(new RrnCheck(RRNS).checkInt()) {
				case 1: RRNCheckLabel.setText("��������� 8�ڸ��� �ƴմϴ�");
				RRNCheckLabel.setForeground(Color.red);
					break;
				case 2: RRNCheckLabel.setText("�߸��� ��������Դϴ�");
				RRNCheckLabel.setForeground(Color.red);
					break;

				case 0: RRNCheckLabel.setText("üũ �Ϸ�");
				RRNCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
			}
		});
		RRNTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				RRNS=RRNTextField.getText();
				switch(new RrnCheck(RRNS).checkInt()) {
				case 1: RRNCheckLabel.setText("��������� 8�ڸ��� �ƴմϴ�");
				RRNCheckLabel.setForeground(Color.red);
					break;
				case 2: RRNCheckLabel.setText("�߸��� ��������Դϴ�");
				RRNCheckLabel.setForeground(Color.red);
					break;

				case 0: RRNCheckLabel.setText("üũ �Ϸ�");
				RRNCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
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
					gender="��";
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
					gender="��";
				}
			}
		});
		buttonGroupGender.add(FemaleRadioButton);
		FemaleRadioButton.setBounds(48, 249, 37, 23);
		contentPane.add(FemaleRadioButton);
		
		JLabel JobLabel = new JLabel("\uC9C1\uC5C5");
		JobLabel.setBounds(478, 10, 57, 15);
		contentPane.add(JobLabel);
		
		JobTextField = new JTextField();
		JobTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				job=JobTextField.getText();
				switch(new LengthCheck(job).checkInt()) {
				case 1: jobCheckLabel.setText("������ �Է����ּ���");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 2: jobCheckLabel.setText("������ �ִ� 32�� ���� �����մϴ�");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 0: jobCheckLabel.setText("üũ �Ϸ�");
				jobCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
			}
		});
		JobTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				job=JobTextField.getText();
				switch(new LengthCheck(job).checkInt()) {
				case 1: jobCheckLabel.setText("������ �Է����ּ���");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 2: jobCheckLabel.setText("������ �ִ� 32�� ���� �����մϴ�");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 0: jobCheckLabel.setText("üũ �Ϸ�");
				jobCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
				
			}
		});
		new Hint(JobTextField).hint();
		JobTextField.setToolTipText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setForeground(Color.LIGHT_GRAY);
		JobTextField.setText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setBounds(478, 29, 137, 21);
		contentPane.add(JobTextField);
		JobTextField.setColumns(10);
		
		JLabel PropLabel = new JLabel("\uC7AC\uC0B0 (\uB2E8\uC704 : \uC6D0)");
		PropLabel.setBounds(478, 60, 97, 15);
		contentPane.add(PropLabel);
		
		PropTextField = new JTextField();
		PropTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				propS=PropTextField.getText().replaceAll("\\D","");
				PropTextField.setText(propS);
				switch(new PropCheck(propS).checkInt()) {
				case 1: propCheckLabel.setText("����� ���ڸ� �Է��� �����մϴ�");
				propCheckLabel.setForeground(Color.red);
					break;
				
				case 0: propCheckLabel.setText("üũ �Ϸ�");
				propCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
			}
		});
		PropTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				propS=PropTextField.getText().replaceAll("\\D","");
				PropTextField.setText(propS);
				switch(new PropCheck(propS).checkInt()) {
				case 1: propCheckLabel.setText("����� ���ڸ� �Է��� �����մϴ�");
				propCheckLabel.setForeground(Color.red);
					break;
				
				case 0: propCheckLabel.setText("üũ �Ϸ�");
				propCheckLabel.setForeground(Color.blue);
				break;
				default:
				}
			}
		});
		new Hint(PropTextField).hint();
		PropTextField.setToolTipText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setForeground(Color.LIGHT_GRAY);
		PropTextField.setText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setBounds(478, 85, 137, 21);
		contentPane.add(PropTextField);
		PropTextField.setColumns(10);
		
		JLabel TelLabel = new JLabel("\uC804\uD654\uBC88\uD638(\uC22B\uC790\uB9CC \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		TelLabel.setBounds(478, 116, 329, 15);
		contentPane.add(TelLabel);
		
		TelTextField = new JTextField();
		TelTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				tel=TelTextField.getText()
						.replaceAll("\\D", "")
						.replaceFirst("(^02.{0}|^01.{1}|^[0-9]{3})([0-9]{3,4})([0-9]{4})","$1-$2-$3");
				TelTextField.setText(tel);
				switch(new TelCheck(tel).checkInt()) {
				case 1: telCheckLabel.setText("��ȭ��ȣ ������ �˸��� �ʽ��ϴ�");
				telCheckLabel.setForeground(Color.red);
				
					break;
				
				case 0: telCheckLabel.setText("üũ �Ϸ�");
				telCheckLabel.setForeground(Color.blue);
				telCheckLabel2.setText("");
				break;
				default:
				}
			}
		});
		TelTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tel=TelTextField.getText()
						.replaceAll("\\D", "")
						.replaceFirst("(^02.{0}|^01.{1}|^[0-9]{3})([0-9]{3,4})([0-9]{4})","$1-$2-$3");
				TelTextField.setText(tel);
				switch(new TelCheck(tel).checkInt()) {
				case 1: telCheckLabel.setText("��ȭ��ȣ ������ �˸��� �ʽ��ϴ�");
				telCheckLabel.setForeground(Color.red);
				
					break;
				
				case 0: telCheckLabel.setText("üũ �Ϸ�");
				telCheckLabel.setForeground(Color.blue);
				telCheckLabel2.setText("");
				break;
				default:
				}

			}
		});
		new Hint(TelTextField).hint();
		TelTextField.setToolTipText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setForeground(Color.LIGHT_GRAY);
		TelTextField.setText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setBounds(478, 141, 137, 21);
		contentPane.add(TelTextField);
		TelTextField.setColumns(10);
		
		JLabel PWQLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC \uC9C8\uBB38");
		PWQLabel.setBounds(478, 228, 137, 15);
		contentPane.add(PWQLabel);
		
		PWQTextField = new JTextField();
		PWQTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				PWQ=PWQTextField.getText();
				switch(new LengthCheck(PWQ).checkInt()) {
				case 1: PWQCheckLabel.setText("������ �Է����ּ���");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 2: PWQCheckLabel.setText("������ �ִ� 32�� ���� �����մϴ�");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 0: PWQCheckLabel.setText("üũ �Ϸ�");
				PWQCheckLabel.setForeground(Color.blue);
				break;
				default:
				
				}
			}
		});
		PWQTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWQ=PWQTextField.getText();
				switch(new LengthCheck(PWQ).checkInt()) {
				case 1: PWQCheckLabel.setText("������ �Է����ּ���");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 2: PWQCheckLabel.setText("������ �ִ� 32�� ���� �����մϴ�");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 0: PWQCheckLabel.setText("üũ �Ϸ�");
				PWQCheckLabel.setForeground(Color.blue);
				break;
				default:
				
				}
			}
		});
		new Hint(PWQTextField).hint();
		PWQTextField.setToolTipText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setForeground(Color.LIGHT_GRAY);
		PWQTextField.setText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setBounds(478, 250, 292, 21);
		contentPane.add(PWQTextField);
		PWQTextField.setColumns(10);
		
		JLabel PWALabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5");
		PWALabel.setBounds(478, 284, 180, 15);
		contentPane.add(PWALabel);
		
		PWATextField = new JTextField();
		PWATextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				PWA=PWATextField.getText();
				switch(new LengthCheck(PWA).checkInt()) {
				case 1: PWACheckLabel.setText("���� �Է����ּ���");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 2: PWACheckLabel.setText("���� �ִ� 32�� ���� �����մϴ�");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 0: PWACheckLabel.setText("üũ �Ϸ�");
				PWACheckLabel.setForeground(Color.blue);
				break;
				default:
				}
				if(PWAConfirm.equals(PWA)&PWA!=null&PWA.length()!=0) {
					PWACCheckLabel.setText("üũ �Ϸ�");
					PWACCheckLabel.setForeground(Color.blue);}
				else {
					
				
					PWACCheckLabel.setText("���� ��ġ���� �ʽ��ϴ�");
					PWACCheckLabel.setForeground(Color.red);
					
				
				}
			}
		});
		PWATextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWA=PWATextField.getText();
				switch(new LengthCheck(PWA).checkInt()) {
				case 1: PWACheckLabel.setText("���� �Է����ּ���");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 2: PWACheckLabel.setText("���� �ִ� 32�� ���� �����մϴ�");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 0: PWACheckLabel.setText("üũ �Ϸ�");
				PWACheckLabel.setForeground(Color.blue);
				break;
				default:
				}
				if(PWAConfirm.equals(PWA)&PWA!=null&PWA.length()!=0) {
					PWACCheckLabel.setText("üũ �Ϸ�");
					PWACCheckLabel.setForeground(Color.blue);}
				else {
					
				
					PWACCheckLabel.setText("���� ��ġ���� �ʽ��ϴ�");
					PWACCheckLabel.setForeground(Color.red);
					
				
				}
			}
		});
		new Hint(PWATextField).hint();
		PWATextField.setToolTipText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setForeground(Color.LIGHT_GRAY);
		PWATextField.setText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setBounds(478, 309, 292, 21);
		contentPane.add(PWATextField);
		PWATextField.setColumns(10);
		
		JLabel PWAConfirmLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5 \uD655\uC778");
		PWAConfirmLabel.setBounds(478, 340, 205, 15);
		contentPane.add(PWAConfirmLabel);
		
		PWAConfirmTextField = new JTextField();
		PWAConfirmTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				PWAConfirm=PWAConfirmTextField.getText();
				if(PWAConfirm.equals(PWA)&PWA!=null&PWA.length()!=0) {
					PWACCheckLabel.setText("üũ �Ϸ�");
					PWACCheckLabel.setForeground(Color.blue);}
				else {
					
				
					PWACCheckLabel.setText("���� ��ġ���� �ʽ��ϴ�");
					PWACCheckLabel.setForeground(Color.red);
					
				
				}
			}
		});
		PWAConfirmTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWAConfirm=PWAConfirmTextField.getText();
				if(PWAConfirm.equals(PWA)&PWA!=null&PWA.length()!=0) {
					PWACCheckLabel.setText("üũ �Ϸ�");
					PWACCheckLabel.setForeground(Color.blue);}
				else {
					
				
					PWACCheckLabel.setText("���� ��ġ���� �ʽ��ϴ�");
					PWACCheckLabel.setForeground(Color.red);
					
				
				}
			}
		});
		new Hint(PWAConfirmTextField).hint();
		PWAConfirmTextField.setToolTipText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setForeground(Color.LIGHT_GRAY);
		PWAConfirmTextField.setText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setBounds(478, 365, 292, 21);
		contentPane.add(PWAConfirmTextField);
		PWAConfirmTextField.setColumns(10);
		
		
		JButton createAccountBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		createAccountBtn.addMouseListener(new MouseAdapter() {
			ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
			public void mouseClicked(MouseEvent e) {
				
				if(PW==null||PWConfirm==null||PWA==null||PWAConfirm==null) {
					JOptionPane.showMessageDialog(null, "�Է����� ���� ������ �ֽ��ϴ�"
							+"\n�ٽ� Ȯ�����ּ���");
					return;
				}
				else if(!(PW.equals(PWConfirm))) {
					JOptionPane.showMessageDialog(null, "'��й�ȣ'�� '��й�ȣ Ȯ��'�� ��ġ���� �ʽ��ϴ�"
							+"\n�ٽ� Ȯ�����ּ���");
					return;
				}else if(!(PWA.equals(PWAConfirm))) {
					JOptionPane.showMessageDialog(null, "'��й�ȣ �н� ������ ���� ��'��\n'��й�ȣ �н� ������ ���� �� Ȯ��'�� ��ġ���� �ʽ��ϴ�"
							+"\n�ٽ� Ȯ�����ּ���");
					return;
				}
				
				//id�Է�
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

				//ȸ�����
				boolean createAccount = ODD.insert(ID,PW,name,gender,RRNS,job,propS,tel,face,PWQ,PWA);
				
				if(createAccount) {
					String id = IDTextField.getText();
					String pw = PWTextField.getText();
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
					setVisible(false);
					new AfterCreateAccount(id, pw).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
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
		cancelButton.setBounds(478, 487, 97, 23);
		contentPane.add(cancelButton);
		
		JToggleButton PasswordToggleButton = new JToggleButton("\uBE44\uBC00\uBC88\uD638 \uD45C\uC2DC");
		PasswordToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PasswordToggleButton.isSelected()) {
					PWTextField.setForeground(Color.black);
					PWConfirmTextField.setForeground(Color.black);
					new Hint(PWTextField).hint();
					new Hint(PWConfirmTextField).hint();
					PWTextField.setVisible(true);
					PWConfirmTextField.setVisible(true);
					if(PWSwitch==1) {
						PWTextField.requestFocus();
					}else if(PWSwitch==2) {
						PWConfirmTextField.requestFocus();
					}
					PW=PWPasswordField.getText();
					PWConfirm=PWCPasswordField.getText();
					PWTextField.setText(PW);
					PWConfirmTextField.setText(PWConfirm);

					PWPasswordField.setVisible(false);
					PWCPasswordField.setVisible(false);
					
				}else if(PasswordToggleButton.isSelected()==false) {
					PWPasswordField.setForeground(Color.black);
					PWCPasswordField.setForeground(Color.black);
					new Hint(PWPasswordField).hint();
					new Hint(PWCPasswordField).hint();
					PWPasswordField.setVisible(true);
					PWCPasswordField.setVisible(true);
					if(PWSwitch==1) {
						PWPasswordField.requestFocus();
					}else if(PWSwitch==2) {
						PWCPasswordField.requestFocus();
					}
					PW=PWTextField.getText();
					PWConfirm=PWConfirmTextField.getText();
					PWPasswordField.setText(PW);
					PWCPasswordField.setText(PWConfirm);
					
					PWTextField.setVisible(false);
					PWConfirmTextField.setVisible(false);
					
				}
			}
		});
		PasswordToggleButton.setBounds(75, 56, 109, 23);
		contentPane.add(PasswordToggleButton);
		
		PWPasswordField = new JPasswordField();
		PWPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=1;
			}

			@Override
			public void focusLost(FocusEvent e) {
				PW=PWPasswordField.getText();
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("��й�ȣ�� �Է����ּ���");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("������ ��й�ȣ�� ��� �Ұ����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("��й�ȣ�� �ִ� 32�� ���� �����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("��� ������ ��й�ȣ �Դϴ�");
				PWCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		PWPasswordField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWPasswordField.setBounds(12, 85, 159, 21);
		contentPane.add(PWPasswordField);
		PWPasswordField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWPasswordField.setForeground(Color.LIGHT_GRAY);
		PWPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PW=PWPasswordField.getText();
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("��й�ȣ�� �Է����ּ���");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("������ ��й�ȣ�� ��� �Ұ����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("��й�ȣ�� �ִ� 32�� ���� �����մϴ�");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("��� ������ ��й�ȣ �Դϴ�");
				PWCheckLabel.setForeground(Color.blue);
					break;
				default:
				}
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		new Hint(PWPasswordField).hint();
		
		PWCPasswordField = new JPasswordField();
		PWCPasswordField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWCPasswordField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWCPasswordField.setBounds(12, 141, 159, 21);
		contentPane.add(PWCPasswordField);
		PWCPasswordField.setForeground(Color.LIGHT_GRAY);
		PWCPasswordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				PWConfirm=PWCPasswordField.getText();
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		PWCPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=2;
			}

			@Override
			public void focusLost(FocusEvent e) {
				PWConfirm=PWCPasswordField.getText();
				if(PW.equals(PWConfirm)&PW!=null&PW.length()!=0) {
					PWCCheckLabel.setText("��й�ȣ�� ��ġ�մϴ�");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				PWCCheckLabel.setForeground(Color.red);
			
					
				}
			}
		});
		new Hint(PWCPasswordField).hint();
		
		
		IDCheckLabel.setBounds(161, 32, 292, 15);
		contentPane.add(IDCheckLabel);
		
		
		PWCheckLabel.setBounds(183, 88, 270, 15);
		contentPane.add(PWCheckLabel);
		
		
		PWCCheckLabel.setBounds(183, 144, 270, 15);
		contentPane.add(PWCCheckLabel);
		
		
		NameCheckLabel.setBounds(161, 200, 292, 15);
		contentPane.add(NameCheckLabel);
		
		
		RRNCheckLabel.setBounds(140, 312, 313, 15);
		contentPane.add(RRNCheckLabel);
		
		
		jobCheckLabel.setBounds(627, 32, 396, 15);
		contentPane.add(jobCheckLabel);
		
		
		propCheckLabel.setBounds(627, 88, 396, 15);
		contentPane.add(propCheckLabel);
		
		
		telCheckLabel.setBounds(626, 144, 397, 18);
		contentPane.add(telCheckLabel);
		
		
		telCheckLabel2.setBounds(627, 172, 396, 15);
		contentPane.add(telCheckLabel2);
		
		
		PWQCheckLabel.setBounds(782, 253, 241, 15);
		contentPane.add(PWQCheckLabel);
		
		
		PWACheckLabel.setBounds(782, 312, 241, 15);
		contentPane.add(PWACheckLabel);
		
		
		PWACCheckLabel.setBounds(782, 368, 241, 15);
		contentPane.add(PWACCheckLabel);
	}
}
