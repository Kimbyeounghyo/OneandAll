package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PinkIconButtonMain extends JFrame {
	
	public PinkIconButtonMain() {
		setTitle("핑크버튼 테스트");
		
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		setSize(800, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		
		JButton button = new PinkIconButton();
		button.setBounds(200,200,200,100);
		add(button);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

	public static void main(String[] args) {
		
		new PinkIconButtonMain();

	}

}
