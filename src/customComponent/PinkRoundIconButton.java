package customComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PinkRoundIconButton extends JButton {
	
	Color buttonColor;
	File imageFile;

	public PinkRoundIconButton() {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
	}
	public PinkRoundIconButton(String text) {
		setBorderPainted(false);
		setOpaque(false);
		
		buttonColor = new Color(255, 198, 218);
		setText(text);
	}
	public PinkRoundIconButton(File f) {
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
		//System.out.println(getText() + ", size : "+ getSize());
		int circleR = (int)d.getWidth() > (int)d.getHeight() ? (int)d.getHeight() : (int)d.getWidth(); 
		if(circleR == (int)d.getWidth()) 
			g2.fillOval(0, ((int)d.getHeight() - circleR) / 2, circleR, circleR);
		else
			g2.fillOval(((int)d.getWidth() - circleR) / 2, 0, circleR, circleR);
		
		try {
			BufferedImage image = ImageIO.read(imageFile);
			if(image != null) {
				if(circleR == (int)d.getWidth()) 
					g2.drawImage(image, 0, ((int)d.getHeight() - circleR) / 2, circleR, circleR, null);
				else
					g2.drawImage(image, ((int)d.getWidth() - circleR) / 2, 0, circleR, circleR, null);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		String[] comments = getText().split("\n");
		
		int cnt = 0;
		g2.setColor(getForeground()); //앞배경 색(폰트 색)
		for(String s : comments) {
			
			Rectangle stringBounds = fontMetrics.getStringBounds(s, g2).getBounds();
			
			int textX = ((int)d.getWidth() - stringBounds.width) / 2;
			int textY = (int)d.getHeight() / 2 
					- stringBounds.height * comments.length / 2
					+ stringBounds.height * cnt++
					+ fontMetrics.getAscent();
			
			//g2.setFont(getFont());
			g2.drawString(s, textX, textY);
		}
		
		g2.dispose();
		super.paintComponent(g);
	}

}
