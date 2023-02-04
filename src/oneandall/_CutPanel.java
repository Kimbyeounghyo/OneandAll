package oneandall;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class _CutPanel extends JPanel {
	
	public _CutPanel() {
	
		setBackground(new Color(0, 0, 0));
		setLayout(new GridLayout(1, 2, 0, 0));
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JButton b1 = new UI_PinkButton("��ư1");
		add(b1);
		JButton b2 = new UI_PinkButton("��ư2");
		add(b2);
	}
}
