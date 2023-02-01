package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class GreenButton extends JButton {
	
	Color buttonColor;

	public GreenButton() {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(153, 255, 102);
	}
	public GreenButton(String text) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(153, 255, 102);
		setText(text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(getModel().isArmed()) {//누르고 잇을때
			g2.setColor(buttonColor.darker());
		}else if(getModel().isRollover()) {
			g2.setColor(buttonColor.brighter());
		}else {
			g2.setColor(buttonColor);
		}
		
		Dimension d = getSize();
		//System.out.println(getText() + ", size : "+ getSize());
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		String[] comments = getText().split("\n");
		
		int cnt = 0;
		g2.setColor(getForeground()); //앞배경 색(폰트 색)
		for(String s : comments) {
			
			Rectangle stringBounds = fontMetrics.getStringBounds(s, g2).getBounds();
			
			int textX = ((int)d.getWidth() - stringBounds.width) / 2;
			int textY = (int)d.getHeight() / 2 
					- stringBounds.height * comments.length / 2
					+ stringBounds.height * cnt++
					+ fontMetrics.getAscent();
			
			//g2.setFont(getFont());
			g2.drawString(s, textX, textY);
		}
		
		g2.dispose();
		super.paintComponent(g);
	}

}
