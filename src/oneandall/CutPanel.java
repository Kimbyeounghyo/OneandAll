package oneandall;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.PinkButton;

public class CutPanel extends JPanel {
	
	public CutPanel() {
		
		setBackground(new Color(0, 0, 0));
		setLayout(new GridLayout(1, 2, 0, 0));
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JButton b1 = new PinkButton("��ư1");
		add(b1);
		JButton b2 = new PinkButton("��ư2");
		add(b2);
	}

}
