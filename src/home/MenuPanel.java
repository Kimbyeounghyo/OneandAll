package home;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import customComponent.PinkButton;

public class MenuPanel extends JPanel {
	
	List<JButton> btnList;
	
	public MenuPanel() {
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 255));
		setLayout(new GridLayout(1, 4, 5, 0));
		
		//버튼 생성 및 list에 버튼 추가
		btnList = new ArrayList<>();
		btnList.add(new PinkButton("로그인"));
		btnList.add(new PinkButton("팀원"));
		btnList.add(new PinkButton("프로젝트"));
		btnList.add(new PinkButton("스케줄"));
		
		//panel에 버튼 추가
		Iterator<JButton> ir = btnList.iterator();
		while(ir.hasNext()) {
			add(ir.next());
		}
		
	}

}
