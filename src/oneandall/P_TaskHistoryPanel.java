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
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class P_TaskHistoryPanel extends JDesktopPane {
	
	JPanel tPanel = new JPanel();
	JPanel task;
	JPanel taskParent;
	JPanel cPanel;
	JButton nextBtn;
	JButton moveBtn;
	JButton prevBtn;
	String recentButton;
	
	
	JPanel additionalBounds;
	List<P_Task> tasks;
	ListIterator<P_Task> irt;
	
	long currentTaskId;
	
	JTextField fromt;
	JTextField tot;
	JLabel fromtot;
	JTextField performerNamet;
	RoundTextArea performWhatt;
	
	JTextField fromc;
	JTextField toc;
	JLabel fromtoc;
	JTextField performerNamec;
	RoundTextArea performWhatc;
	
	CPT_Coworker tempPerformer;
	
	
	public P_TaskHistoryPanel() {
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		tPanel.setBackground(Color.BLACK);
		
		taskParent = new JPanel(new FlowLayout());
		taskParent.setOpaque(false);
		taskParent.setBackground(Color.BLACK);
		taskParent.setBounds(50, 0, 800, 450);
		
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
		taskParent.add(prevBtn, BorderLayout.WEST);
		
		task = new JPanel();
		task.setLayout(new GridLayout(0, 1, 0, 10));
		task.setPreferredSize(new Dimension(675, 435));
		task.setOpaque(false);
		
		JPanel shortPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		shortPanel.setBackground(Color.BLACK);
		JLabel deadlineLabel = new PinkLabel("기한");
		shortPanel.add(deadlineLabel);
		JPanel deadlinePanel = new JPanel(new FlowLayout());
		deadlinePanel.setBackground(Color.BLACK);
		fromt = new RoundTextField();
		fromt.setPreferredSize(new Dimension(272, 30));
		fromt.setEnabled(false);
		deadlinePanel.add(fromt);
		fromtot = new PinkLabel("~");
		fromtot.setPreferredSize(new Dimension(101, 30));
		deadlinePanel.add(fromtot);
		tot = new RoundTextField();
		tot.setPreferredSize(new Dimension(272, 30));
		tot.setEnabled(false);
		deadlinePanel.add(tot);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		performerNamet = new RoundTextField();
		performerNamet.setEditable(false);
		shortPanel.add(performerNamet);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		task.add(shortPanel);//, BorderLayout.NORTH);
		
		performWhatt = new RoundTextArea();
		performWhatt.setEnabled(false);
		JScrollPane scroll = new PinkScroll(performWhatt);
		task.add(scroll);//, BorderLayout.CENTER);
		
		
		taskParent.add(task, BorderLayout.CENTER);
		
		nextBtn = new PinkRoundButton(">");
		nextBtn.setPreferredSize(new Dimension(30, 100));
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(recentButton.equals("prev")) {
					irt.next();
					recentButton = "next";
				}
				if(!irt.hasNext()) nextBtn.setText("|");
				else nextBtn.setText(">");
				if(!irt.hasPrevious()) prevBtn.setText("|");
				else prevBtn.setText("<");
				if(nextBtn.getText().equals("|")) {					
					return;
				}
				showTask(irt.next());
			}
		});
		taskParent.add(nextBtn, BorderLayout.EAST);
		
		add(taskParent, JDesktopPane.DEFAULT_LAYER);
		
		additionalBounds = new JPanel();
		additionalBounds.setOpaque(false);
		additionalBounds.setBackground(new Color(0, 0, 0, 0));
		additionalBounds.setLayout(new FlowLayout(FlowLayout.LEFT));
		additionalBounds.setBounds(120, 5, 400, 50);
		
