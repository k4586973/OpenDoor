package selectMemberPage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import openDoorVo.OpenDoorVO;

public class ClientMemberList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton reSelectBtn;
	private JLabel jobLb;
	private JLabel idLb;
	private JLabel nameLb;
	private JLabel genderLb;
	private JComponent propLb;
	private JLabel faceLb;
	JScrollPane scroll;
	String[] title = {"���̵�", "�̸�", "����", "����",
			"���", "�ܸ�"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMemberList frame = new ClientMemberList(null, null, null);
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
	public ClientMemberList(ArrayList<OpenDoorVO> memArray, String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ��ȸ ��� ��� Label
		JLabel selecLb = new JLabel("\uC870\uD68C \uACB0\uACFC \uCD9C\uB825");
		selecLb.setFont(new Font("����", Font.BOLD, 20));
		selecLb.setBounds(358, 37, 179, 39);
		contentPane.add(selecLb);
		
		// table ����
		DefaultTableModel tbModel = new DefaultTableModel(title,0);
		
		// ��ȸ ��� ������ֱ�
		for(int i=0; i<memArray.size(); i++) {
			String memId = memArray.get(i).getId();
			String memName = memArray.get(i).getName();
			String memGender = memArray.get(i).getGender();
			String memJob = memArray.get(i).getJob();
			int memProp = memArray.get(i).getProp();
			String memFace = memArray.get(i).getFace();
			
			Object[] data = {memId, memName, memGender,
					memJob, memProp, memFace};
			tbModel.addRow(data);
		}
		
		// ��ȸ ���̺� ����
		table = new JTable(tbModel); 
		table.setFont(new Font("����", Font.BOLD, 14));
		table.setBounds(12,93,839,331);
		contentPane.add(table);
		
		// �׸� Label --------------------------------
		idLb = new JLabel("\uC544\uC774\uB514");
		idLb.setFont(new Font("����", Font.BOLD, 15));
		idLb.setBounds(12, 68, 50, 28);
		contentPane.add(idLb);
		
		nameLb = new JLabel("\uC774\uB984");
		nameLb.setFont(new Font("����", Font.BOLD, 15));
		nameLb.setBounds(163, 71, 50, 22);
		contentPane.add(nameLb);
		
		genderLb = new JLabel("\uC131\uBCC4");
		genderLb.setFont(new Font("����", Font.BOLD, 15));
		genderLb.setBounds(296, 71, 50, 22);
		contentPane.add(genderLb);
		
		jobLb = new JLabel("\uC9C1\uC5C5");
		jobLb.setFont(new Font("����", Font.BOLD, 15));
		jobLb.setBounds(439, 72, 50, 20);
		contentPane.add(jobLb);
		
		propLb = new JLabel("\uC7AC\uC0B0");
		propLb.setFont(new Font("����", Font.BOLD, 15));
		propLb.setBounds(582, 72, 50, 20);
		contentPane.add(propLb);
		
		faceLb = new JLabel("\uC678\uBAA8");
		faceLb.setFont(new Font("����", Font.BOLD, 15));
		faceLb.setBounds(725, 71, 50, 22);
		contentPane.add(faceLb);
		// --------------------------------�׸� Label-end
		
		// �ϴ� Button-------------------------------
		reSelectBtn = new JButton("\uB418\uB3CC\uC544\uAC00\uAE30");
		reSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  // --> ��ȸ ȭ������ �̵�
				new ClientSelect(id, pw).setVisible(true);
			}
		});
		reSelectBtn.setFont(new Font("����", Font.BOLD, 15));
		reSelectBtn.setBounds(370, 457, 134, 33);
		contentPane.add(reSelectBtn);
		// -------------------------------�ϴ� Button-end
		
	}
}
