package oneandall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import customComponent.PinkButton;
import customComponent.PinkLabel;
import customComponent.PinkScroll;
import home.MenuPanel;

public class P_ProjectSelectFrame extends JFrame {
	
	public static JFrame frame;
	JPanel menu;
	JPanel content;
	
	public P_ProjectSelectFrame(String targetFrame) {
		
		frame = this;
		if(CPT_LoginInfo.loginUser == null) CPT_LoginInfo.goHome(this);
		setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		setLayout(null);

		getContentPane().setBackground(new Color(0, 0, 0, 255));
		
		//----------------메뉴 Panel(로그인, 팀원, 프로젝트, 스케줄)-------------------------------
		menu = new _pMenu();
		  menu.setBounds(0, 0, P_EnvironmentConfigure.PROJECT_WIDTH, 50);
	      menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(menu);
		//----------------메뉴 Panel 끝-----------------------------------------------------
		//----------------선택화면 Panel 시작-------------------------------------------------
//		CPTManager.pList = null;
		if(CPT_LoginInfo.getCurrentProjects() == null) {
			
			content = new JPanel();
			content.setBackground(new Color(0, 0, 0, 255));
			content.setBounds(0, 
				P_EnvironmentConfigure.PROJECT_HEIGHT / 10, 
				P_EnvironmentConfigure.PROJECT_WIDTH, 
				P_EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
			content.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
			
			String failMessage = "";
			switch(targetFrame) {
			case "projectManagement":
			case "projectArrange":
				failMessage = "참여중인 프로젝트가 없네요 ㅠoㅠ\n누르면 프로젝트 생성으로 이동시켜 드릴게요"; break;
			case "projectHistory":
				failMessage = "저장된 이력이 없네요 ㅠoㅠ\n많은 이용 부탁드려요"; break;
			}
			
			JButton noProjects = new PinkButton(failMessage);
			noProjects.setPreferredSize(new Dimension(content.getWidth() - 10, content.getHeight() - 50));
			if(targetFrame.equals("projectHistory")) {
				noProjects.setEnabled(false);
			}else {
				noProjects.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
						new P_Projectcreate();
						frame.dispose();
					}
				});
			}
			
			content.add(noProjects);
			add(content);
			
			JButton realtimeChat = new PinkButton("실시간 채팅");
			realtimeChat.setOpaque(false);
			realtimeChat.setBounds(5, content.getHeight() + 70, P_EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
			add(realtimeChat);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
			return;
		}
		
		content = new P_ProjectSelectPanel(targetFrame);
		content.setPreferredSize(new Dimension(P_EnvironmentConfigure.PROJECT_WIDTH - 10, 200 * CPT_LoginInfo.getCurrentProjects().size()));
		content.setBackground(new Color(0, 0, 0, 255));
		content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		JScrollPane scroll = new PinkScroll(content);
		scroll.setBounds(0, 
				P_EnvironmentConfigure.PROJECT_HEIGHT / 10, 
				P_EnvironmentConfigure.PROJECT_WIDTH, 
				Math.min(200 * CPT_LoginInfo.getCurrentProjects().size(), P_EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50));
		
		scroll.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		scroll.setBackground(new Color(0, 0, 0, 255));
		getContentPane().add(scroll);
		
		UI_PinkLabel timelabel = new UI_PinkLabel();
		timelabel.setBounds(5, P_EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 + 10, P_EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
		new Thread(new CPT_LoginInfo(timelabel)).start();
		add(timelabel);

		//----------------선택화면 Panel 끝---------------------------------------------------
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
