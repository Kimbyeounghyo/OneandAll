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
public class UI_PinkButton3 extends JButton {
	
	Color buttonColor;

	public UI_PinkButton3() {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 255, 255);
	}
	public UI_PinkButton3(String text) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 255, 255);
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
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		String[] comments = getText().split("\n");
		g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));  
		FontMetrics fontMetrics = g2.getFontMetrics();

		int cnt = 0;
		g2.setColor(getForeground()); // 앞배경 색(폰트 색)
		for (String s : comments) {

			Rectangle stringBounds = fontMetrics.getStringBounds(s, g2).getBounds();

			int textX = ((int) d.getWidth() - stringBounds.width) / 2;
			int textY = (int) d.getHeight() / 2 - stringBounds.height * comments.length / 2
					+ stringBounds.height * cnt++ + fontMetrics.getAscent();

			// g2.setFont(getFont());
			g2.drawString(s, textX, textY);
		}
	}
}
