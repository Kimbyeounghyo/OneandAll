package TodoList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class JframeTest extends JFrame implements ActionListener{
	
	//TODO �������� ���� �κ�
	static JframeTest mainActivity;
	static JLabel txt;
	//TODO �θ� ������ ����
	static JFrame frm = new JFrame("������ â �޴��� ����");
	static JTextArea textarea = new JTextArea();
	static JTextField tf;
	
	//TODO ���� �޼ҵ� ���� �κ�
	public static void main(String[] args) {
		
		JPanel p1 = new JPanel();
		tf=new JTextField(15);
		
		//TODO Ŭ���� ��ü ���� (Ŭ�� �̺�Ʈ ����)
		mainActivity = new JframeTest();
		
		
 
		//TODO �θ� ������ ũ�� ���� (����, ����)
		frm.setSize(600	, 1200);
 
		//TODO �θ� �������� ȭ�� ����� ��ġ
		frm.setLocationRelativeTo(null);
 
		//TODO �θ� �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TODO �θ� ������ â ũ�� ���� �ǽ�
		frm.setResizable(false);
 
		//TODO �θ� ���̾ƿ� ����
		frm.getContentPane().setLayout(null);
				
		frm.add(p1);
		//TODO �ڽ� ���̾ƿ� [�޴���] ����
		JMenuBar menu = new JMenuBar(); //�޴��� Ʋ ����

		
		JMenu schedule = new JMenu("������");
		JMenuItem groupSchedule = new JMenuItem("�׷� ��������");
		JMenuItem personalSchedule = new JMenuItem("���� ��������");
		groupSchedule.addActionListener(mainActivity); //TODO �޴��� Ŭ���̺�Ʈ ����
		personalSchedule.addActionListener(mainActivity); //TODO �޴��� Ŭ���̺�Ʈ ����	
		schedule.add(groupSchedule);
		schedule.add(personalSchedule);
		
		menu.add(schedule);
		menu.setBounds(0, 0, 500, 30); //setBounds(������ġ, ������ġ, ���α���, ���α���);
		
		//TODO �ڽ� ���̾ƿ� [�� �ؽ�Ʈ] ����
		txt = new JLabel("");
		txt.setBounds(0, 35, 500, 100); //setBounds(������ġ, ������ġ, ���α���, ���α���);
		txt.setFont(new Font("���� ���", 0, 20)); //TODO ��Ʈ ����
		txt.setHorizontalAlignment(JLabel.CENTER); //TODO �ؽ�Ʈ ���� ǥ�� ����
				
		//TODO �θ� �����ӿ��ٰ� �ڽ� ������Ʈ �߰�
		frm.getContentPane().add(menu);
		frm.getContentPane().add(txt);
		
		//TODO �θ� �������� ���̵��� ����
		frm.setVisible(true);
		
		
		
		
	}//���� ����
	
	//TODO ��ư Ŭ�� �̺�Ʈ ���� �κ�
	@Override
	public void actionPerformed(ActionEvent e) { 
		//TODO Auto-generated method stub
			
		//TODO ������Ʈ�� ���ǵ� text �޾ƿ��¿��� 
		switch(e.getActionCommand()){
			
		//TODO getActionCommand() ��ư�� �ؽ�Ʈ�� ���ɴϴ�
		case "�׷� ��������": 
			
			
			txt.setText("�׷� ����"); 
			break;
			
		case "���� ��������": 
			//���̺�
			JTableTest jtable = new JTableTest();
			jtable.setDefaultCloseOperation(EXIT_ON_CLOSE);
			txt.setText("���� ����"); 
			break;	
			
		
		default :
			txt.setText("NO"); 
			break;
		}
	}
	

}//Ŭ���� ����