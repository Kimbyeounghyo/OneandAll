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

public class UI_RoundJTextFieldExWhite extends JTextField{
	
	public UI_RoundJTextFieldExWhite() {
        super();
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);
        setHorizontalAlignment(JTextField.CENTER);
        
	}
    public UI_RoundJTextFieldExWhite(String string) {
    	setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		setText(string);
	}
	protected void decorate() {
    	
    }
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRoundRect(0, 0, width, height, 10, 10);
        graphics.setColor(getForeground());
        graphics.drawString(getText(), textX, textY);
        getCaret().paint(graphics);
        graphics.dispose();

//        super.paintComponent(g);
    }
	

}
