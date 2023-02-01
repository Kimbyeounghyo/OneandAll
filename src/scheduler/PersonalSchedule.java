package scheduler;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.GreenButton;
import ui.PinkButton;
import ui.PinkLabel;
import ui.PinkPanel;
import ui.PinkRoundButton;
import ui.RedButton;
import ui.RoundTextArea;
import ui.RoundTextField;

public class PersonalSchedule {
	public static void main(String[] args) {
		new Calendarmain();
	}
}

class Calendarmain extends JFrame implements ActionListener{
	
	JFrame frame = new JFrame();
	
	
	//Ķ���� ����
	Scanner sc = new Scanner(System.in);
	Container container = getContentPane();

	CalendarFunction cF = new CalendarFunction();
	
	GroupFunction gF= new GroupFunction();
	
	ImageIcon star = new ImageIcon("��.png");
	ImageIcon home = new ImageIcon("home.png");
	ImageIcon panelpng = new ImageIcon("�г�.png");
	ImageIcon save = new ImageIcon("disk.png");
	ImageIcon reset = new ImageIcon();
	
	
	//TODO Panel
	JPanel p_Month = new JPanel();
	JPanel p_Calendar = new JPanel();
	JPanel p_Center = new JPanel();
	JPanel p_South = new JPanel();
	JPanel p_West = new JPanel();
	JPanel p_North = new JPanel();
	JPanel Pchat = new JPanel();
	 
	JButton p_bar_G = new JButton();
	JButton p_bar_R = new JButton(home);
	JButton Calendar_bar = new JButton(star);
	
	JButton buttonBefore = new PinkRoundButton("<");
	JButton buttonAfter = new PinkRoundButton(">");
	//JButton delBarBtn = new GreenButton("�߰�");
	//JButton insBarBtn = new RedButton("����");
	
	JButton[] buttonsOfDay = new PinkButton[7];
	
	//label�� p_month�� �����
	JLabel label = new JLabel("00�� 0��");
	JLabel Title = new JLabel("����/�׷� ����"); //center ��
	JLabel[] Label_Day = new JLabel[42];
	
	
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	String[] memberName = {"��������" , "�躴ȿ(����)", "��ä��(������)", "������", "������", "������"};
	JComboBox<String> jComboBox = new JComboBox<>(memberName);
   
	//TODO Default Color: PINK 
	Color bg = new Color(255, 188, 218);
	
	RoundTextArea c_textArea = new RoundTextArea();
	
   

	//�Է»���
    JTextField tf = new RoundTextField();
	
	JTextField tf2 = new RoundTextField();
	
