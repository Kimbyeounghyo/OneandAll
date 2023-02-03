package customComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PinkPanel extends JPanel {
	
	Color buttonColor;

	public PinkPanel() {
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension d = getSize();
		//System.out.println(getText() + ", size : "+ getSize());
		g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
		
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		g2.dispose();
		super.paintComponent(g);
	}

}
