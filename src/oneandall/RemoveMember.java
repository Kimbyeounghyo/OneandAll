package oneandall;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import customComponent.PinkLabel;

public class RemoveMember extends JFrame {
	public RemoveMember() {

		setTitle("One and All");
		setSize(1200, 600);
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
		pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행4열에 10공백
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
	      

		// 전체패널
		JPanel Pn1 = new JPanel();
		Pn1.setBounds(0, 50, 1200, 1200);
		Pn1.setBackground(Color.black);
		Pn1.setLayout(null);
		
		// 화살표 버튼
		ImageIcon arrowImg = new ImageIcon("arrow-right-6-64.png");
		ImageIcon arrowChange = new ImageIcon("wh-arrow-right-6-64.png");
		
		JButton ImgBtn = new JButton(arrowImg);
		ImgBtn.setBounds(570, 210, 64, 64);
		ImgBtn.setBorderPainted(false);
		ImgBtn.setContentAreaFilled(false);
		ImgBtn.setFocusPainted(false);		
		ImgBtn.setRolloverIcon(arrowChange);
		
		ImgBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));
				JOptionPane.showConfirmDialog(null, "수정 사항을 저장하시겠습니까?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
			}
			
		});

		// 왼쪽안쪽패널
		JPanel PlefIn = new JPanel();
		PlefIn.setBounds(50, 20, 500, 430);
		PlefIn.setBackground(new Color(255, 198, 218));
		PlefIn.setLayout(null);

		// 왼쪽안쪽패널 -> 상단버튼
		JPanel pL = new JPanel();
		pL.setBounds(50, 20, 500, 40);
		pL.setBackground(Color.BLACK);
		pL.setLayout(new GridLayout(1, 3, 5, 0));
		pL.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 0));
		
		var btL1 = new PinkLabel("List");
		btL1.setBackground(new Color(255, 198, 218));
		//btL1.setBorderPainted(false);

		JLabel btL2 = new JLabel();
		btL2.setBackground(Color.BLACK);
		
		JLabel btL3 = new JLabel();
		btL3.setBackground(Color.BLACK);

		pL.add(btL1);
		pL.add(btL2);
		pL.add(btL3);

		// 채팅패널
		JPanel Pchat = new JPanel();
		Pchat.setBounds(50, 475, 1100, 30);
		Pchat.setBackground(new Color(255, 198, 218));
		Pchat.setLayout(null);

		// 오른쪽안쪽패널
		JPanel PrgIn = new JPanel();
		PrgIn.setBounds(650, 20, 500, 430);
		PrgIn.setBackground(new Color(255, 198, 218));
		PrgIn.setLayout(null);		
		
		//지우기
				
		
		// 오른쪽안쪽패널 > 상단 버튼
		JPanel pR = new JPanel();
		pR.setBounds(650, 20, 500, 40);
		pR.setBackground(Color.black);
		pR.setLayout(new GridLayout(1, 3, 5, 0));
		pR.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 0));
		// Add 버튼
		 var btAdd = new PinkButton("Member");
		btAdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new AddMember();
			}		
		});		
		// Remove 버튼
		var btRemove = new PinkButton("Remove");
		btRemove.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new RemoveMember();
			}			
		});		
		// Modify 버튼
		var btModify = new PinkButton("Modify");
		btModify.setBackground(new Color(255, 198, 218));
		btModify.setBorderPainted(false);
		btModify.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new ModifyMember();
			}		
		});	

		Pn1.add(ImgBtn);
		Pn1.add(pR);
		Pn1.add(pL);

		pR.add(btAdd);
		pR.add(btRemove);
		pR.add(btModify);

		Pn1.add(PrgIn);
		Pn1.add(PlefIn);
		Pn1.add(Pchat);
		add(Pn1);

		setVisible(true);
	}//RemoveMember()
	
	public static void main(String[] args) {
		new RemoveMember();
	}
}//c

