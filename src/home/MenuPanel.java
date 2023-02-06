package home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import customComponent.PinkButton;

public class MenuPanel extends JPanel {
	
	List<JButton> btnList;
	
	public MenuPanel() {
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 255));
//		setLayout(new GridLayout(1, 4, 10, 0));
		setLayout(new FlowLayout());
		
		//버튼 생성 및 list에 버튼 추가
		btnList = new ArrayList<>();
		JButton home = new PinkButton("Home");
		home.setPreferredSize(new Dimension(200, 30));
		btnList.add(home);
		JButton member = new PinkButton("Member");
		member.setPreferredSize(new Dimension(200, 30));
		btnList.add(member);
		JButton project = new PinkButton("Project");
		project.setPreferredSize(new Dimension(200, 30));
		btnList.add(project);
		JButton schedule = new PinkButton("Schedule");
		schedule.setPreferredSize(new Dimension(200, 30));
		btnList.add(schedule);
		JButton login = new PinkButton("Login");
		login.setPreferredSize(new Dimension(200, 30));
		btnList.add(login);
		
		//panel에 버튼 추가
		Iterator<JButton> ir = btnList.iterator();
		setBorder(BorderFactory.createEmptyBorder(5, 35, 25, 5));
		while(ir.hasNext()) {
			add(ir.next());
		}
		
	}

}
