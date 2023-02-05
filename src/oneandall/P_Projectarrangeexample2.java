package oneandall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class P_Projectarrangeexample2 extends JFrame{
   
	P_Project currentProject;
	List<CPT_Coworker> clNoneJoin;
	List<CPT_Coworker> clShowed;
	List<CPT_Coworker> clSelected;
	List<CPT_Coworker> clJoin;
	
	UI_PinkPanel leftPanel;
	UI_PinkPanel rightPanel;
	
	boolean findClicked = false;
	
	P_SearchTextField tf;
	
   	public P_Projectarrangeexample2(P_Project p) {
   		
   		currentProject = p;
   		clJoin = currentProject.workers.stream().filter(c -> !c.grade.equals("팀장"))
   				.collect(Collectors.toList());
      
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
		pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행4열에 10공백
		add(pMenu);

		var home = new UI_PinkButton("Home");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				new _Home();
				new _OneandAll_MainScreen();
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

		// top-------------------------------------------------
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		projectName(new UI_RoundJTextFieldExPink(p.name));
		projectterm(new UI_PinkButtonPanel("Term"));
		projectstart(new UI_RoundJTextFieldExWhite(sdf.format(p.startDate)));
		projecting(new UI_PinkButtonPanel("~"));
		projectfinish(new UI_RoundJTextFieldExWhite(sdf.format(p.endDate)));
		projectmaster(new UI_PinkButtonPanel("Project master"));
		
		String masterNameStr = "";
		for(CPT_Coworker c : p.workers) {
			if(c.grade.equals("팀장")) {
				masterNameStr = c.name;
				break;
			}
		}
		UI_RoundJTextFieldExWhite masterName = new UI_RoundJTextFieldExWhite(masterNameStr);
		masterName.setEnabled(false);
		projectmastername(masterName);
//		projectcheck(new UI_PinkButton4("☑"));
		// bottom team1----------------------------------------
		JPanel jlp = new JPanel();
		jlp.setOpaque(false);
		jlp.setLayout(null);
		jlp.setBackground(new Color(0, 0, 0, 0));
		jlp.setBounds(0, 0, 1200, 600);

		UI_PinkPanel pinkbuttonpanelteam = new UI_PinkPanel();
		pinkbuttonpanelteam.setLayout(null);
		pinkbuttonpanelteam.setBackground(new Color(255, 198, 218, 255));
		pinkbuttonpanelteam.setBounds(10, 190, 520, 360);
		jlp.add(pinkbuttonpanelteam);

		tf = new P_SearchTextField("팀원명 검색");
		tf.setBackground(new Color(255, 198, 218));
		tf.setBounds(0, 0, 480, 30);
		pinkbuttonpanelteam.add(tf);
		
		if(CPT_CPTManager.cList != null) {
			if(clNoneJoin == null) clNoneJoin = new ArrayList<CPT_Coworker>();
			
			for(CPT_Coworker c : CPT_CPTManager.cList) {
				if(!clNoneJoin.contains(c) && !c.grade.equals("팀장") && !clJoin.contains(c)) clNoneJoin.add(c);
			}
			
			clShowed = clNoneJoin;
			clSelected = new ArrayList<CPT_Coworker>();
		}
		UI_PinkIconsearch jb = new UI_PinkIconsearch();
		jb.setBounds(490, 2, 25, 25);
		jb.setBackground(new Color(255, 255, 255));
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.equals(""))
					findClicked = false;
				else
					findClicked = true;
				
				if(findClicked) {
					clShowed = clNoneJoin.stream().filter(c -> c.name.startsWith(tf.getText())).collect(Collectors.toList());
				}
				
				refreshButtons();
			}
		});
		pinkbuttonpanelteam.add(jb);

		// teampanel-scroll
		leftPanel = new UI_PinkPanel();
		leftPanel.setLayout(null);
//		pan.setPreferredSize(new Dimension(200, 1000));

		JScrollPane js = new UI_PinkScroll(leftPanel);
		js.setBounds(0, 30, 517, 324);
		js.setBorder(BorderFactory.createEmptyBorder());
		pinkbuttonpanelteam.add(js);

		// 기능 이름체크
		if(CPT_CPTManager.cList != null) {
			
			int cnt = 0;
			for(CPT_Coworker c : clShowed) {				
				UI_PinkButtonTeamName pb = new UI_PinkButtonTeamName(new Color(255, 255, 255, 255), new Color(255, 198, 218, 255), c);
				pb.setBorder(BorderFactory.createEmptyBorder());
				pb.setBackground(new Color(255, 235, 235));
				pb.setBounds(10, 10 + 35 * (cnt++), 500, 30);
				pb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (pb.current == pb.c1) {
							pb.current = pb.c2;
							clSelected.add(pb.worker);
						} else {
							pb.current = pb.c1;
							clSelected.remove(pb.worker);
						}
					}

				});
				leftPanel.add(pb);
			}
			leftPanel.setPreferredSize(new Dimension(200, clShowed.size()));
		}

		getContentPane().add(jlp);

		// arrow----------------------------------------------------------
		UI_PinkIconarrow pi = new UI_PinkIconarrow();
		pi.setBounds(545, 305, 90, 90);
		pi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				clShowed.removeAll(clSelected);
				clJoin.addAll(clSelected);
				currentProject.workers.addAll(clSelected);
				clNoneJoin.removeAll(clSelected);
				clSelected.removeAll(clSelected);
