package updateAcconutPage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField rrn;
	private JTextField job;
	private JTextField prop;
	private JTextField tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdate frame = new AdminUpdate();
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
	public AdminUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbbel = new JLabel("\uC544\uC774\uB514");
		lbbel.setBounds(147, 22, 66, 32);
		contentPane.add(lbbel);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(12, 23, 116, 32);
		contentPane.add(id);
		
		JLabel namebel = new JLabel("\uC774\uB984");
		namebel.setBounds(147, 73, 66, 32);
		contentPane.add(namebel);
		
		JLabel genderbel = new JLabel("\uC131\uBCC4");
		genderbel.setHorizontalAlignment(SwingConstants.CENTER);
		genderbel.setBounds(12, 130, 66, 32);
		contentPane.add(genderbel);
		
		JLabel rrnbel = new JLabel("\uC8FC\uBBFC\uBC88\uD638 \uC55E\uC790\uB9AC");
		rrnbel.setBounds(134, 209, 99, 32);
		contentPane.add(rrnbel);
		
		JLabel jobbel = new JLabel("\uC9C1\uC5C5");
		jobbel.setBounds(496, 22, 66, 32);
		contentPane.add(jobbel);
		
		JLabel propbel = new JLabel("\uC7AC\uC0B0");
		propbel.setBounds(506, 73, 66, 32);
		contentPane.add(propbel);
		
		JLabel telbel = new JLabel("\uC804\uD654\uBC88\uD638");
		telbel.setBounds(496, 130, 66, 32);
		contentPane.add(telbel);
		
		JLabel facebel = new JLabel("\uC678\uBAA8");
		facebel.setHorizontalAlignment(SwingConstants.CENTER);
		facebel.setBounds(349, 209, 66, 32);
		contentPane.add(facebel);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(12, 74, 116, 32);
		contentPane.add(name);
		
		rrn = new JTextField();
		rrn.setColumns(10);
		rrn.setBounds(12, 210, 116, 32);
		contentPane.add(rrn);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(329, 23, 142, 32);
		contentPane.add(job);
		
		prop = new JTextField();
		prop.setColumns(10);
		prop.setBounds(329, 74, 142, 32);
		contentPane.add(prop);
		
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(331, 131, 142, 32);
		contentPane.add(tel);
		
		JRadioButton man = new JRadioButton("\uB0A8");
		man.setBounds(7, 168, 47, 23);
		contentPane.add(man);
		
		JRadioButton woman = new JRadioButton("\uC5EC");
		woman.setBounds(69, 168, 47, 23);
		contentPane.add(woman);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(man);
		group1.add(woman);
		
		JRadioButton upRBtn = new JRadioButton("\uC0C1");
		upRBtn.setBounds(304, 256, 47, 23);
		contentPane.add(upRBtn);
		
		JRadioButton midRBtn = new JRadioButton("\uC911");
		midRBtn.setBounds(368, 256, 47, 23);
		contentPane.add(midRBtn);
		
		JRadioButton lowRBtn = new JRadioButton("\uD558");
		lowRBtn.setBounds(433, 256, 47, 23);
		contentPane.add(lowRBtn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(upRBtn);
		group.add(midRBtn);
		group.add(lowRBtn);
		
		JButton ok = new JButton("\uD68C\uC6D0\uC815\uBCF4\uBCC0\uACBD");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1 = id.getText();
				String name1 = name.getText();
				String job1 = job.getText();
				String propTxt = prop.getText();
				//int prop1 = Integer.parseInt(propTxt);
				String tel1 = tel.getText();
				String gender1 = null;
				String face1 = null;
				
				if(!man.isSelected() && !woman.isSelected()) {
					JOptionPane.showMessageDialog(null,"성별을 클릭해주세요");
				}
				else if (!upRBtn.isSelected() && !midRBtn.isSelected() && !lowRBtn.isSelected()) {
					JOptionPane.showMessageDialog(null,"외모를 클릭해주세요");	
				}
				else if(id1.trim().isEmpty() || name1.trim().isEmpty() || job1.trim().isEmpty()
						|| propTxt.trim().isEmpty() || tel1.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"빈칸확인 후 입력해주세요");
				}else {
					System.out.println("성공");
					setVisible(false);
					new AfterAdminUpdate().setVisible(true);	
					
				}
				
				
			}
		});
		ok.setBounds(97, 326, 116, 55);
		contentPane.add(ok);
		
		JButton end = new JButton("\uCDE8\uC18C");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new Exc().setVisible(true);
			}
		});
		end.setBounds(304, 326, 116, 55);
		contentPane.add(end);
	}
}
