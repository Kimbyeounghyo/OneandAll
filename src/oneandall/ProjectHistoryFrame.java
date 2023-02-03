package oneandall;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import customComponent.PinkButton;
import home.MenuPanel;

public class ProjectHistoryFrame extends JFrame {
	
	public static JFrame frame;
	JPanel menu;
	JPanel content;
	Project targetProject;
	
	public ProjectHistoryFrame(Project p) {
		frame = this;
		targetProject = p;
		
		setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		setLayout(null);
		
		getContentPane().setBackground(Color.BLACK);
		
		//----------------메뉴 Panel(로그인, 팀원, 프로젝트, 스케줄)-------------------------------
		menu = new MenuPanel();
		menu.setBounds(0, 0, EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT / 10);
		menu.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
		add(menu);
		//----------------메뉴 Panel 끝-----------------------------------------------------
		content = new ProjectHistoryPanel(targetProject);
		content.setBounds(0, EnvironmentConfigure.PROJECT_HEIGHT / 10, EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
		content.setBorder(BorderFactory.createEmptyBorder(-10,1,5,1));
		content.setBackground(new Color(0, 0, 0));
		add(content);
		
		JButton realtimeChat = new PinkButton("실시간 채팅");
		realtimeChat.setOpaque(false);
		realtimeChat.setBounds(5, content.getHeight() + 70, EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
		add(realtimeChat);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