	JButton btn = new PinkButton("������");
	JButton endDateBtn = new PinkButton("������");
	
	
	public Calendarmain() {
		setTitle("������ �ۼ��ϱ�");
		setSize(1200, 600);//width height
		container.setBackground(Color.black);
		setLocationRelativeTo(null);
	    init();
		start();
		setVisible(true);
	}
	public void init() {
		
		//TODO container
		 container.setLayout(null);
		 container.add(p_Month);
		 container.add(p_Calendar);
		 container.add(p_Center);
		 container.add(p_South);
		 container.add(p_North);
		 container.add(p_West);
		 container.add(Pchat);
		 
		// container.add(p_bar_G);
		 container.add(p_bar_R);
		 
		 //��ġ ���� �ڵ�
		 p_North.setBounds(20,10,300,40);
		 p_North.setBackground(Color.BLACK);
		 p_North.add(Title);
		 
		 p_Month.setBounds(400,20,300,40);
		 p_Month.setBackground(Color.BLACK);
		 
		 p_Calendar.setBounds(500,100,650,375);
		 
		 p_Center.setBounds(42,130,400,240);
		 p_Center.setBackground(Color.black);
		 
		 
		
		 //panel_bar_Green�� ���� �� : �޷¿� �������
		 p_bar_G.setBackground(Color.GREEN);
		 p_bar_G.setBounds(0,0,50,10);
		 p_bar_G.setVisible(true);
		 
		 p_bar_R.setBorder(BorderFactory.createEmptyBorder());
		 p_bar_R.setBounds(20,20,40,30);
		 p_bar_R.setBackground(Color.black);
		 
		 p_Calendar.setBorder(BorderFactory.createEmptyBorder());
		 p_Calendar.setLayout(new GridLayout(7, 7, 0, 0));
		 p_Calendar.setBackground(Color.white);
		 //p_Calendar.setBorder(border);
		 
		 Calendar_bar.setBackground(bg);
		 Calendar_bar.setBounds(61,5,20,20);
		 Calendar_bar.setVisible(true);
		
		 
		
		 p_Month.setLayout(new FlowLayout());
		 p_Month.add(buttonBefore);
		 p_Month.add(label);
		 p_Month.add(buttonAfter);
		 
		 //�������� ����ٿ� �޴�
		 p_West.add(jComboBox);
		 p_West.setBounds(60, 75, 140, 50);
		 p_West.setBackground(Color.BLACK);
		 
		
		 c_textArea.setBackground(Color.white);
		 //			int width, int height
		 c_textArea.setPreferredSize(new Dimension(330,200));
		 
		 //                              �� �� ���� �� ��

		
		
		
		 Font font = new Font("�������", Font.BOLD, 25);
		 //buttonAfter.setFont(font);
		 //buttonBefore.setFont(font);
		 label.setFont(font);
		 label.setOpaque(true); 
		 label.setBackground(Color.BLACK);
	     label.setForeground(bg);
		 
		 label.setText(cF.getCalText());
		 
		 
		 Title.setBackground(Color.BLACK);
		 Title.setFont(font);
		 Title.setOpaque(true);
		 Title.setForeground(Color.PINK);
		 
		 Title.setText(gF.getGroupNameText());
		 
		 Pchat.setBounds(50, 505, 1100, 30);
		 Pchat.setBackground(new Color(255, 198, 218));
		 Pchat.setLayout(null);
		 
		 
		 tf.setPreferredSize(new Dimension(35,23));
		 tf2.setPreferredSize(new Dimension(35,23));
		 
		 
		 //==========================������ �̺�Ʈ ó�� �ҽ��ڵ� �����=================================
		 
		 //�׷����� ��� ��ư
		 JTextField w_work = new RoundTextField();
		 w_work.setPreferredSize(new Dimension(300,30));
		 //���� ��ư �̺�Ʈ ����
		 w_work.addKeyListener(new KeyAdapter() {
			
			 @Override
			 public void keyTyped(KeyEvent e) {

				
				 if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					 
				     //(���� VOŬ������ ���� �޾ƿ� ����)
					 c_textArea.append(w_work.getText()+"\n");
					 
					 //�ؽ�Ʈ�ʵ� ����ְ� ��Ŀ�� �̵�
					 w_work.setText("");
					 w_work.requestFocus();
				 }
				
			 }
		});
		
		p_Center.add(w_work);
		 
