package OneAndAllSample.src.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextFieldEx extends JFrame {
	
	JTextFieldEx() {
		
		setSize(1200, 600);
		setBackground(Color.BLACK);
		setLayout(null);
		
       JTextField tef=new RoundJTextFieldExPink();
       tef.setBounds(10,50,1164,50);
       tef.setBackground(new Color(255, 198, 218));
       Container c=getContentPane();
       //c.setLayout(new FlowLayout());
       tef.setText("프로젝트 이름");
       tef.setHorizontalAlignment(JTextField.CENTER);
       c.add(tef);
       
       add(tef);
       
       setVisible(true);
      
	}
	

	public static void main(String [] args) {
		new JTextFieldEx();
	}
}