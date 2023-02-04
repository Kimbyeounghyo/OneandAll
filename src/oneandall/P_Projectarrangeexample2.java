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

public class P_Projectarrangeexample2 extends JFrame{
   
   
   public P_Projectarrangeexample2() {
      
      
      JPanel defaultPanel;
      setTitle("OneAndAll");
      
      setContentPane(defaultPanel = new JPanel(null));
      getContentPane().setBackground(Color.BLACK);
      
      //Panel-------------s----------------------------------
      
       JPanel pMenu = new JPanel();
         pMenu.setBounds(0, 0, P_EnvironmentConfigure.PROJECT_WIDTH, 50);
         pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         getContentPane().add(pMenu);
         pMenu.setBackground(new Color(0, 0, 0));
         pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
         add(pMenu);
         
        

         var home = new UI_PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mousePressed(MouseEvent e) {
					new _Home();
					}
			
		});
	      
	      var login = new UI_PinkButton("Login");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new _Login();
			}
		
	      });
	     
	      
	      
	      var member = new UI_PinkButton("Member");
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
	      
	      var project = new UI_PinkButton("Project");
	      project.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      
	      var schedule = new UI_PinkButton("Schedule");
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
         projectName(new UI_RoundJTextFieldExPink("Project Name"));
         projectterm(new UI_PinkButtonPanel("Term"));
         projectstart(new UI_RoundJTextFieldExWhite("Start Date"));
         projecting(new UI_PinkButtonPanel("~"));
          projectfinish(new UI_RoundJTextFieldExWhite("Finish Date"));
          projectmaster(new UI_PinkButtonPanel("Project master"));
         projectmastername(new UI_PinkButton3("Master Name"));
         projectcheck(new UI_PinkButton4("☑"));
         //bottom team1----------------------------------------
         JPanel jlp= new JPanel();
         jlp.setOpaque(false);
         jlp.setLayout(null);
         jlp.setBackground(new Color(0, 0, 0, 0));
         jlp.setBounds(0, 0, 1200, 600);
            
         UI_PinkPanel pinkbuttonpanelteam=new UI_PinkPanel();
         pinkbuttonpanelteam.setLayout(null);
         pinkbuttonpanelteam.setBackground(new Color(255, 198, 218, 255));
         pinkbuttonpanelteam.setBounds(10,190,520,360);
         jlp.add(pinkbuttonpanelteam);

         P_SearchTextField tf=new P_SearchTextField("팀원명");
         tf.setBackground(new Color(255, 198, 218));
         tf.setBounds(0,0,480,30);
         pinkbuttonpanelteam.add(tf);
            
            UI_PinkIconsearch jb=new UI_PinkIconsearch();
            jb.setBounds(490,2,25,25);
            jb.setBackground(new Color(255,255,255));
            pinkbuttonpanelteam.add(jb,JLayeredPane.POPUP_LAYER);
            
            //teampanel-scroll
         UI_PinkPanel pan=new UI_PinkPanel();
         pan.setLayout(null);
         pan.setPreferredSize(new Dimension(200,1000));
            
         JScrollPane js=new UI_PinkScroll(pan);
        js.setBounds(0,30,517,324);
        js.setBorder(BorderFactory.createEmptyBorder());
        pinkbuttonpanelteam.add(js);
            
            
            //기능 이름체크
            
            UI_PinkButtonTeamName pb=new UI_PinkButtonTeamName(new Color(255, 255, 255), new Color(255,198,218));
            pb.setBackground(new Color(255, 235, 235));
//            pb.setPreferredSize(new Dimension(490,30));
            pb.setBounds(0, 10, 480, 30);
            pan.add(pb);
            
            
            
            getContentPane().add(jlp);
//            getContentPane().add(scroll);
            
            //arrow----------------------------------------------------------
//            projectarrow(new PinkIconarrow());
            UI_PinkIconarrow pi=new UI_PinkIconarrow();
            pi.setBounds(545,305,90,90);
            jlp.add(pi);
            
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
   private void projectName(UI_RoundJTextFieldExPink pinkButton2) {
      pinkButton2.setBounds(10,50,1164,60);
      getContentPane().add(pinkButton2);
   }
   
   private void projectterm(UI_PinkButtonPanel pinkButton2) {
      pinkButton2.setBounds(10,120,130,60);
      getContentPane().add(pinkButton2);
   }
   
   private void projectstart(UI_RoundJTextFieldExWhite pinkButton3) {
      pinkButton3.setBounds(150,120,200,60);
      getContentPane().add(pinkButton3);
   }
   
   private void projecting(UI_PinkButtonPanel pinkButton2) {
      pinkButton2.setBounds(360,120,100,60);
      getContentPane().add(pinkButton2);
   }
   
   private void projectfinish(UI_RoundJTextFieldExWhite pinkButton3) {
      pinkButton3.setBounds(470,120,200,60);
      getContentPane().add(pinkButton3);
   }
   
   private void projectmaster(UI_PinkButtonPanel pinkButton2) {
      pinkButton2.setBounds(680,120,230,60);
      getContentPane().add(pinkButton2);
   }
   
   private void projectmastername(UI_PinkButton3 pinkButton3) {
      pinkButton3.setBounds(920,120,200,60);
      getContentPane().add(pinkButton3);
   }
   
   private void projectcheck(UI_PinkButton4 pinkButton4) {
      pinkButton4.setBounds(1130,120,40,60);
      getContentPane().add(pinkButton4);
   }
   
   private void projectarrow(UI_PinkIconarrow pinkButton2) {
      pinkButton2.setBounds(545,305,90,90);
      getContentPane().add(pinkButton2);
   }
   
   public static void main(String[] args) {
      new P_Projectarrangeexample2();
   }
}