		 //�ؽ�Ʈ ���ڰ� �ָ� ������ ���ڰ� ������� �ƴϸ� ���ڰ� ��Ÿ����
		 w_work.addFocusListener(new FocusListener() {
		
			@Override
			public void focusLost(FocusEvent e) {
			
				if(w_work.getText().equals("")) {
				 w_work.setText("���⿡ ������ �Է����ּ���");
				 
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(w_work.getText().equals("���⿡ ������ �Է����ּ���")) {
					 w_work.setText("");
					 
				}
				 System.out.println(jComboBox.getSelectedItem().toString());
			}
		});
		 
		 //TODO p_South 
		 p_Center.add(c_textArea);
		 p_South.setBounds(42,380,400,40);
		 p_South.setBackground(Color.black);
		 p_South.add(btn);
		 p_South.add(tf);
		 p_South.add(endDateBtn);
		 p_South.add(tf2);
		 //���¹�ư
		 JButton resetBtn = new GreenButton("�ʱ�ȭ");
		 resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Calendarmain();
				dispose();
			}
		 });
		 container.add(resetBtn);
		 resetBtn.setBounds(975,20,50,20); // ���¹�ư
		 resetBtn.setPreferredSize(new Dimension(10,25));
		 
		
		//TODO SaveButton
		 JButton saveBtn = new JButton(save);
		 saveBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = c_textArea.getText();
					try {
						//FileDialog(save, load�Ҷ� ���Ǵ� ������(��ȭ����)
						FileDialog fd = new FileDialog(frame,"����", FileDialog.SAVE);
						fd.setVisible(true);
						//System.out.println(fd.getDirectory()+fd.getFile());
						String path=fd.getDirectory()+fd.getFile();
						if(!message.equals("")) {//message�� �����Ͱ� ������� �ʴٸ�
							FileWriter fw = new FileWriter(path);
							BufferedWriter bw = new BufferedWriter(fw);
							
							bw.write(message);
							//FileDialog�� ��ҹ�ư�� ������ �ʰ� ���� ����
							//������ ���
							if(fd.getFile()!=null) {
								JOptionPane.showMessageDialog(frame,path+"\n ��ο� ����Ǿ����ϴ�.");
							}
							bw.close();
						}else {//TextArea�� ����Ұ� ���ٸ�
							JOptionPane.showMessageDialog(frame, "���� �� ������ �����ϴ�.");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		 //			     	x	y width height								
		 saveBtn.setBounds(1090,20,50,40); // ���� ��ư
		 saveBtn.setPreferredSize(new Dimension(10,25));		 
		 saveBtn.setBorder(BorderFactory.createEmptyBorder());
		 saveBtn.setBackground(null);
		 container.add(saveBtn);//�����ư
		 
		
		 tf.setText("");
		 tf.requestFocus();
		 tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				 if(e.getKeyChar() == KeyEvent.VK_ENTER && tf2.getText().equals("")) {
					 JOptionPane.showMessageDialog(frame,"�������� �Է��� �ּ���.");
				 }else if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					 c_textArea.append("�۾� ���� : "+ tf.getText()+"�� ���� ");
					 c_textArea.append(tf2.getText()+"�ϱ��� �۾�!"+"\n");
					 
					 
					 barMethod();
				 }	 	
				
				 System.out.println(jComboBox.getSelectedItem().toString());
			}
		 });
		 //�ؽ�Ʈ�ʵ� ����ְ� ��Ŀ�� �̵�
		 tf2.setText("");
		 tf2.requestFocus();
		 
		 tf2.addKeyListener(new KeyAdapter() {
			 //KeyEvent ��� Ű���� Ű�� �������
			 @Override
			 public void keyTyped(KeyEvent e) {
				 if(e.getKeyChar() == KeyEvent.VK_ENTER && tf.getText().equals("")) {
					 JOptionPane.showMessageDialog(frame,"�������� �Է��� �ּ���.");
				 } else if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					 c_textArea.append("�۾� ���� : "+ tf.getText()+"�� ���� ");
					 c_textArea.append(tf2.getText()+"�ϱ��� �۾�!"+"\n");
					 barMethod();
				 }//if end
				 
//				 System.out.println(tf.getText());
//				 System.out.println(jComboBox.getSelectedItem().toString());
//				 System.out.println(tf2.getText());
				
			}
			 
		 });
		 
		 
		 
		 p_bar_R.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Home();
					dispose();
				}
			});
		 
		 
		
		
		 //���� �޷� ���� ���� �ʱ�ȭ�� �Ǵ� ���
			ActionListener cbtn = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clearLabelDay();
				}
			};
	     buttonBefore.addActionListener(cbtn);		 
		 buttonAfter.addActionListener(cbtn);
		 
		 
		 //========= �޷¿� ���� �ҽ� �ڵ� ==========
		 
		 //�� ȭ �� �� �� �� ��
		 for(int i=0;i<buttonsOfDay.length;i++) {
			 buttonsOfDay[i] = new PinkButton();
			 p_Calendar.add(buttonsOfDay[i]);
			 buttonsOfDay[i].setFont(new Font("SansSerif", Font.BOLD, 20));
			 buttonsOfDay[i].setText(dayNames[i]);
		 }
		 
		 // 1 2 3 4 5...
		 // ��, ���� ���� �ٸ�
		 for(int i=0;i<Label_Day.length;i++) {
			 Label_Day[i] = new JLabel();
			 
			 p_Calendar.add(Label_Day[i]);
			 Label_Day[i].setFont(new Font("SansSerif", Font.PLAIN, 15));
			 Label_Day[i].setOpaque(true);//������ �����Ϸ��� �ʿ���
			 Label_Day[i].setBackground(Color.white);
			 if(i%7 == 0) Label_Day[i].setForeground(Color.RED);
			 if(i%7 == 6) Label_Day[i].setForeground(Color.BLUE);
			
			
		 }
		 
		//----------------------------------------------------
	
		 
		 cF.setButtons(Label_Day);
		 cF.calSet();
		//TODO ComboBox
		 jComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jComboBox.getSelectedItem().equals("������")) {
					//JOptionPane.showMessageDialog(frame,"�̰������ּ���");
					loadSch();
				}
				else if(jComboBox.getSelectedItem().equals("������")) {
					loadSch();
				}
				else if(jComboBox.getSelectedItem().equals("��ä��(������)")) {
					loadSch();
				}
				else if(jComboBox.getSelectedItem().equals("������")) {
					loadSch();
				}
				else if(jComboBox.getSelectedItem().equals("�躴ȿ(����)")) {
					loadSch();

				}else if(jComboBox.getSelectedItem().equals("����ȭ��")) {
					loadSch();
				}
