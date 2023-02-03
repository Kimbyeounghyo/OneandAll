package customComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PinkIconButton extends JButton {
	
	Color buttonColor;
	File imageFile;

	public PinkIconButton() {
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
		
		buttonColor = new Color(255, 198, 218);
	}
	public PinkIconButton(String text) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
		setText(text);
	}
	public PinkIconButton(File f) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
		imageFile = f;
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
		try {
			BufferedImage image = ImageIO.read(imageFile);
			int w = (int)d.getWidth();
			int h = (int)d.getHeight();
			if(image != null) g2.drawImage(image, 0, 0, w, h, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public File getImageFile() {
		return imageFile;
	}

}
