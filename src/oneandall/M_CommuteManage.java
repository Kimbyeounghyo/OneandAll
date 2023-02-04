package oneandall;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import customComponent.PinkScroll;

public class M_CommuteManage extends JFrame {

	public M_CommuteManage() {

		
		setTitle("One and All");
		setSize(1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setBackground(Color.black);
		setLayout(null);

		 LocalDateTime now = LocalDateTime.now();
		 String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
		 
		 
		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 1200, 50);
		pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(pMenu);
		pMenu.setBackground(new Color(0, 0, 0));
		pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행4열에 10공백
		add(pMenu);
	     
	      var home = new UI_PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mousePressed(MouseEvent e) {
					new _Home();
					}
			
		});
	      
	      var login = new UI_PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new _Login();
			}
		
	      });
	     
	      
	      
	      var member = new UI_PinkButton("Member");
	      member.addMouseListener(new MouseAdapter() {
	    	  
			@Override
			public void mouseExited(MouseEvent e) {
		
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				new _Tap2();
			}

			@Override
			public void mousePressed(MouseEvent e) {

							}

	    	  
		});
	      
	      var project = new UI_PinkButton("Project");
	      project.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      
	      var schedule = new UI_PinkButton("Schedule");
	      schedule.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      pMenu.add(home); 
	      pMenu.add(member);
	      pMenu.add(project);
	      pMenu.add(schedule);
	      pMenu.add(login);
		// 전체패널
		JPanel Pn1 = new JPanel();
		Pn1.setBounds(0, 50, 1200, 1200);
		Pn1.setBackground(Color.black);
		Pn1.setLayout(null);

		// 팀원 선택
//		JPanel pChoice = new JPanel();
//		pChoice.setBounds(300, 10, 90, 40);
		Choice cMember = new Choice();
		cMember.setBounds(50, 15, 120, 40);
		cMember.setFont(new Font("맑은고딕", Font.PLAIN, 16));
		cMember.add("Jungwoo");
		cMember.add("Mark");
		cMember.add("Jeno");
		//pChoice.add(cMember);

		// 출근버튼
		JButton C1 = new UI_PinkButton("출 근");
		C1.setBounds(655, 10, 120, 40);
		C1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));
				
				JOptionPane.showMessageDialog(null, formatedNow + "\n" + "출근");
				System.out.println(formatedNow);
			}			
		});
		// 퇴근버튼
		JButton C2 = new UI_PinkButton("퇴 근");
		C2.setBounds(825, 10, 120, 40);
		C2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));
				
				JOptionPane.showMessageDialog(null,  formatedNow + "\n" + "퇴근");				
			}			
		});
		// 조퇴버튼
		JButton C3 = new UI_PinkButton("조 퇴");
		C3.setBounds(995, 10, 120, 40);
		C3.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));
				
				JOptionPane.showMessageDialog(null,  formatedNow + "\n" +"조퇴");				
			}			
		});
		Pn1.add(C1);
		Pn1.add(C2);
		Pn1.add(C3);

		// 출퇴근기록 패널
		
		JPanel pCommute = new JPanel();
		pCommute.setBackground(Color.BLACK);
		pCommute.setLayout(new BorderLayout());
		pCommute.setBounds(50, 70, 1100, 380);

		Font font = new Font("함초롱바탕", Font.PLAIN, 100);
		JTextArea ta = new JTextArea();
		
		ta.setBackground(Color.BLACK);
		ta.setFont(font);				
		ta.setForeground(Color.WHITE);
		ta.setLineWrap(true);
		ta.setEnabled(true); // false로 바꾸기		
		//ta.setBorder(new LineBorder(Color.black));
		
		PinkScroll scroll = new PinkScroll(ta) {
			@Override
            public void setBorder(Border border) {
          } 
		};
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pCommute.add(scroll);
		
		
		// 채팅패널
		JPanel Pchat = new JPanel();
		Pchat.setBounds(50, 475, 1100, 30);
		Pchat.setBackground(new Color(255, 198, 218));
		Pchat.setLayout(null);
				
		//Pn1.add(pChoice);
		Pn1.add(cMember);
		Pn1.add(pCommute);
		Pn1.add(Pchat);
		add(Pn1);

		setVisible(true);

	}

	public static void main(String[] args) {
		
		new M_CommuteManage();

	}

}
