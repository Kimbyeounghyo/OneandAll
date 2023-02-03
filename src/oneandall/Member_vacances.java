package OneAndAll_TeamMate;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class Member_vacances extends JFrame{

	public Member_vacances() {
		
		
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
	      
	      JPanel Pv1 = new JPanel();
	      Pv1.setBounds(0, 50, 1200, 550);
	      Pv1.setBackground(Color.black);
	      Pv1.setLayout(null);

	      JButton vbtn = new JButton();
	      vbtn.setBounds(100, 20, 1000, 35);
	      vbtn.setBorder(new LineBorder(new Color(255, 198, 218)));
	      
	      vbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new Date();
			}
	    	  
		});
	      
	      
	      
		   ImageIcon ch1 = new ImageIcon("png (4)");
		   Image img1 = ch1.getImage();
		   Image changeImg1 = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		   ImageIcon changeicon1 = new ImageIcon(changeImg1);
		
		
		   JLabel vText = new JLabel("휴가를 입력하세요");
		   vText.setForeground(new Color(255, 198, 218));
		  
		   vText.setBounds(550, 20, 100, 35);
		   JLabel vlab = new JLabel(changeicon1);
		   vlab.setBounds(1060, 20, 35, 35);
		   
		      
		   JPanel Pchat = new JPanel();
				  Pchat.setBounds(50, 475, 1100, 30);
				  Pchat.setBackground(new Color(255, 198, 218));
				  Pchat.setLayout(null);
				  
		  JTextArea vacArea = new JTextArea();
		  vacArea.setBackground(Color.black);
		  vacArea.setForeground(Color.white);
		  vacArea.setBounds(50, 70, 1100, 380);
		  vacArea.setBorder(new LineBorder(Color.black));
		  
		  vacArea.setLineWrap(true);
		  
		  JScrollPane scroll = new JScrollPane(vacArea);
		  scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	      
		 	Pv1.add(vacArea);
	    	Pv1.add(scroll);
	     	Pv1.add(Pchat);	  
	   		Pv1.add(vlab);
	   		Pv1.add(vText);
	   		Pv1.add(vbtn);
	   		
	  
	   		add(pMenu);
	   		add(Pv1);

		  
	      setVisible(true);
	      
	      


		
	}
	
	
		
	public static void main(String[] args) {
		new Member_vacances();
	}
	
	
}
