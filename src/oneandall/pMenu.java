package oneandall;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.PinkButton;
import ui.PinkIconButton;

@SuppressWarnings("serial")
public class pMenu extends JPanel {
	
	public pMenu() {
		
	    
	      setBounds(0, 0, 1200, 50);
	      setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      setBackground(new Color(0, 0, 0));
	      setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
	     
	      
	      //++++++++++++	
	    
	      //++++++++++++
	     
	      
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
	      
	     add(home); 
	     add(login);
	     add(member);
	     add(project);
	     add(schedule);
	      
	      
	
		
	}
	

}
