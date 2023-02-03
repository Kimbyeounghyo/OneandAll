package project;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Projectarrange extends JFrame{
	
	JPanel defaultPanel;
	
	public Projectarrange() {
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

		projectName(new RoundJTextFieldExPink("Project Name"));
		projectterm(new PinkButtonPanel("Term"));
		projectstart(new RoundJTextFieldExWhite("Start Date"));
		projecting(new PinkButtonPanel("~"));
		projectfinish(new RoundJTextFieldExWhite("Finish Date"));
		projectmaster(new PinkButtonPanel("Project master"));
		projectmastername(new PinkButton3("Master Name"));
		projectcheck(new PinkButton4("☑"));
		JPanel  jpanel=new JPanel () {
		
			@Override
			protected void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
				FontMetrics fontMetrics = graphics.getFontMetrics();
				
				graphics.setColor(new Color(255, 198, 218));
				graphics.fillRoundRect(0, 0, width, height, 10, 10);
				graphics.setColor(getForeground());
				graphics.dispose();
			}
	};
		    jpanel.setBackground(new Color(255, 198, 218, 255));
		    jpanel.setBounds(10,190,520,360);
		    jpanel.setLayout(null);
//		    JScrollPane scroll=new PinkScroll(jpanel);
//		    scroll.setBorder(BorderFactory.createEmptyBorder());
//		    scroll.setBackground(new Color(0, 0, 0, 0));
//		    scroll.setBounds(10,190,540,360);
//		    this.getContentPane().add(scroll);
		    JPanel jpanel3=new JPanel();
		 jpanel3.setOpaque(false);
		    jpanel3.setBackground(new Color(255, 198, 218, 0));
//		    jpanel3.setBounds(10,0,510,360);
		SearchTextField st=new SearchTextField("팀원명");
		st.setBounds(10,10,500,30);
		jpanel.add(st);
//		PinkIconsearch pinkiconsearch=new PinkIconsearch();
//		pinkiconsearch.setBounds(470,14,25,25);
//		jpanel.add(pinkiconsearch,JDesktopPane.POPUP_LAYER);
//		jpanel.add(jpanel3);
		this.getContentPane().add(jpanel);


		projectarrow(new PinkIconarrow());
		JPanel jpanel2=new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
				FontMetrics fontMetrics = graphics.getFontMetrics();
				
				graphics.setColor(new Color(255, 198, 218));
				graphics.fillRoundRect(0, 0, width, height, 10, 10);
				graphics.setColor(getForeground());
				graphics.dispose();
			}
			
		};
		
		jpanel2.setBackground(new Color(255, 198, 218));
		
		projectteam2(jpanel2);
		
		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}
	

	private void projectName(RoundJTextFieldExPink pinkButton2) {
		pinkButton2.setBounds(10,50,1164,60);
		getContentPane().add(pinkButton2);
	}
	
	private void projectterm(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10,120,130,60);
		getContentPane().add(pinkButton2);
	}
	
	private void projectstart(RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(150,120,200,60);
		getContentPane().add(pinkButton3);
	}
	
	private void projecting(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(360,120,100,60);
		getContentPane().add(pinkButton2);
	}
	
	private void projectfinish(RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(470,120,200,60);
		getContentPane().add(pinkButton3);
	}
	
	private void projectmaster(PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(680,120,230,60);
		getContentPane().add(pinkButton2);
	}
	
	private void projectmastername(PinkButton3 pinkButton3) {
		pinkButton3.setBounds(920,120,200,60);
		getContentPane().add(pinkButton3);
	}
	
	private void projectcheck(PinkButton4 pinkButton4) {
		pinkButton4.setBounds(1130,120,40,60);
		getContentPane().add(pinkButton4);
	}
	
	private void projectteam(PinkButtonPanelteam jpanel) {
		jpanel.setBounds(10,190,520,360);
		getContentPane().add(jpanel);
	}
	
	private void projectarrow(PinkIconarrow pinkButton2) {
		pinkButton2.setBounds(545,305,90,90);
		getContentPane().add(pinkButton2);
	}
	
	private void projectteam2(JPanel jpanel) {
		jpanel.setBounds(635,190,540,360);
		getContentPane().add(jpanel);
	}
	
	private void projectteamsearch(SearchTextField searchtextfield) {
		searchtextfield.setBounds(20,200,500,30);
		getContentPane().add(searchtextfield);
	}
	
	private void projectsearchpictures(PinkIconsearch pinkButton2) {
		pinkButton2.setBounds(490,203,25,25);
		getContentPane().add(pinkButton2);
	}
	

}
