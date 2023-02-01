package project;

import java.awt.Color;
import java.awt.Dimension;

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
import util.CPTManager;
import util.EnvironmentConfigure;
import util.LoginInfo;

public class ProjectSelectFrame extends JFrame {
	
	public static JFrame frame;
	JPanel menu;
	JPanel content;
	
	public ProjectSelectFrame(String targetFrame) {
		
		frame = this;
		
		CPTManager.getFromOaaDB();
		
		setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		setLayout(null);

		getContentPane().setBackground(new Color(0, 0, 0, 255));
		
		//----------------메뉴 Panel(로그인, 팀원, 프로젝트, 스케줄)-------------------------------
		menu = new MenuPanel();
		menu.setBounds(0, 0, EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT / 10);
		menu.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
		add(menu);
		//----------------메뉴 Panel 끝-----------------------------------------------------
		//----------------선택화면 Panel 시작-------------------------------------------------
//		CPTManager.pList = null;
		if(LoginInfo.getCurrentProjects() == null) {
			
			content = new JPanel();
			content.setBackground(new Color(0, 0, 0, 255));
			content.setBounds(0, 
				EnvironmentConfigure.PROJECT_HEIGHT / 10, 
				EnvironmentConfigure.PROJECT_WIDTH, 
				EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
			content.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
			
			JButton noProjects = new PinkButton("참여중인 프로젝트가 없네요 ㅠoㅠ\n누르면 프로젝트 생성으로 이동시켜 드릴게요");
			noProjects.setPreferredSize(new Dimension(content.getWidth() - 10, content.getHeight() - 50));
			
			content.add(noProjects);
			add(content);
			
			JButton realtimeChat = new PinkButton("실시간 채팅");
			realtimeChat.setOpaque(false);
			realtimeChat.setBounds(5, content.getHeight() + 70, EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
			add(realtimeChat);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
			return;
		}
		
		content = new ProjectSelectPanel(targetFrame);
		content.setPreferredSize(new Dimension(1200, 200 * LoginInfo.getCurrentProjects().size()));
//		content.setPreferredSize(new Dimension(1200, 200));
		
		content.setBounds(0, 
				EnvironmentConfigure.PROJECT_HEIGHT / 10, 
				EnvironmentConfigure.PROJECT_WIDTH, 
				EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
		content.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
		content.setBackground(new Color(0, 0, 0, 255));
		JScrollPane scroll = new PinkScroll(content);
		scroll.setBounds(0, 
				EnvironmentConfigure.PROJECT_HEIGHT / 10, 
				EnvironmentConfigure.PROJECT_WIDTH, 
				EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
		
		scroll.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(scroll);
		
		JButton realtimeChat = new PinkButton("실시간 채팅");
		realtimeChat.setOpaque(false);
		realtimeChat.setBounds(5, content.getHeight() + 70, EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
		add(realtimeChat);

		//----------------선택화면 Panel 끝---------------------------------------------------
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
