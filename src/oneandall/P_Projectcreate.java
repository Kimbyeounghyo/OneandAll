package oneandall;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class P_Projectcreate extends JFrame{
	
	JFrame frame;
	JPanel defaultPanel;
	
	public P_Projectcreate() {
		frame = this;
		setTitle("OneAndAll");
		
		setContentPane(defaultPanel = new JPanel(null));
		getContentPane().setBackground(Color.BLACK);
		
		//Panel-------------s----------------------------------
		
		 JPanel pMenu = new JPanel();
	      pMenu.setBounds(0, 0, P_EnvironmentConfigure.PROJECT_WIDTH, 50);
	      pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      getContentPane().add(pMenu);
	      pMenu.setBackground(new Color(0, 0, 0));
	      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
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
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(project);
	      pMenu.add(schedule);
	      
		
		//addMenu(new MenuPanel()); 위 코드를 주석처리면 해당코드를 사용한 것과 같다
	    UI_RoundJTextFieldExPink pName = new UI_RoundJTextFieldExPink("Project Name");
		projectcreate(pName);
		
		projectterm(new UI_PinkButtonPanel("기한"));
		UI_RoundJTextFieldExWhite sDate = new UI_RoundJTextFieldExWhite("Start Date");
		projectstart(sDate);
		projecting(new UI_PinkButtonPanel("~"));
		UI_RoundJTextFieldExWhite eDate =  new UI_RoundJTextFieldExWhite("Finish Date");
		projectfinish(eDate);
		
		projectoneline(new UI_PinkButtonPanel("Sub Content"));
		
		UI_RoundJTextFieldExWhite pContent = new UI_RoundJTextFieldExWhite("Content");
		projectcontent(pContent);
		
		UI_PinkButton4 pb4 = new UI_PinkButton4("☑");
		pb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					sdf.parse(sDate.getText());
					sdf.parse(eDate.getText());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "기한은 yyyy-MM-dd 형태로 입력해주세요");
					return;
				}
				
				if(CPT_CPTManager.pList == null)
					CPT_CPTManager.pList = new ArrayList<P_Project>();
				
				CPT_Coworker c = CPT_LoginInfo.getLoggedInfo();
				
				P_Project p = new P_Project(pName.getText(), pContent.getText(), sDate.getText(), eDate.getText());
				p.workers = new ArrayList<CPT_Coworker>();
				p.workers.add(c);
				
				CPT_CPTManager.pList.add(p);
				
				JOptionPane.showMessageDialog(null, "프로젝트를 생성했어요");
								
				frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
				new _OneandAll_MainScreen();
				frame.dispose();
			}
		});
		projectcheck(pb4);
		
		//----------------------------------------------------
		
		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

	
	private void projectcreate(UI_RoundJTextFieldExPink pinkButton2) {
		pinkButton2.setBounds(10,50,1164,50);
		getContentPane().add(pinkButton2);
	}
	
	private void projectterm(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10,110,250,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectstart(UI_RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(270,110,350,70);
		getContentPane().add(pinkButton3);
	}
	
	private void projecting(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(630,110,185,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectfinish(UI_RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(825,110,350,70);
		getContentPane().add(pinkButton3);
	}
	
	private void projectoneline(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10,190,1164,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectcontent(UI_RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(10,270,1164,170);
		getContentPane().add(pinkButton3);
	}
	
	private void projectcheck(UI_PinkButton4 pinkButton4) {
		pinkButton4.setBounds(10,450,1164,100);
		getContentPane().add(pinkButton4);
	}

}
