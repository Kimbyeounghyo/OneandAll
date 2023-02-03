package OneAndAll_TeamMate;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tap extends JFrame {
	
	public Tap() {
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
	      
	      //++++++++++++	
	    
	      //++++++++++++
	     
	      
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
	      
	      pMenu.add(new PinkButton("Home")); 
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(new PinkButton("Project"));
	      pMenu.add(new PinkButton("Schedule"));
	      
	      
	      
	      
	      
	      
	      setVisible(true);
	}

	public static void main(String[] args) {
		new Tap();
	
	}
	}

 
	


