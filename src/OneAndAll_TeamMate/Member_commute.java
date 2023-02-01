package OneAndAll_TeamMate;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Member_commute extends JFrame{

	public Member_commute() {
		
		setTitle("One and All");
		setSize(1200,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setBackground(Color.black);
		setLayout(null);

		

	      JPanel pMenu = new JPanel();
	      pMenu.setBounds(0, 0, 1200, 50);
	      pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      getContentPane().add(pMenu);
	      pMenu.setBackground(new Color(0, 0, 0));
	      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
	      add(pMenu);
	      
	     
	      var home = new PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {
	    	
	    	  @Override
				public void mousePressed(MouseEvent e) {
					new OneandAll_Main();
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
			public void mousePressed(MouseEvent e) {
				new Member();
			}
	    	  
		});
	      
	      pMenu.add(home); 
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(new PinkButton("Project"));
	      pMenu.add(new PinkButton("Schedule"));
	      
	      
	      //전체패널
	      JPanel Pn1 = new JPanel();
	      Pn1.setBounds(0, 50, 1200, 550);
	      Pn1.setBackground(Color.black);
	      Pn1.setLayout(null);
	     
	      JPanel Pchat = new JPanel();
		  Pchat.setBounds(50, 475, 1100, 30);
		  Pchat.setBackground(new Color(255, 198, 218));
		  Pchat.setLayout(null);
	      
	      //버튼
	      JButton C1 = new PinkButton("출 근");
	      C1.setBounds(650, 30, 120, 40);
	      
	      JButton C2 = new PinkButton("퇴 근");
	      C2.setBounds(820, 30, 120, 40);
	      
	      JButton C3 = new PinkButton("조 퇴");
	      C3.setBounds(990, 30, 120, 40);
	
	      
	      Pn1.add(C1);
	      Pn1.add(C2);
	      Pn1.add(C3);
	
	      
	      //textarea 글씨체 흰색, 배경 검정으로
	      
	      add(Pchat);
	      add(Pn1);
	      setVisible(true);	
	      
	    	
	}
	public static void main(String[] args) {
		new Member_commute();
	}
	
}