//		JButton addTask = new PinkRoundIconButton(new File("src\\images\\pinkAddButton.png"));
//		addTask.setPreferredSize(new Dimension(30, 30));
//		additionalBtns.add(addTask);
		JButton doLink = new PinkRoundIconButton(new File("src\\images\\pinkLinkButton.png"));
		doLink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				CPT_CPTManager.clipBoard = new P_Task();
				P_Project p = ((P_ProjectHistoryPanel)getParent()).currentProject;
				CPT_CPTManager.clipBoard.projectName = p.name;
				try {
					CPT_CPTManager.clipBoard.startDate = sdf.parse(fromc.getText());
					CPT_CPTManager.clipBoard.endDate = sdf.parse(toc.getText());
				} catch (ParseException e1) {
					System.out.println(CPT_CPTManager.clipBoard.projectName + "의 업무기한 복사 실패");
					CPT_CPTManager.clipBoard.startDate = null;
					CPT_CPTManager.clipBoard.endDate = null;
				}
				CPT_CPTManager.clipBoard.worker = tempPerformer;
				CPT_CPTManager.clipBoard.content = performWhatc.getText();
			}
		});
		doLink.setPreferredSize(new Dimension(30, 30));
		additionalBounds.add(doLink);
		
		moveBtn = new PinkRoundIconButton(new File("src\\images\\compareButton.png"));
		moveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fromc.setText(fromt.getText());
				toc.setText(tot.getText());
				performerNamec.setText(performerNamet.getText());
				performWhatc.setText(performWhatt.getText());
			}
		});
		moveBtn.setPreferredSize(new Dimension(30, 30));
		
		JPanel additionalRightBtn = new JPanel();
		additionalRightBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		additionalRightBtn.setBounds(520, 5, 250, 35);
		additionalRightBtn.setOpaque(false);
//		additionalRightBtn.setBackground(new Color(0, 0, 0, 0));
//		JButton updateTaskBtn = new PinkButton("수정완료√");
//		additionalRightBtn.add(updateTaskBtn);//, BorderLayout.SOUTH);
		
		add(additionalBounds, JDesktopPane.POPUP_LAYER);
		add(additionalRightBtn, JDesktopPane.POPUP_LAYER);
		
	}
	
	public void insertCompareMode() {
		
		additionalBounds.setBounds(120, 10, 400, 50);
		additionalBounds.add(moveBtn);
		cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(0, 1, 0, 10));
		cPanel.setPreferredSize(new Dimension(350, 435));
		cPanel.setBackground(Color.RED);
		cPanel.setOpaque(false);
		
		JPanel shortPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		shortPanel.setBackground(Color.RED);
		JLabel deadlineLabel = new PinkLabel("기한");
		shortPanel.add(deadlineLabel);
		JPanel deadlinePanel = new JPanel(new FlowLayout());
		deadlinePanel.setBackground(Color.RED);
		fromc = new RoundTextField();
		fromc.setPreferredSize(new Dimension(100, 30));
		deadlinePanel.add(fromc);
		fromtoc = new PinkLabel("~");
		fromtoc.setPreferredSize(new Dimension(50, 30));
		deadlinePanel.add(fromtoc);
		toc = new RoundTextField();
		toc.setPreferredSize(new Dimension(100, 30));
		deadlinePanel.add(toc);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		performerNamec = new RoundTextField();
		performerNamec.setAlignmentX(CENTER_ALIGNMENT);
		shortPanel.add(performerNamec);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		cPanel.add(shortPanel);//, BorderLayout.NORTH);
		
		performWhatc = new RoundTextArea();
		JScrollPane scroll = new PinkScroll(performWhatc);
		cPanel.add(scroll);//, BorderLayout.CENTER);
		
		this.fromt.setPreferredSize(new Dimension(100, 30));
		this.fromtot.setPreferredSize(new Dimension(50, 30));
		this.tot.setPreferredSize(new Dimension(100, 30));
		task.setPreferredSize(new Dimension(350, 435));
		taskParent.remove(task);
		taskParent.remove(nextBtn);
		tPanel.add(cPanel);
		tPanel.add(task);
		taskParent.add(tPanel);
		taskParent.add(nextBtn);
		
	}
	
	public void outCompareMode() {
		additionalBounds.setBounds(120, 5, 400, 50);
		additionalBounds.remove(moveBtn);
		fromt.setPreferredSize(new Dimension(272, 30));
		fromtot.setPreferredSize(new Dimension(101, 30));
		tot.setPreferredSize(new Dimension(272, 30));
		task.setPreferredSize(new Dimension(675, 450));
		taskParent.remove(tPanel);
		taskParent.remove(nextBtn);
		taskParent.add(task);
		taskParent.add(nextBtn);
		tPanel.remove(cPanel);
	}
	
	public void setTasks(List<P_Task> tl) {
		
		tasks = tl;
		
		if(tasks != null) {
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
		fromt.setText(sdf.format(t.startDate));
		tot.setText(sdf.format(t.endDate));
		performerNamet.setText(t.worker.name);
		performWhatt.setText(t.content);
		currentTaskId = t.taskId;
		tempPerformer = t.worker;
		
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
		fromt.setText("");
		tot.setText("");
		performerNamet.setText("");
		performWhatt.setText("");
		currentTaskId = -1;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(P_EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(P_EnvironmentConfigure.PROJECT_WIDTH, P_EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new P_TaskHistoryPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
