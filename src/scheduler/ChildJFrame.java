package scheduler;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.CutPanel;
import ui.PinkButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildJFrame extends JFrame{
	
	JPanel defaultPanel;
	
	public ChildJFrame() {
		setTitle("OneAndAll");
		
		setContentPane(defaultPanel = new JPanel(null));
		getContentPane().setBackground(Color.BLACK);
		
		//Panel-------------s----------------------------------
		
		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 1189, 50);
		pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(pMenu);
		pMenu.setBackground(new Color(0, 0, 0));
		pMenu.setLayout(new GridLayout(1, 4, 10, 0));
		add(pMenu);
		
		JButton Schedule = new PinkButton("Schedule");
		
		pMenu.add(new PinkButton("Login"));
		pMenu.add(new PinkButton("Member"));
		pMenu.add(new PinkButton("Project"));
		pMenu.add(new PinkButton("Schedule"));
		
		
		
		
		//addMenu(new MenuPanel()); 위 코드를 주석처리면 해당코드를 사용한 것과 같다
		addContent(new CutPanel());
		
		
		
		//----------------------------------------------------
		
		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x踰꾪듉
		
		//-----------------------------------------------------
		
	}
	
	public void addMenu(JPanel panel) {
		panel.setBounds(0, 0, 1189, 50);
		getContentPane().add(panel);
	}
	public void addContent(JPanel panel) {
		panel.setBounds(0, 50, 1189, 513);
		getContentPane().add(panel);
	}

}
