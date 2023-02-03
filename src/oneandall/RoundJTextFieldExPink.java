package oneandall;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class RoundJTextFieldExPink extends JTextField{
	
	public RoundJTextFieldExPink() {
        super();
        decorate();
        
	}
    public RoundJTextFieldExPink(String string) {
		setText(string);
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

//        if (getModel().isArmed()) {
//            graphics.setColor(getBackground().darker());
//        } else if (getModel().isRollover()) {
//            graphics.setColor(getBackground().brighter());
//        } else {
//            graphics.setColor(getBackground());
//        }

        
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(new Color(255, 198, 218));
        graphics.fillRoundRect(0, 0, width, height, 10, 10);
        graphics.setColor(getForeground());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

//        super.paintComponent(g);
    }
	

}
