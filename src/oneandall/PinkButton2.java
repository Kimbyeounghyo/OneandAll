package oneandall;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PinkButton2 extends JButton {
	
	Color buttonColor;

	public PinkButton2() {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
	}
	public PinkButton2(String text) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
		setText(text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(getModel().isArmed()) {
			g2.setColor(buttonColor.darker());
		}else if(getModel().isRollover()) {
			g2.setColor(buttonColor.brighter());
		}else {
			g2.setColor(buttonColor);
		}
		
		Dimension d = getSize();
		System.out.println(getText() + ", size : "+ getSize());
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		FontMetrics fontMetrics = g2.getFontMetrics();
	    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), g2).getBounds();

	    int textX = ((int)d.getWidth() - stringBounds.width) / 2;
	    int textY = ((int)d.getHeight() - stringBounds.height) / 2 + fontMetrics.getAscent();

	    g2.setColor(getForeground()); //앞배경 색(폰트 색)
	    //g2.setFont(getFont());
	    g2.drawString(getText(), textX, textY);
	    g2.dispose();
		
		super.paintComponent(g);
	}
	
	
	

}
