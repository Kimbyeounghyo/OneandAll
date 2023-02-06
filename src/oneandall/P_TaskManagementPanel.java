package oneandall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import customComponent.PinkButton;
import customComponent.PinkLabel;
import customComponent.PinkRoundButton;
import customComponent.PinkRoundIconButton;
import customComponent.PinkScroll;
import customComponent.RoundTextArea;
import customComponent.RoundTextField;
import oneandall.CPT_Coworker;
import oneandall.P_ProjectManagementPanel;
import oneandall.P_Task;


public class P_TaskManagementPanel extends JDesktopPane {
	
	JDesktopPane myPanel;
	JButton addTask;
	JButton showPriorTask;
	CPT_Coworker performer;
	List<P_Task> showedTasks;
	ListIterator<P_Task> irt = null;
	
	JTextField to;
	JTextField from;
	JTextField performerName;
	JTextArea performWhat;
	
	JButton nextBtn;
	JButton prevBtn;
	
	long currentTaskId;
	String recentButton;
	
	public P_TaskManagementPanel() {
		
		myPanel = this;
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		JPanel taskPanel = new JPanel(new FlowLayout());
//		taskPanel.setOpaque(false);
		taskPanel.setBackground(Color.BLACK);
		taskPanel.setBounds(50, 0, 800, 450);
		
		prevBtn = new PinkRoundButton("<");
		prevBtn.setPreferredSize(new Dimension(30, 100));
		prevBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(recentButton.equals("next")) {
					irt.previous();
					recentButton = "prev";
				}
				if(!irt.hasNext()) nextBtn.setText("|");
				else nextBtn.setText(">");
				if(!irt.hasPrevious()) prevBtn.setText("|");
				else prevBtn.setText("<");
				if(prevBtn.getText().equals("|")) {					
					return;
				}
				showTask(irt.previous());
			}
		});
		taskPanel.add(prevBtn, BorderLayout.WEST);
		
		JPanel taskContentPanel = new JPanel();
		taskContentPanel.setPreferredSize(new Dimension(675, 425));
		taskContentPanel.setLayout(new GridLayout(0, 1, 0, 10));
		taskContentPanel.setOpaque(false);
		
		JPanel shortPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		shortPanel.setBackground(Color.BLACK);
