package project;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scheduler.Home;
import util.CPTManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projectcreate extends JFrame{
	
	JPanel defaultPanel;
	JFrame frame;
	
	public Projectcreate() {
		
		frame = this;
		
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
		rt.setHorizontalAlignment(JTextField.CENTER);
		projectstart(rt);
      
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
				Date d =null;
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					d = format.parse(rt.getText());
					System.out.println(d);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Date d2 =null;
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					d2 = format.parse(rw.getText());
					System.out.println(d2);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "날짜형식은 yyyy-mm-dd입니다");
					return;
				}
				Project pj=new Project();
				System.out.println(pj.name=rp.getText());
				System.out.println(pj.startDate=d);
				System.out.println(pj.endDate=d2);
				System.out.println(pj.content=pt.getText());
				System.out.println(pc.getText());
				if(CPTManager.pList!=null){					
					CPTManager.pList.add(pj);
				}else if(CPTManager.pList==null){
					List<Project> pList=new ArrayList<Project>();
					pList.add(pj);
				}
				
				frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
				new Home();
				frame.dispose();
				
				
				
				
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
