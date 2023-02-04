package oneandall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import customComponent.PinkButton;
import customComponent.PinkIconButton;
import customComponent.PinkLabel;
import oneandall.P_EnvironmentConfigure;
import oneandall.P_ProjectHistoryPanel;
import oneandall.P_Task;
import oneandall.CPT_CPTManager;

public class P_HistoryOptionPanel extends JPanel {
	
	JButton compareTask;
	JButton taskFilter;
	JLabel compareTaskLabel;
	
	int flag = 11;
	
	public P_HistoryOptionPanel() {
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
		taskFilter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String funcName = taskFilter.getText();
				
				P_ProjectHistoryPanel php = ((P_ProjectHistoryPanel)getParent());
				
				if(funcName.equals("정렬(마감순)")) {
					taskFilter.setText("정렬(생성순)");
					flag = flag / 10 * 10 + 1;
				}else if(funcName.equals("정렬(생성순)")){
					taskFilter.setText("정렬(마감순)");
					flag = flag / 10 * 10 + 2;
				}
				
				refreshTask(php);
			}
		});
		optionBtns.add(taskFilter);
		
		JPanel optionExp = new JPanel();
		optionExp.setLayout(new GridLayout(0, 1, 0, 5));
		optionExp.setOpaque(false);
		
		compareTaskLabel = new PinkLabel("업무비교");
		compareTaskLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(compareTaskLabel);
		
		JLabel tfLabel = new PinkLabel("정렬(마감순)");
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
	
	public void refreshTask(P_ProjectHistoryPanel php) {
		//System.out.println("flag >>> : " + flag);
		List<P_Task> ctl = CPT_CPTManager.getTasksFromProject(php.currentProject);
		if(ctl == null) {
			JOptionPane.showMessageDialog(null, "업무정보가 없습니다");
			return;
		}
		
		switch(flag % 10) {
		case 1:
			ctl = ctl.stream()
				.sorted(Comparator.comparing(P_Task::getEndDate).reversed())
				.collect(Collectors.toList());
		case 2:
			ctl = ctl.stream()
				.sorted(Comparator.comparing(P_Task::getStartDate))
				.collect(Collectors.toList());	
		}
		
		php.setTaskListToShow(ctl);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new P_HistoryOptionPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