//				for(CPT_Coworker c : clShowed) {
//					clSelected.remove(c);
//					if(clShowed.contains(c)) clShowed.remove(c);
//					clJoin.add(c);
//					currentProject.workers.add(c);
//				}
				
				refreshButtons();
			}
		});
		jlp.add(pi);

		// team2----------------------------------------------------------
		UI_PinkPanel pinkbuttonpanelteam2 = new UI_PinkPanel();
		pinkbuttonpanelteam2.setLayout(null);
		pinkbuttonpanelteam2.setBounds(650, 190, 520, 360);
		jlp.add(pinkbuttonpanelteam2);
		
		P_SearchTextField tf2 = new P_SearchTextField("참여중인 팀원");
		tf2.setBackground(new Color(255, 198, 218));
		tf2.setBounds(0, 0, 518, 30);
		pinkbuttonpanelteam2.add(tf2);
		
		rightPanel = new UI_PinkPanel();
		rightPanel.setLayout(null);
		
		JScrollPane js2 = new UI_PinkScroll(rightPanel);
		js2.setBounds(0, 30, 517, 324);
		js2.setBorder(BorderFactory.createEmptyBorder());
		pinkbuttonpanelteam2.add(js2);
		
		int cnt = 0;
		for(CPT_Coworker c : clJoin) {
			UI_PinkButtonTeamName pb = new UI_PinkButtonTeamName(new Color(255, 255, 255, 255), new Color(255, 198, 218, 255), c);
			pb.setBorder(BorderFactory.createEmptyBorder());
			pb.setBackground(new Color(0, 0, 0, 255));
			pb.setBounds(10, 10 + 35 * (cnt++), 500, 30);
			pb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clNoneJoin.add(pb.worker);
					for(CPT_Coworker c : clJoin) {
						if(currentProject.workers.contains(c)) {
							currentProject.workers.remove(pb.worker);
						}
					}
					clJoin.remove(pb.worker);
					clNoneJoin = clNoneJoin.stream().sorted(Comparator.comparing(CPT_Coworker::getTag)).collect(Collectors.toList());
					refreshButtons();
				}
			});
			rightPanel.add(pb);
		}

		// size-----------------------------------------------
		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼
		addWindowListener(new WindowListenerSave());

	}

	private void projectName(UI_RoundJTextFieldExPink pinkButton2) {
		pinkButton2.setBounds(10, 50, 1164, 60);
		pinkButton2.setEnabled(false);
		getContentPane().add(pinkButton2);
	}

	private void projectterm(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(10, 120, 130, 60);
		getContentPane().add(pinkButton2);
	}

	private void projectstart(UI_RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(150, 120, 200, 60);
		pinkButton3.setEnabled(false);
		getContentPane().add(pinkButton3);
	}

	private void projecting(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(360, 120, 100, 60);
		getContentPane().add(pinkButton2);
	}

	private void projectfinish(UI_RoundJTextFieldExWhite pinkButton3) {
		pinkButton3.setBounds(470, 120, 200, 60);
		pinkButton3.setEnabled(false);
		getContentPane().add(pinkButton3);
	}

	private void projectmaster(UI_PinkButtonPanel pinkButton2) {
		pinkButton2.setBounds(680, 120, 230, 60);
		getContentPane().add(pinkButton2);
	}

	private void projectmastername(UI_RoundJTextFieldExWhite pinkButton3) {
//		pinkButton3.setBounds(920, 120, 200, 60);
		pinkButton3.setBounds(920, 120, 250, 60);
		getContentPane().add(pinkButton3);
	}

	private void projectcheck(UI_PinkButton4 pinkButton4) {
		pinkButton4.setBounds(1130, 120, 40, 60);
		getContentPane().add(pinkButton4);
	}

	private void projectarrow(UI_PinkIconarrow pinkButton2) {
		pinkButton2.setBounds(545, 305, 90, 90);
		getContentPane().add(pinkButton2);
	}
	
	private void refreshButtons() {
		System.out.println("nonjoin size >>> :: " + clNoneJoin.size());
		leftPanel.removeAll();
		rightPanel.removeAll();
		
		if(findClicked) {
			clShowed = clNoneJoin.stream().filter(c -> c.name.startsWith(tf.getText())).collect(Collectors.toList());
		}else {
			clShowed = clNoneJoin;
		}
		
		
		int cnt = 0;
		for(CPT_Coworker c : clShowed) {
			UI_PinkButtonTeamName pb = new UI_PinkButtonTeamName(new Color(255, 255, 255, 255), new Color(255, 198, 218, 255), c);
			if(clSelected.contains(c)) pb.current = pb.c2;
			pb.setBorder(BorderFactory.createEmptyBorder());
			pb.setBackground(new Color(255, 235, 235));
			pb.setBounds(10, 10 + 35 * (cnt++), 500, 30);
			pb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (pb.current == pb.c1) {
						pb.current = pb.c2;
						clSelected.add(pb.worker);
					} else {
						pb.current = pb.c1;
						clSelected.remove(pb.worker);
					}
				}
			});
			leftPanel.add(pb);
		}
		
		cnt = 0;
		for(CPT_Coworker c : clJoin) {
			UI_PinkButtonTeamName pb = new UI_PinkButtonTeamName(new Color(255, 255, 255, 255), new Color(255, 198, 218, 255), c);
			pb.setBorder(BorderFactory.createEmptyBorder());
			pb.setBackground(new Color(255, 235, 235));
			pb.setBounds(10, 10 + 35 * (cnt++), 500, 30);
			pb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clNoneJoin.add(pb.worker);
					for(CPT_Coworker c : clJoin) {
						if(currentProject.workers.contains(c)) {
							currentProject.workers.remove(pb.worker);
						}
					}
					clJoin.remove(pb.worker);
					clNoneJoin = clNoneJoin.stream().sorted(Comparator.comparing(CPT_Coworker::getTag)).collect(Collectors.toList());
					refreshButtons();
				}
			});
			rightPanel.add(pb);
		}
		
		leftPanel.repaint();
		rightPanel.repaint();
	}
}
