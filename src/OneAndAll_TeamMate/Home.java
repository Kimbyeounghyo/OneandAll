package OneAndAll_TeamMate;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import javax.swing.JPanel;


public class Home extends JFrame{
	

	
	public Home() {
		
	
		
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
			public void mouseExited(MouseEvent e) {
		
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				new _Tap2();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Member();
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
	      
	      
	      //전체패널
	      JPanel Pn1 = new JPanel();
	      Pn1.setBounds(0, 50, 1200, 1200);
	      Pn1.setBackground(Color.black);
	      Pn1.setLayout(null);
	      //왼쪽안쪽패널
	      JPanel PlefIn = new JPanel();
	      PlefIn.setBounds(50, 120, 545, 300);
	      PlefIn.setBackground(new Color(255, 198, 218));
	      PlefIn.setLayout(null);   
	      //오른쪽안쪽패널
	      JPanel PrgIn = new JPanel();
	      PrgIn.setBounds(600, 120, 545, 300);
	      PrgIn.setBackground(new Color(255, 198, 218));
	      PrgIn.setLayout(null);   
	      //채팅패널
	      JPanel Pchat = new JPanel();
		  Pchat.setBounds(50, 475, 1100, 30);
		  Pchat.setBackground(new Color(255, 198, 218));
		  Pchat.setLayout(null);
	      //공지사항패널
		  JPanel Pnotice = new JPanel();
		  Pnotice.setBounds(50,20,1095,95);
		  Pnotice.setBackground(new Color(255, 198, 218));
		  Pnotice.setLayout(null);
		  
	 
	      
	      Pn1.add(PrgIn);
	      Pn1.add(PlefIn);
	      Pn1.add(Pchat);
	      Pn1.add(Pnotice);
	      
	      add(Pn1);
	      
	      
	      setVisible(true);
	      
	      


	}


public static void main(String[] args) {
	
	
	new Home();
}

}


	