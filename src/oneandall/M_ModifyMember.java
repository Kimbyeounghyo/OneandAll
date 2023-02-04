package oneandall;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customComponent.PinkLabel;

public class M_ModifyMember extends JFrame {
	public M_ModifyMember() {

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
	      pMenu.add(member);
	      pMenu.add(project);
	      pMenu.add(schedule);
	      pMenu.add(login);
	      
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

		Font font = new Font("맑은고딕", Font.BOLD, 20);
		JLabel lName = new JLabel("이름 수정");
		lName.setBounds(40, 65, 100, 40);
		lName.setFont(font);
		PrgIn.add(lName);

		JTextField tName = new JTextField(6);
		Font tfFont = new Font("함초롱바탕", Font.PLAIN, 18);
		tName.setBounds(40, 110, 120, 40);
		tName.setBackground(Color.LIGHT_GRAY);
		tName.setFont(tfFont);
		// tName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		PrgIn.add(tName);

		JLabel lGradeModify = new JLabel("직급 수정");
		lGradeModify.setBounds(40, 170, 100, 40);
		lGradeModify.setFont(font);
		PrgIn.add(lGradeModify);

		JPanel pRBtn = new JPanel();
		pRBtn.setBackground(new Color(255, 198, 218));
		pRBtn.setBounds(690, 240, 420, 40);
		pRBtn.setLayout(new GridLayout(1, 3, 25, 0));

		JButton bGrade1 = new JButton("팀장");
		bGrade1.setBackground(Color.WHITE);
		bGrade1.setBorderPainted(false);
		bGrade1.setFont(font);
		bGrade1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				JButton bGrade1 = (JButton) e.getSource();
				bGrade1.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton bGrade1 = (JButton) e.getSource();
				bGrade1.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton bGrade1 = (JButton) e.getSource();
				bGrade1.setBackground(Color.WHITE);
			}
		});

		JButton bGrade2 = new JButton("부팀장");
		bGrade2.setBackground(Color.WHITE);
		bGrade2.setBorderPainted(false);
		bGrade2.setFont(font);
		bGrade2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				JButton bGrade2 = (JButton) e.getSource();
				bGrade2.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton bGrade2 = (JButton) e.getSource();
				bGrade2.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton bGrade2 = (JButton) e.getSource();
				bGrade2.setBackground(Color.WHITE);
			}
		});

		JButton bGrade3 = new JButton("팀원");
		bGrade3.setBackground(Color.WHITE);
		bGrade3.setBorderPainted(false);
		bGrade3.setFont(font);
		bGrade3.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				JButton bGrade3 = (JButton) e.getSource();
				bGrade3.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton bGrade3 = (JButton) e.getSource();
				bGrade3.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton bGrade3 = (JButton) e.getSource();
				bGrade3.setBackground(Color.WHITE);
			}
		});

		JLabel lTel = new JLabel("전화번호 수정");
		lTel.setBounds(40, 280, 200, 40);
		lTel.setFont(font);
		PrgIn.add(lTel);

		JTextField tTel = new JTextField(16);
		tTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tTel.setBounds(40, 330, 260, 40);
		tTel.setFont(tfFont);
		tTel.setBackground(Color.LIGHT_GRAY);
		PrgIn.add(tTel);

		JButton saveBtn = new JButton("수정");
		saveBtn.setFont(font);
		saveBtn.setBackground(Color.WHITE);
		saveBtn.setBounds(380, 330, 80, 40);
		saveBtn.setBorderPainted(false);
		PrgIn.add(saveBtn);
		saveBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				JButton saveBtn = (JButton) e.getSource();
				saveBtn.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton saveBtn = (JButton) e.getSource();
				saveBtn.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton saveBtn = (JButton) e.getSource();
				saveBtn.setBackground(Color.WHITE);
			}
		});

		// 오른쪽안쪽패널 > 상단 버튼
		JPanel pR = new JPanel();
		pR.setBounds(650, 20, 500, 40);
		pR.setBackground(Color.black);
		pR.setLayout(new GridLayout(1, 3, 5, 0));
		pR.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 0));
		// Add 버튼
		 var btAdd = new UI_PinkButton("Member");
		btAdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new M_AddMember();
			}		
		});		
		// Remove 버튼
		var btRemove = new UI_PinkButton("Remove");
		btRemove.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new M_RemoveMember();
			}			
		});		
		// Modify 버튼
		var btModify = new UI_PinkButton("Modify");
		btModify.setBackground(new Color(255, 198, 218));
		btModify.setBorderPainted(false);
		btModify.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new M_ModifyMember();
			}		
		});	

		Pn1.add(ImgBtn);
		Pn1.add(pR);
		Pn1.add(pL);

		pR.add(btAdd);
		pR.add(btRemove);
		pR.add(btModify);

		pRBtn.add(bGrade1);
		pRBtn.add(bGrade2);
		pRBtn.add(bGrade3);
		Pn1.add(pRBtn);

		Pn1.add(PrgIn);
		Pn1.add(PlefIn);
		Pn1.add(Pchat);
		add(Pn1);

		setVisible(true);
	}// ModifyMember()

	public static void main(String[] args) {
		new M_ModifyMember();
	}
}// c
