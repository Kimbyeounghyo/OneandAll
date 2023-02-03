package oneandall;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Projectarrangeexample extends JFrame{
	
	
	public Projectarrangeexample() {
		
		
		JPanel defaultPanel;
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
		
	      //top-------------------------------------------------
	      projectName(new RoundJTextFieldExPink("Project Name"));
			projectterm(new PinkButtonPanel("Term"));
			projectstart(new RoundJTextFieldExWhite("Start Date"));
			projecting(new PinkButtonPanel("~"));
		    projectfinish(new RoundJTextFieldExWhite("Finish Date"));
		    projectmaster(new PinkButtonPanel("Project master"));
			projectmastername(new PinkButton3("Master Name"));
			projectcheck(new PinkButton4("☑"));
			//bottom team1----------------------------------------
			JLayeredPane jlp= new JLayeredPane();
	         jlp.setBounds(0, 0, 1200, 600);
	         
	         JPanel pinkbuttonpanelteam=new JPanel()
	         {
	     		
	 			@Override
	 			protected void paintComponent(Graphics g) {
	 				int width = getWidth();
	 				int height = getHeight();
	 				Graphics2D graphics = (Graphics2D) g;
	 				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	 				graphics.setColor(new Color(255, 198, 218));
	 				graphics.fillRoundRect(0, 0, width, height, 10, 10);
	 				graphics.setColor(getForeground());
	 				graphics.dispose();
	 			}
	 	};
	         pinkbuttonpanelteam.setBackground(new Color(255, 198, 218));
	         pinkbuttonpanelteam.setBounds(10,190,520,360);
	         jlp.add(pinkbuttonpanelteam,JLayeredPane.DEFAULT_LAYER);

	         SearchTextField tf=new SearchTextField("팀원명");
	         tf.setBackground(new Color(255, 198, 218));
	         tf.setBounds(10,192,480,30);
	         jlp.add(tf,JLayeredPane.POPUP_LAYER);
	         
//	         String[] teamname = {"팀1", "팀2","팀3"};
//	         JComboBox<String> jComboBox =new JComboBox<>(teamname);
//	         jComboBox.setBackground(new Color(255,255,255));
//	         jComboBox.setForeground(Color.black);
//	         jComboBox.setBounds(10,192,480,30);
//	         jlp.add(jComboBox,JLayeredPane.PALETTE_LAYER);
	         
	         PinkIconsearch jb=new PinkIconsearch();
	         jb.setBounds(495,194,25,25);
	         jb.setBackground(new Color(255,255,255));
	         jlp.add(jb,JLayeredPane.POPUP_LAYER);
	         
	         //teampanel-scroll
	         JPanel pan=new JPanel(){
		     		
		 			@Override
		 			protected void paintComponent(Graphics g) {
		 				int width = getWidth();
		 				int height = getHeight();
		 				Graphics2D graphics = (Graphics2D) g;
		 				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		 				graphics.setColor(new Color(255, 198, 218));
		 				graphics.fillRoundRect(0, 0, width, height, 10, 10);
		 				graphics.setColor(getForeground());
		 				graphics.dispose();
		 			}
		 	};
	         pan.setBackground(new Color(255, 198, 218));
//	         pan.setBackground(new Color(255, 200, 200));
	         pan.setPreferredSize(new Dimension(200,1000));
//	         pan.setBounds(10,222,517,324);
	         
//	         JScrollPane js=new PinkScroll(pan) {
//	        		 @Override
//	                 public void setBorder(Border border) {
//	        		 }   
//	                 };
//	         js.setBounds(10,222,517,324);
//	         jlp.add(js,JLayeredPane.POPUP_LAYER);
//	         JScrollBar js=new JScrollBar();
	        
//	         js.setBounds(10,222,517,324);
//	         js.setLocation(10, 222);
//	         pan.add(js);
//	         js.add(pan);
	         
	         //------------------------기능 팀이름-----------------------------------
	         
//	         JPanel teamname=new JPanel() {
//	        	 @Override
//	        	 protected void paintComponent(Graphics g) {
//	        		 Graphics2D g2 = (Graphics2D) g;
//	        			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	        			
//	        			
//	        			
//	        			Dimension d = getSize();
//	        			//System.out.println(getText() + ", size : "+ getSize());
//	        			g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
//	        		   
//	        		    
//
//	        		    g2.setColor(new Color(255, 255, 255)); //앞배경 색(폰트 색)
//	        		    //g2.setFont(getFont());
//	        		    
//	        		    
//	        		   
//	        	        setOpaque(true);
//	        	 }
//	         } ;
//	         teamname.setBounds(10,222,25,25);
//	         teamname.setPreferredSize(new Dimension(0,30));
//	         teamname.setBackground(new Color(255, 255, 255));
//	         teamname.setLocation(10,0);
//	         pan.add(teamname);
//	         teamname.setOpaque(true);
	         
	         
	         //기능 이름체크
	         
	         PinkButtonTeamName pb=new PinkButtonTeamName(new Color(255, 235, 235), new Color(255,255,255));
	         /*JButton(){
	        	 
	        	 public Color c = new Color(255, 235, 235);
	        	 
	        	 @Override
	        	 protected void paintComponent(Graphics g) {
	        		 Graphics2D g2 = (Graphics2D) g;
	        			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        			
	        			if(getModel().isArmed()) {
	        				g2.setColor(c.darker());
	        			}else if(getModel().isRollover()) {
	        				g2.setColor(c.brighter());
	        			}else {
	        				g2.setColor(c);
	        			}
	        			
	        			Dimension d = getSize();
	        			//System.out.println(getText() + ", size : "+ getSize());
	        			g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
	        			
	        			g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	        			FontMetrics fontMetrics = g2.getFontMetrics();
	        		    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), g2).getBounds();

	        		    int textX = ((int)d.getWidth() - stringBounds.width) / 2;
	        		    int textY = ((int)d.getHeight() - stringBounds.height) / 2 + fontMetrics.getAscent();

	        		    g2.setColor(getForeground()); //앞배경 색(폰트 색)
	        		    //g2.setFont(getFont());
	        		    g2.drawString(getText(), textX, textY);
	        		    
	        		    setBorderPainted(false);
	        	        setOpaque(true);
	        	        } 
	        	 
	        	 public void setColor(Color c) {
	        		 this.c = c;
	        	 }
	         };*/
//	         setLayout(null);
	         pb.setBackground(new Color(255, 235, 235));
//	         pb.setSize(470, 30);
	         pb.setLocation(0, 0);
	         pb.setPreferredSize(new Dimension(470,30));
//	         pb.setBounds(10, 300, 300, 300);
	         pb.setOpaque(false);
	         pan.add(pb);
	         pb.setOpaque(true);
	   
	         //스크롤
	         JScrollPane scroll = new PinkScroll(pan) {
	        	 @Override
	        	 public void setBorder(Border border) {
	        	 }
	        	 
	         };
	         scroll.setBounds(10,230,520,310);
//	         scroll.setBackground(new Color(255, 198, 218));
	         jlp.add(scroll,JLayeredPane.POPUP_LAYER);
	         
	         
	         
	         getContentPane().add(jlp);
//	         getContentPane().add(scroll);
	         
//	         js.setVisible(true);
	         jlp.setVisible(true);
	         //arrow----------------------------------------------------------
	         projectarrow(new PinkIconarrow());
	         
	         //team2----------------------------------------------------------
	         JPanel pinkbuttonpanelteam2=new JPanel()
	         {
	     		
	 			@Override
	 			protected void paintComponent(Graphics g) {
	 				int width = getWidth();
	 				int height = getHeight();
	 				Graphics2D graphics = (Graphics2D) g;
	 				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	 				graphics.setColor(new Color(255, 198, 218));
	 				graphics.fillRoundRect(0, 0, width, height, 10, 10);
	 				graphics.setColor(getForeground());
	 				graphics.dispose();
	 			}
	 	};
	         pinkbuttonpanelteam2.setBackground(new Color(255, 198, 218));
	         pinkbuttonpanelteam2.setBounds(650,190,520,360);
	         jlp.add(pinkbuttonpanelteam2,JLayeredPane.DEFAULT_LAYER);
	         
			
			
	      //size-----------------------------------------------
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
	
	private void projectarrow(PinkIconarrow pinkButton2) {
		pinkButton2.setBounds(545,305,90,90);
		getContentPane().add(pinkButton2);
	}
	
	public static void main(String[] args) {
		new Projectarrangeexample();
	}
}
