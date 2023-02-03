package project;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PinkButtonPanelteam extends JPanel{
	
	Color buttonColor;
	
	public PinkButtonPanelteam() {
		setOpaque(false);
		
		buttonColor=new Color(255, 198, 218);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension d = getSize();
		System.out.println(getSize());
		
		g2.setColor(buttonColor);
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
	

	   
	  
		setOpaque(false);

	    g2.dispose();
	}



}
