package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class PinkScroll extends JScrollPane {
	
	public PinkScroll(JComponent component) {
		super(component);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		setComponentZOrder(getVerticalScrollBar(), 0);
		setComponentZOrder(getViewport(), 1);
		getVerticalScrollBar().setOpaque(false);
		getViewport().setOpaque(false);
		
		setLayout(new ScrollPaneLayout() {
		    @Override public void layoutContainer(Container parent) {
		        JScrollPane scrollPane = (JScrollPane) parent;
	            
		        Rectangle availR = scrollPane.getBounds();
		        availR.x = availR.y = 0;
	            
		        Insets insets = parent.getInsets();
		        availR.x = insets.left;
		        availR.y = insets.top;
		        availR.width  -= insets.left + insets.right;
		        availR.height -= insets.top  + insets.bottom;
	            
		        Rectangle vsbR = new Rectangle();
		        vsbR.width  = 12;
		        vsbR.height = availR.height;
		        vsbR.x = availR.x + availR.width - vsbR.width;
		        vsbR.y = availR.y;
	            
		        if (viewport != null) {
		            viewport.setBounds(availR);
		        }
		        if (vsb != null) {
		            vsb.setVisible(true);
		            vsb.setBounds(vsbR);
		        }
		        
		    }
	    });
		
		getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		
			@Override
			protected JButton createDecreaseButton(int orientation) {
				JButton b = new JButton();
				b.setPreferredSize(new Dimension(0, 0));
				return b;
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {
				JButton b = new JButton();
				b.setPreferredSize(new Dimension(0, 0));
				return b;
			}

			@Override
			protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
				Graphics2D g2 = (Graphics2D) g;
				
				System.out.println("" + thumbBounds.x + thumbBounds.y + thumbBounds.width + 1 + thumbBounds.height + 1 + 20 + 20);
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setPaint(new Color(255, 198, 218, 150).darker());
				g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width - 1, thumbBounds.height - 1, 20, 20);
				g2.dispose();
			}
			
			@Override
			protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {}
			
			
		});
	}
	
	@Override public boolean isOptimizedDrawingEnabled() {
		return false; // JScrollBar is overlap
    }
	
}
