package panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.PinkButton;
import ui.PinkIconButton;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	public MenuPanel() {
		
		setBackground(new Color(0, 0, 0));
		//setLayout(new GridLayout(1, 4, 10, 0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		/*
		JPanel wMenu = new JPanel();
		wMenu.setBackground(new Color(0, 0, 0));
		wMenu.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(wMenu);
		
		wMenu.add(new PinkIconButton());
		wMenu.add(new PinkIconButton());
		wMenu.add(new PinkIconButton());
		wMenu.add(new PinkIconButton());
		*/
		
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(0, 0, 0));
		pMenu.setLayout(new GridLayout(1, 4, 10, 0));
		add(pMenu);
		
		pMenu.add(new PinkButton("Login"));
		pMenu.add(new PinkButton("Member"));
		pMenu.add(new PinkButton("Project"));
		pMenu.add(new PinkButton("Schedule"));
		
		
		
	}

}
