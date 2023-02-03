package oneandall;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Projectcreate extends JFrame{
	
	JPanel defaultPanel;
	
	public Projectcreate() {
		setTitle("OneAndAll");
		
		setContentPane(defaultPanel = new JPanel(null));
		getContentPane().setBackground(Color.BLACK);
		
		//Panel-------------s----------------------------------
		
		 JPanel pMenu = new JPanel();
	      pMenu.setBounds(0, 0, EnvironmentConfigure.PROJECT_WIDTH, 50);
	      pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      getContentPane().add(pMenu);
	      pMenu.setBackground(new Color(0, 0, 0));
	      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
	      add(pMenu);
	      
	     
	      
	      var home = new PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mousePressed(MouseEvent e) {
					new Home();
					}
			
		});
	      
	      var login = new PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new Login();
			}
		
	      });
	     
	      
	      
	      var member = new PinkButton("Member");
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
	      
	      var project = new PinkButton("Project");
	      project.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      
	      var schedule = new PinkButton("Schedule");
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
		
		projectcreate(new RoundJTextFieldExPink("Project Name"));
		projectterm(new PinkButtonPanel("기한"));
		projectstart(new RoundJTextFieldExWhite("Start Date"));
		projecting(new PinkButtonPanel("~"));
		JTextField tf =  new RoundJTextFieldExWhite("Finish Date");
		tf.setHorizontalAlignment(JTextField.CENTER);
		projectfinish((RoundJTextFieldExWhite)tf);
		projectoneline(new PinkButtonPanel("Sub Content"));
		projectcontent(new RoundJTextFieldExWhite("Content"));
		projectcheck(new PinkButton4("☑"));
		
		//----------------------------------------------------
		
		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

	
	private void projectcreate(RoundJTextFieldExPink pinkButton2) {
		pinkButton2.setBounds(10,50,1164,50);
		getContentPane().add(pinkButton2);
	}
	
	private void projectterm(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10,110,250,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectstart(RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(270,110,350,70);
		getContentPane().add(pinkButton3);
	}
	
	private void projecting(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(630,110,185,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectfinish(RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(825,110,350,70);
		getContentPane().add(pinkButton3);
	}
	
	private void projectoneline(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10,190,1164,70);
		getContentPane().add(pinkButton2);
	}
	
	private void projectcontent(RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(10,270,1164,170);
		getContentPane().add(pinkButton3);
	}
	
	private void projectcheck(PinkButton4 pinkButton4) {
		pinkButton4.setBounds(10,450,1164,100);
		getContentPane().add(pinkButton4);
	}

}
