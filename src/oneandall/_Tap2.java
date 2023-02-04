package oneandall;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _Tap2 extends JFrame{

		public _Tap2() {
			
			setTitle("One and All");
			setUndecorated(true);
			setLocationRelativeTo(null);
			setResizable(true);
			setBackground(Color.black);
			setLayout(null);
			setBounds(120, 200, 1200, 530);
			
			  JPanel pMenu2 = new JPanel();
		      pMenu2.setBounds(0, 0, 1200, 530);
		      pMenu2.setBackground(Color.black);
		      pMenu2.setLayout(null);
		     
		     JButton Membnt1 = new UI_PinkButton("팀원 관리");
		     Membnt1.setBounds(248, 40, 228, 30);
		     
		     Membnt1.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						new M_AddMember();
						dispose();
					}
			    	 
			    	 
				});
		     JButton Membnt2 = new UI_PinkButton("출퇴근 관리");
		     Membnt2.setBounds(248, 110, 228, 30);
		     
		     Membnt2.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						new M_CommuteManage();
						dispose();
					}
			    	 
			    	 
				});
		     JButton Membnt3 = new UI_PinkButton("휴가 관리");
		     Membnt3.setBounds(248, 180, 228, 30);
		     
		     Membnt3.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					new M_vacances();
					dispose();
				}
		    	 
		    	 
			});
		     
		     JButton ProBnt1 = new UI_PinkButton("프로젝트 생성");
		     ProBnt1.setBounds(486, 40, 228, 30);
		     
		     ProBnt1.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						P_EnvironmentConfigure.createFrame(new P_Projectcreate());
						dispose();
					}
			    	 
			    	 
				});
		     
		     JButton ProBnt2 = new UI_PinkButton("프로젝트 배치");
		     ProBnt2.setBounds(486, 110, 228, 30);
		     

		     ProBnt2.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						 new P_Projectarrangeexample2();
						dispose();
					}
			    	 
			    	 
				});
		     
		     JButton ProBnt3 = new UI_PinkButton("프로젝트 관리");
		     ProBnt3.setBounds(486, 180, 228, 30);
		     
		     ProBnt3.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						P_EnvironmentConfigure.createFrame(new P_ProjectSelectFrame("projectManagement"));
						dispose();
					}
			    	 
			    	 
				});
		     
		     JButton ProBnt4 = new UI_PinkButton("프로젝트 이력");
		     ProBnt4.setBounds(486, 250, 228, 30);

		     ProBnt4.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						P_EnvironmentConfigure.createFrame(new P_ProjectSelectFrame("projectHistory"));
						dispose();
					}
			    	 
			    	 
				});
		     
		     JButton SchBnt1 = new UI_PinkButton("팀 일정");
		     SchBnt1.setBounds(724, 40, 228, 30);
		     
		     SchBnt1.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						new CalendarGroup();
						dispose();
					}
			    	 
			    	 
				});
		     JButton SchBnt2 = new UI_PinkButton("개인 일정");
		     SchBnt2.setBounds(724, 110, 228, 30);
		     SchBnt2.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						new Calendarmain();
						dispose();
					}
			    	 
			    	 
				});
		     
		     JButton exitBnt = new UI_PinkButton("^");
		     exitBnt.setBounds(1150, 500, 30, 20);
		    
		     exitBnt.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {

				dispose();
					
				}
		    	 
			});
		
					
			
				
		     
		     
		     pMenu2.add(Membnt1);
		     pMenu2.add(Membnt2);
		     pMenu2.add(Membnt3);
		     pMenu2.add(ProBnt1);
		     pMenu2.add(ProBnt2);
		     pMenu2.add(ProBnt3);
		     pMenu2.add(ProBnt4);
		     pMenu2.add(SchBnt1);
		     pMenu2.add(SchBnt2);
		     pMenu2.add(exitBnt);
		     
		     add(pMenu2);
		 
		    setVisible(true);
		     
		     
		     
		      
		      
		}
	  public static void main(String[] args) {
		new _Tap2();
	}
     
	
}
