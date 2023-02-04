package oneandall;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class P_SearchTextField extends JTextField{
	
	public P_SearchTextField() {
        super();
        decorate();
        
	}
    public P_SearchTextField(String string) {
		setText(string);
		decorate();
	}
	protected void decorate() {
    	setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(new Color(255, 198, 218));
        graphics.fillRoundRect(2, 2, width, height, 10, 10);
        graphics.setColor(new Color(255, 255, 255));
        graphics.drawRoundRect(2, 1, width-3, height-2, 10, 10);
//        graphics.setColor(Color.white);
//        setBorder(BorderFactory.createLineBorder(Color.white,20));
//        graphics.setStroke(new BasicStroke(100,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        graphics.setColor(getForeground());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

//        super.paintComponent(g);
    }
	
    

}
