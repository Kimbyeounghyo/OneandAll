package oneandall;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import javax.swing.JPanel;

//멤버 창

public class Member extends JFrame{
	

	
	public Member() {
		
	
		
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
	      
	      
	      var login = new PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new Login();
			}
		
	      
	      });
	      
	      var home = new PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				 new OneandAll_MainScreen();
			}
	    	 
		});
	      
	   
	  
	      
	      pMenu.add(home); 
	      pMenu.add(login);
	      pMenu.add(new PinkButton("Member"));
	      pMenu.add(new PinkButton("Project"));
	      pMenu.add(new PinkButton("Schedule"));
	     
	     
	      
	      //전체패널
	      JPanel Pn1 = new JPanel();
	      Pn1.setBounds(0, 50, 1200, 1200);
	      Pn1.setBackground(Color.black);
	      Pn1.setLayout(null);
	      //왼쪽안쪽패널
	      JPanel PlefIn = new JPanel();
	      PlefIn.setBounds(50, 20, 500, 430);
	      PlefIn.setBackground(new Color(255, 198, 218));
	      PlefIn.setLayout(null);   
	  	  
	    //채팅패널
	        JPanel Pchat = new JPanel();
		      Pchat.setBounds(50, 475, 1100, 30);
		      Pchat.setBackground(new Color(255, 198, 218));
		      Pchat.setLayout(null);
	      
	      //오른쪽안쪽패널
	      JPanel PrgIn = new JPanel();
	      PrgIn.setBounds(650, 20, 500, 430);
	      PrgIn.setBackground(new Color(255, 198, 218));
	      PrgIn.setLayout(null);   
	       
	
	      
	      Pn1.add(PrgIn);
	      Pn1.add(PlefIn);
	      Pn1.add(Pchat);
	     
	      add(Pn1);
	      
	      
	      setVisible(true);
	      
	      


	}


public static void main(String[] args) {
	
	
	new Member();
}

}


	