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

import oneandall.CPT_Coworker;


public class P_ProjectOptionPanel extends JPanel {
	
	public JPanel panel;
	public int flag = 11;
	JLabel scLabel;
	JLabel tfLabel;
	JLabel tlLabel;
	JLabel ooLabel;
	
	CPT_Coworker performer;
	
	public P_ProjectOptionPanel() {
		
		panel = this;
		
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
		
		JButton searchCoworker = new UI_PinkIconButton(new File("src\\images\\someoneButton.png"));
		searchCoworker.setPreferredSize(new Dimension(100, 90));
		searchCoworker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		optionBtns.add(searchCoworker);
		
		
		JButton taskFilter = new UI_PinkIconButton(new File("src\\images\\listFilteringButton.png"));
		taskFilter.setPreferredSize(new Dimension(100, 90));
		taskFilter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String funcName = tfLabel.getText();
				
				P_ProjectManagementPanel pmp = ((P_ProjectManagementPanel)getParent());
				
				if(funcName.equals("필터(전체)")) {
					tfLabel.setText("필터(진행중)");
					flag = 10 + flag % 10;
				}else if(funcName.equals("필터(진행중)")){
					tfLabel.setText("필터(마감)");
					flag = 20 + flag % 10;
				}else if(funcName.equals("필터(마감)")){
					tfLabel.setText("필터(전체)");
					flag = 30 + flag % 10;
				}
				
				refreshTask(pmp);
			}
		});
		optionBtns.add(taskFilter);
		
		JButton taskLink = new UI_PinkIconButton(new File("src\\images\\linkOptionButton.png"));
		taskLink.setPreferredSize(new Dimension(100, 90));
		optionBtns.add(taskLink);
		
		JButton orderOption = new UI_PinkIconButton(new File("src\\images\\sortTaskButton.png"));
		orderOption.setPreferredSize(new Dimension(100, 90));
		orderOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String funcName = ooLabel.getText();
				
				P_ProjectManagementPanel pmp = ((P_ProjectManagementPanel)getParent());
				
				if(funcName.equals("정렬(마감순)")) {
					ooLabel.setText("정렬(생성순)");
					flag = flag / 10 * 10 + 1;
				}else if(funcName.equals("정렬(생성순)")){
					ooLabel.setText("정렬(마감순)");
					flag = flag / 10 * 10 + 2;
				}
				
				refreshTask(pmp);
			}
		});
		optionBtns.add(orderOption);
		
		JPanel optionExp = new JPanel();
		optionExp.setLayout(new GridLayout(0, 1, 0, 5));
		optionExp.setOpaque(false);
		
		scLabel = new UI_PinkLabel("특정 팀원만 볼래요");
		scLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(scLabel);
		
		tfLabel = new UI_PinkLabel("필터(전체)");
		tfLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(tfLabel);
		
		tlLabel = new UI_PinkLabel("다른 미션으로 링크하기");
		tlLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(tlLabel);
		
		ooLabel = new UI_PinkLabel("정렬(마감순)");
		ooLabel.setPreferredSize(new Dimension(150, 90));
		optionExp.add(ooLabel);
		
		add(optionBtns);
		add(optionExp);
	}
	
	public void refreshTask(P_ProjectManagementPanel pmp) {
		//System.out.println("flag >>> : " + flag);
		List<P_Task> ctl = CPT_CPTManager.getTasksFromProject(pmp.currentProject);
		if(ctl == null) {
			JOptionPane.showMessageDialog(null, "업무정보가 없습니다");
			return;
		}
		
		if(performer != null) {
			ctl = ctl.stream()
					.filter(t -> t.worker.equals(performer))
					.collect(Collectors.toList());
		}
		
		Date now = new Date();
		
		switch(flag / 10) {
		case 1:
			ctl = ctl.stream()
				.filter(t -> t.endDate.compareTo(now) > 0)
				.collect(Collectors.toList());
			break;
		case 2:
			ctl = ctl.stream()
				.filter(t -> t.endDate.compareTo(now) <= 0)
				.collect(Collectors.toList());
			break;
		case 3:
			break;
		}
		
		if(ctl == null) {
			JOptionPane.showMessageDialog(null, "업무정보가 없습니다");
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
		
		pmp.setTaskListToShow(ctl);
	}
	
	public void setCoworker(CPT_Coworker c) {
		performer = c;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new P_ProjectOptionPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
