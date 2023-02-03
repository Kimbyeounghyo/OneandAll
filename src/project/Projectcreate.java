package project;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
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
	      
	     
	      
	      var login = new PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {});
	     
	      var member = new PinkButton("Member");
	      member.addMouseListener(new MouseAdapter() {});
	      
	      pMenu.add(new PinkButton("Home")); 
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(new PinkButton("Project"));
	      pMenu.add(new PinkButton("Schedule"));
		
		//addMenu(new MenuPanel()); 위 코드를 주석처리면 해당코드를 사용한 것과 같다
		
	    RoundJTextFieldExPink rp=new RoundJTextFieldExPink("Project Name");
		rp.setHorizontalAlignment(JTextField.CENTER);
		projectcreate(rp);
		projectterm(new PinkButtonPanel("기한"));
		RoundJTextFieldExWhite rt=new RoundJTextFieldExWhite("Start Date");
		projectstart(rt);
		rt.setHorizontalAlignment(JTextField.CENTER);
		projecting(new PinkButtonPanel("~"));
		RoundJTextFieldExWhite rw=new RoundJTextFieldExWhite("Finish Date");
		rw.setHorizontalAlignment(JTextField.CENTER);
		projectfinish(rw);
		projectoneline(new PinkButtonPanel("Sub Content"));
		RoundJTextFieldExWhite pt=new RoundJTextFieldExWhite("Content");
		projectcontent(pt);
		
		PinkButton4 pc=new PinkButton4("☑");
		pc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(rp.getText());
				System.out.println(rt.getText());
				System.out.println(rw.getText());
				System.out.println(pt.getText());
				System.out.println(pc.getText());
			}
		});
		
		projectcheck(pc);
		
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
