package oneandall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customComponent.PinkButton;
import customComponent.PinkIconButton;
import customComponent.PinkLabel;

public class ProjectOptionPanel extends JPanel {
	
	public ProjectOptionPanel() {
//		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		JPanel optionPanel = new JPanel();
		optionPanel.setSize(new Dimension(300, 500));
		optionPanel.setOpaque(false);
		optionPanel.setBackground(new Color(0, 0, 0, 0));
		
		JPanel optionBtns = new JPanel();
		optionBtns.setLayout(new GridLayout(0, 1, 0, 5));
		optionBtns.setOpaque(false);
		
		JButton searchCoworker = new PinkIconButton(new File("src\\images\\someoneButton.png"));
		searchCoworker.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(searchCoworker);
		
		JButton taskFilter = new PinkIconButton(new File("src\\images\\listFilteringButton.png"));
		taskFilter.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(taskFilter);
		
		JButton taskLink = new PinkIconButton(new File("src\\images\\linkOptionButton.png"));
		taskLink.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(taskLink);
		
		JButton orderOption = new PinkIconButton(new File("src\\images\\sortTaskButton.png"));
		orderOption.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(orderOption);
		
		JPanel optionExp = new JPanel();
		optionExp.setLayout(new GridLayout(0, 1, 0, 5));
		optionExp.setOpaque(false);
		
		JLabel scLabel = new PinkLabel("특정 팀원만 볼래요");
		scLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(scLabel);
		
		JLabel tfLabel = new PinkLabel("필터(전체)");
		tfLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(tfLabel);
		
		JLabel tlLabel = new PinkLabel("다른 미션으로 링크하기");
		tlLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(tlLabel);
		
		JLabel ooLabel = new PinkLabel("정렬(마감별)");
		ooLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(ooLabel);
		
//		optionPanel.add(optionBtns);
//		optionPanel.add(optionExp);
		add(optionBtns);
		add(optionExp);
		//add(optionPanel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new ProjectOptionPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
