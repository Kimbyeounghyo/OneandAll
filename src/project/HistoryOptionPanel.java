package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customComponent.PinkButton;
import customComponent.PinkIconButton;
import customComponent.PinkLabel;
import util.EnvironmentConfigure;

public class HistoryOptionPanel extends JPanel {
	
	JButton compareTask;
	JButton taskFilter;
	JLabel compareTaskLabel;
	
	public HistoryOptionPanel() {
//		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		JPanel optionPanel = new JPanel();
		optionPanel.setSize(new Dimension(300, 500));
		optionPanel.setOpaque(false);
		optionPanel.setBackground(new Color(0, 0, 0, 0));
		
		JPanel optionBtns = new JPanel();
		optionBtns.setLayout(new GridLayout(0, 1, 0, 5));
		optionBtns.setOpaque(false);
		
		compareTask = new PinkIconButton(new File("src\\images\\compareButton.png"));
		compareTask.setPreferredSize(new Dimension(100, 90));
		
		optionBtns.add(compareTask);
		
		taskFilter = new PinkIconButton(new File("src\\images\\sortTaskButton.png"));
		taskFilter.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(taskFilter);
		
		JPanel optionExp = new JPanel();
		optionExp.setLayout(new GridLayout(0, 1, 0, 5));
		optionExp.setOpaque(false);
		
		compareTaskLabel = new PinkLabel("업무비교");
		compareTaskLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(compareTaskLabel);
		
		JLabel tfLabel = new PinkLabel("정렬순서 변경");
		tfLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(tfLabel);
		
//		optionPanel.add(optionBtns);
//		optionPanel.add(optionExp);
		add(optionBtns);
		add(optionExp);
		//add(optionPanel);
	}
	
	public JButton getCompareButton() {
		return compareTask;
	}
	public JLabel getCompareLabel() {
		return compareTaskLabel;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new HistoryOptionPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
