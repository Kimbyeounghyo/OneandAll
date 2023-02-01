package OneAndAll_TeamMate;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import javax.swing.JPanel;

import ui.PinkButton;


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
	      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1��4���� 10����
	      add(pMenu);
	      
	     
	      
	      var login = new PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				//new Login();
			}
		
	      });
	     
	      var member = new PinkButton("Member");
	      member.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				//new Mainview();
			}
	    	  
		});
	      
	      var schedule = new PinkButton("Schedule");
	      schedule.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new Calendarmain();
				dispose();
			}
	    	  
		});
	     
	      
	      pMenu.add(new PinkButton("Home")); 
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(new PinkButton("Project"));
	      pMenu.add(schedule);
	      
	      
	      //��ü�г�
	      JPanel Pn1 = new JPanel();
	      Pn1.setBounds(0, 50, 1200, 1200);
	      Pn1.setBackground(Color.black);
	      Pn1.setLayout(null);
	      //���ʾ����г�
	      JPanel PlefIn = new JPanel();
	      PlefIn.setBounds(50, 120, 545, 300);
	      PlefIn.setBackground(new Color(255, 198, 218));
	      PlefIn.setLayout(null);   
	      //�����ʾ����г�
	      JPanel PrgIn = new JPanel();
	      PrgIn.setBounds(600, 120, 545, 300);
	      PrgIn.setBackground(new Color(255, 198, 218));
	      PrgIn.setLayout(null);   
	      //ä���г�
	      JPanel Pchat = new JPanel();
		  Pchat.setBounds(50, 475, 1100, 30);
		  Pchat.setBackground(new Color(255, 198, 218));
		  Pchat.setLayout(null);
	      //���������г�
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


	
