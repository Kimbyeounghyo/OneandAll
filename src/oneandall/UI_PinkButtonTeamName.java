package oneandall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UI_PinkButtonTeamName extends JButton {
   	 
   	 public Color c1 = new Color(255, 235, 235);
   	 public Color c2 = new Color(255, 235, 235);
   	 Color current;
   	 
   	 public UI_PinkButtonTeamName(Color c1, Color c2) {
   		setBorderPainted(false);
		setOpaque(true);
	      setContentAreaFilled(false);

   		 this.c1 = c1;
   		 this.c2 = c2;
   		 this.current = c1;
   		 addActionListener(new ActionListener() {
   	   	 
   	   	 @Override
   	   	 public void actionPerformed(ActionEvent e) {
   	   		 if(current == c1) {
   	   			 current = c2;
   	   		 }else {
   	   			 current = c1;
   	   		 }
   			setOpaque(true);

   	   	 }
   	   	 
   	    });
   	 }
   	
   	 
   	 @Override
   	 protected void paintComponent(Graphics g) {
   		 Graphics2D g2 = (Graphics2D) g;
   			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   		
   			if(getModel().isArmed()) {
   				g2.setColor(current.darker());
   			}else if(getModel().isRollover()) {
   				g2.setColor(current.brighter());
   			}else {
   				g2.setColor(current);
   			}
   			
   			Dimension d = getSize();
   			//System.out.println(getText() + ", size : "+ getSize());
   			g2.fillRoundRect(0, 0, (int)d.getWidth(), (int)d.getHeight(), 10, 10);
   			
   			g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
   			FontMetrics fontMetrics = g2.getFontMetrics();
   		    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), g2).getBounds();

   		    int textX = ((int)d.getWidth() - stringBounds.width) / 2;
   		    int textY = ((int)d.getHeight() - stringBounds.height) / 2 + fontMetrics.getAscent();

   		
   		    g2.setColor(getForeground()); //앞배경 색(폰트 색)
   		    //g2.setFont(getFont());
   		    g2.drawString(getText(), textX, textY);
   		    
   		    setBorderPainted(false);
   	        setOpaque(true);
   	       g2.dispose();

   	      super.paintComponent(g);

//   	        setVisible(true);
   	  } 
}
    
	
