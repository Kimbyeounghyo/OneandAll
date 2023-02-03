package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PinkButtonPanel extends JLabel{
	
	Color buttonColor;
	
	public PinkButtonPanel() {
		setOpaque(false);
		
		buttonColor=new Color(255, 198, 218);
	}
	
	 public PinkButtonPanel(String text) {
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
		setText(text);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension d = getSize();
		System.out.println(getText() + ", size : "+ getSize());
		g2.setColor(buttonColor);
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		FontMetrics fontMetrics = g2.getFontMetrics();

	    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), g2).getBounds();

	    int textX = ((int)d.getWidth() - stringBounds.width) / 2;
	    int textY = ((int)d.getHeight() - stringBounds.height) / 2 + fontMetrics.getAscent();
	   
	    g2.setColor(getForeground()); //앞배경 색(폰트 색)
	    g2.drawString(getText(), textX, textY);
	    g2.dispose();
	}
	

}