//		shortPanel.setPreferredSize(new Dimension(200, 200));
		JLabel deadlineLabel = new PinkLabel("기한");
		shortPanel.add(deadlineLabel);
		JPanel deadlinePanel = new JPanel(new FlowLayout());
		deadlinePanel.setBackground(Color.BLACK);
		from = new RoundTextField();
		from.setPreferredSize(new Dimension(272, 30));
		deadlinePanel.add(from);
		JLabel fromto = new PinkLabel("~");
		fromto.setPreferredSize(new Dimension(101, 30));
		deadlinePanel.add(fromto);
		to = new RoundTextField();
		to.setPreferredSize(new Dimension(272, 30));
		deadlinePanel.add(to);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		performerName = new RoundTextField();
		performerName.setFocusable(false);
		performerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				P_Project p = ((P_ProjectManagementPanel)getParent()).currentProject;
				P_EnvironmentConfigure.createFrame(new P_SelectWorkerFrame(p.workers, myPanel), 150, 300);
			}
		});
		shortPanel.add(performerName);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		taskContentPanel.add(shortPanel);//, BorderLayout.NORTH);
		
		performWhat = new RoundTextArea();
		JScrollPane scroll = new PinkScroll(performWhat);
		taskContentPanel.add(scroll);//, BorderLayout.CENTER);
		
		taskPanel.add(taskContentPanel, BorderLayout.CENTER);
		//-----------------------------------------------------------------------------
		
		nextBtn = new PinkRoundButton(">");
		nextBtn.setPreferredSize(new Dimension(30, 100));
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action next! >>> : " + recentButton);
				if(recentButton.equals("prev")) {
					irt.next();
					recentButton = "next";
				}
				if(!irt.hasNext()) nextBtn.setText("|");
				else nextBtn.setText(">");
				if(!irt.hasPrevious()) prevBtn.setText("|");
				else prevBtn.setText("<");
				if(nextBtn.getText().equals("|")) return;
				showTask(irt.next());
			}
		});
		taskPanel.add(nextBtn, BorderLayout.EAST);
		
		add(taskPanel, JDesktopPane.DEFAULT_LAYER);
		
		JPanel additionalBtns = new JPanel();
		additionalBtns.setOpaque(false);
		additionalBtns.setBackground(new Color(0, 0, 0, 0));
		additionalBtns.setLayout(new FlowLayout(FlowLayout.LEFT));
		additionalBtns.setBounds(120, 5, 400, 50);
		
		addTask = new PinkRoundIconButton(new File("src\\images\\pinkAddButton.png"));
		addTask.setToolTipText("해당 사람에게 일을 시켜요");
		addTask.setPreferredSize(new Dimension(30, 30));
		addTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date now = new java.util.Date();
				P_Task newTask = new P_Task();
				P_Project p = ((P_ProjectManagementPanel)getParent()).currentProject;
				newTask.projectName = p.name + "@" + p.projectId;
				try {
					newTask.startDate = sdf.parse(from.getText());
					newTask.endDate = sdf.parse(to.getText());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "날짜형식을 yyyy-mm-dd 로 설정해주세요");
					newTask.startDate = null;
					newTask.endDate = null;
					return;
				}
				
				if(performer == null) {
					JOptionPane.showMessageDialog(null, "누가 할지 모르겠어요");
					return;
				}
				if(performWhat.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "업무 내용을 입력해주세요");
					return;
				}
				newTask.worker = performer;
				newTask.content = performWhat.getText();
				
				
				if(CPT_CPTManager.tList == null) {
					CPT_CPTManager.tList = new ArrayList<P_Task>();
				}
				
				CPT_CPTManager.tList.add(newTask);
				
				JOptionPane.showMessageDialog(null, "해당 업무를 " + performerName.getText() + "에게 시켰어요");
				
				((P_ProjectManagementPanel)getParent()).requestRefresh();
			}
		});
		additionalBtns.add(addTask);
		
		JButton updateTaskBtn = new PinkRoundIconButton(new File("src\\images\\updateTaskButton.png"));
		updateTaskBtn.setToolTipText("업무 수정 버튼");
		updateTaskBtn.setPreferredSize(new Dimension(30, 30));
		updateTaskBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				P_Task aTask = CPT_CPTManager.findTaskById(currentTaskId);
				if(aTask == null) JOptionPane.showMessageDialog(null, "수정할 대상이 없어요");
				P_Project p = ((P_ProjectManagementPanel)getParent()).currentProject;
				aTask.projectName = p.name + "@" + p.projectId;
				try {
					aTask.startDate = sdf.parse(from.getText());
					aTask.endDate = sdf.parse(to.getText());
				} catch (ParseException e1) {
					aTask.startDate = null;
					aTask.endDate = null;
				}
				aTask.worker = performer;
				aTask.content = performWhat.getText();
				
				JOptionPane.showMessageDialog(null, "해당 업무를 수정했어요");
				
				((P_ProjectManagementPanel)getParent()).requestRefresh();
			}
		});
		additionalBtns.add(updateTaskBtn);//, BorderLayout.SOUTH);
		
		JButton copyBtn = new PinkRoundIconButton(new File("src\\images\\pinkLinkButton.png"));
		copyBtn.setToolTipText("업무정보 복사버튼");
		copyBtn.setPreferredSize(new Dimension(30, 30));
		copyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if("".equals(from.getText())
						|| "".equals(to.getText())
						|| "".equals(performWhat.getText())){
					int result = JOptionPane.showConfirmDialog(null, "업무 정보가 완전히 채워지지 않았습니다\n그래도 복사할까요?", null, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {
						return;
					}
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				CPT_CPTManager.clipBoard = new P_Task();
				P_Project p = ((P_ProjectManagementPanel)getParent()).currentProject;
				CPT_CPTManager.clipBoard.projectName = p.name;
				try {
					System.out.println(from.getText());
					System.out.println(to.getText());
					CPT_CPTManager.clipBoard.startDate = sdf.parse(from.getText());
					CPT_CPTManager.clipBoard.endDate = sdf.parse(to.getText());
				} catch (ParseException e1) {
					System.out.println(CPT_CPTManager.clipBoard.projectName + "의 업무기한 복사 실패");
					CPT_CPTManager.clipBoard.startDate = null;
					CPT_CPTManager.clipBoard.endDate = null;
				}
				CPT_CPTManager.clipBoard.worker = performer;
				CPT_CPTManager.clipBoard.content = performWhat.getText();
			}
		});
		additionalBtns.add(copyBtn);
		
		JButton downCopiedButton = new PinkRoundIconButton(new File("src\\images\\downCopiedButton.png"));
		downCopiedButton.setToolTipText("복사정보 붙여넣기 버튼");
		downCopiedButton.setPreferredSize(new Dimension(30, 30));
		downCopiedButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CPT_CPTManager.clipBoard == null || CPT_CPTManager.clipBoard.projectName.equals("")) {
					JOptionPane.showMessageDialog(null, "복사한 정보가 없습니다");
					return;
				}
				showTask(CPT_CPTManager.clipBoard);
			}
		});
		additionalBtns.add(downCopiedButton);
		
		showPriorTask = new PinkRoundIconButton(new File("src\\images\\priorButton.png"));
		showPriorTask.setToolTipText("선행업무 조회버튼");
		showPriorTask.setPreferredSize(new Dimension(30, 30));
		showPriorTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<P_Task> ctl = CPT_CPTManager.getTasksFromProject(((P_ProjectManagementPanel)getParent()).currentProject);
				if(ctl == null) {
					JOptionPane.showMessageDialog(null, "업무정보가 없습니다"); return;
				}
				ctl = CPT_CPTManager.findTaskByPriorId(currentTaskId);
				if(ctl == null) {
					JOptionPane.showMessageDialog(null, "선행정보가 없습니다"); return;
				}
				
				String contentTotal = "";
				for(P_Task t : ctl) {
					contentTotal += t.content + "\n";
				}
				
				JOptionPane.showMessageDialog(null, "선행업무 정보입니다\n" + contentTotal);
			}
		});
		additionalBtns.add(showPriorTask);
		
		add(additionalBtns, JDesktopPane.POPUP_LAYER);
		
	}
	
	public JButton getAddButton() {
		return addTask;
	}
	public JButton getLinkedButton() {
		return showPriorTask;
	}
	
	public void setTasks(List<P_Task> tl) {
		showedTasks = tl;
		
		if(showedTasks != null) {
			for(P_Task t : tl) {
				System.out.println("tEnddate : " + t.endDate);
			}
			
			irt = tl.listIterator();
			
			clearTask();
			if(irt.hasNext()) {
				showTask(irt.next());
			}else {
				nextBtn.setText("|");
			}
			prevBtn.setText("|");
			recentButton = "next";
		}else {
			nextBtn.setText("|");
			prevBtn.setText("|");
		}
		
	}
	
	public void showTask(P_Task t) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		from.setText(sdf.format(t.startDate));
		to.setText(sdf.format(t.endDate));
		if(t.worker != null)
			performerName.setText(t.worker.name);
		performWhat.setText(t.content);
		performer = t.worker;
		System.out.println("current task >> : " + t.taskId + "@  " + t.endDate);
		currentTaskId = t.taskId;

		if(!irt.hasPrevious()) {
			prevBtn.setText("|");
		}else {
			prevBtn.setText("<");
		}
		if(!irt.hasNext()) {
			nextBtn.setText("|");
		}else {
			nextBtn.setText(">");
		}
	}
	public void clearTask() {
		from.setText("");
		to.setText("");
		performerName.setText("");
		performWhat.setText("");
		currentTaskId = -1;
	}
	
	public void setPerformerInfo(CPT_Coworker pfm) {
		this.performer = pfm;
		performerName.setText(performer.name);
	}
	
	public long getCurrentTaskId() {
		return currentTaskId;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new P_TaskManagementPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
