package customComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class RoundTextPane extends JTextPane {
	
	Color buttonColor;

	public RoundTextPane() {
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder());
		buttonColor = new Color(255, 122, 255);
		setComponentOrientation(ComponentOrientation.UNKNOWN);
	}
	public RoundTextPane(String text) {
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
		
		String[] comments = getText().split("\n");
		
		int cnt = 0;
		g2.setColor(getForeground()); //앞배경 색(폰트 색)
		
//		for(String s : comments) {
//			
//			Rectangle stringBounds = fontMetrics.getStringBounds(s, g2).getBounds();
//			
//			int textX = ((int)d.getWidth() - stringBounds.width) / 2;
//			int textY = (int)d.getHeight() / 2 
//					- stringBounds.height * comments.length / 2
//					+ stringBounds.height * cnt++
//					+ fontMetrics.getAscent();
//			
//			//g2.setFont(getFont());
//			g2.drawString(s, textX, textY);
//		}
		super.paintComponent(g);
		getCaret().paint(g2);
		
		
		g2.dispose();
	}

}