//				}else if(jComboBox.getSelectedItem().equals("�׷�����")) {
//					loadSch();
//					Label_Day[11].setBackground(new Color(255,242,255));
//					Label_Day[11].add(Calendar_bar);
//					Calendar_bar.addActionListener(new ActionListener() {
//						
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							new MemoFrame();
//						}
//					} );
//				}
			}
		});
		 
	}
	
	
	//TODO BarMethod
	int tempH =0;//�޷� �ߺ� �� üũ
	public void barMethod() {
		
		try {
		//��ư�ڷ��� list
		List<JButton> list = new ArrayList<>();
		
		 for(int i=0; i<Label_Day.length;i++) {
			 int a = Integer.parseInt(tf2.getText());
			 int b = Integer.parseInt(tf.getText());
			 
			 //�󺧰��� �������� �޼���� getText();
			 if(Label_Day[i].getText().equals(tf2.getText())) {

				 for(int j=0; j<=a-b;j++) {
				 Label_Day[i-j].setBackground(new Color(255,255,222));
				 Label_Day[i-j].setOpaque(true);
				 p_bar_G=new JButton();
				 list.add(p_bar_G);
				 if(tempH<8) {
				     p_bar_G.setBackground(new Color(255, 208, 218));
				 }else if(tempH>=8 && tempH<16) {
					 Label_Day[i-j].setBackground(new Color(255,255,227));
					 p_bar_G.setBackground(new Color(255, 188, 218));
				 }else if(tempH>=16 && tempH <24) {
					 Label_Day[i-j].setBackground(new Color(255,255,232));
					 p_bar_G.setBackground(new Color(255, 168, 218));
				 }else if(tempH>=24 && tempH <32) {
					 Label_Day[i-j].setBackground(new Color(255,255,242));
					 p_bar_G.setBackground(new Color(217,255,179));
				 }else if(tempH>=32 && tempH <40) {
					 Label_Day[i-j].setBackground(new Color(255,255,247));
					 p_bar_G.setBackground(new Color(179,255,198));
				 }else if(tempH>=40) {
					 JOptionPane.showMessageDialog(frame,"���̻� �ԷºҰ�");
					 tempH-=48;
					 break;
				 }
				 p_bar_G.setBounds(0,10+tempH,100,8);
				 Label_Day[i-j].add(p_bar_G);
				 }//for j end
			 }
		 }//for i end
		 tempH+=8;
		 
		 //�ٸ� Ŭ���ϸ� ���� �޸� ����
		 for(int i=0; i<list.size();i++) {
			 list.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new MemoFrame();
					}
				});
		 }
		}catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("��ȿ���� ���� ����");
			JOptionPane.showMessageDialog(frame,"������ : "+tf.getText()+"\n"+ "������ : " +tf2.getText()+"\n"+"�ùٸ� ������ �ƴմϴ�."
			+"\n"+"��¥ �Է� ������ ����");
		}	
	}//bar Method
	
	public void clearLabelDay() {
		 for(int i=0;i<Label_Day.length;i++) {
			 Label_Day[i].setFont(new Font("SansSerif", Font.PLAIN, 5));
			 Label_Day[i].setOpaque(true);//������ �����Ϸ��� �ʿ���
			 Label_Day[i].setBackground(Color.white);
			 Label_Day[i].removeAll();
		 }
	}
	//������ ������ ��ư
	public void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonAfter.addActionListener(this);
		buttonBefore.addActionListener(this);
	}
	
	public void loadSch() {
		c_textArea.setText("");
		clearLabelDay();
		c_textArea.append(" "+jComboBox.getSelectedItem().toString()+"���� �������� ȭ��"+"\n");
	}
	
	//������ ������ ��ư Ŭ���� ��� ����
	//gap��ŭ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == buttonAfter) {				// 1�� ��
			gap = 1;
		} else if(e.getSource() == buttonBefore ) {		// 1�� ��
			gap = -1;
		}
		cF.allInit(gap);
		label.setText(cF.getCalText());		// ��� ���� ����		
		
	}	
	
}