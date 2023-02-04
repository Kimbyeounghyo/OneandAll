package oneandall;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class UI_RoundTextField extends JTextField {
	
	Color buttonColor;

	public UI_RoundTextField() {
		setOpaque(false);
		
		buttonColor = new Color(255, 255, 255);
		setHorizontalAlignment(JTextField.CENTER);
	}
	public UI_RoundTextField(String text) {
		setOpaque(false);
		
		buttonColor = new Color(255, 255, 255);
		setText(text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension d = getSize();
		//System.out.println(getText() + ", size : "+ getSize());
		g2.setColor(buttonColor);
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		g2.setColor(getForeground()); //앞배경 색(폰트 색)
		Rectangle stringBounds = fontMetrics.getStringBounds(getText(), g2).getBounds();
		
		int textX = ((int)d.getWidth() - stringBounds.width) / 2;
		int textY = (int)d.getHeight() / 2 - stringBounds.height / 2 + fontMetrics.getAscent();
		g2.drawString(getText(), textX, textY);
		
		getCaret().paint(g2);
		
		g2.dispose();
		
		super.paintComponent(g);
	}

}
