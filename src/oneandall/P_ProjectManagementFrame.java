package oneandall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import customComponent.PinkButton;
import home.MenuPanel;

@SuppressWarnings("serial")
public class P_ProjectManagementFrame extends JFrame {
	
	public static JFrame frame;
	JPanel menu;
	JPanel content;
	P_Project targetProject;
	
	public P_ProjectManagementFrame(P_Project p) {
		
		frame = this;

		if(CPT_LoginInfo.authCheck(new String[] {"팀장", "부팀장"})) {
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			new _Home();
			dispose();
			return;
		}
		
		targetProject = p;
		
		setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		setLayout(null);
		
		getContentPane().setBackground(Color.BLACK);
		
		//----------------메뉴 Panel(로그인, 팀원, 프로젝트, 스케줄)-------------------------------
		menu = new _pMenu();
		menu.setBounds(0, 0, P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT / 10);
//		menu.setBorder(BorderFactory.createEmptyBorder(5,1,5,1));
		add(menu);
		//----------------메뉴 Panel 끝-----------------------------------------------------
		content = new P_ProjectManagementPanel(targetProject);
		content.setBounds(0, P_EnvironmentConfigure.PROJECT_HEIGHT / 10, P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT * 9 / 10 - 50);
		content.setBorder(BorderFactory.createEmptyBorder(0,1,5,1));
		content.setBackground(new Color(0, 0, 0));
		add(content);
		
		UI_PinkLabel timelabel = new UI_PinkLabel();
		timelabel.setOpaque(false);
		timelabel.setBounds(5, content.getHeight() + 70, P_EnvironmentConfigure.PROJECT_WIDTH - 10, 30);
		new Thread(new CPT_LoginInfo(timelabel)).start();
		add(timelabel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
