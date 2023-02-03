package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

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
import oneandall.EnvironmentConfigure;

public class TaskHistoryPanel extends JDesktopPane {
	
	JPanel tPanel = new JPanel();
	JPanel task;
	JPanel taskParent;
	JPanel cPanel;
	JButton nextBtn;
	JButton moveBtn;
	
	JTextField from;
	JTextField to;
	JLabel fromto;
	
	JPanel additionalBounds;
	List<Task> tasks;
	
	JTextField performerName;
	JTextField performWhat;
	long currentTaskId;
	
	public TaskHistoryPanel() {
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		tPanel.setBackground(Color.BLACK);
		
		taskParent = new JPanel(new FlowLayout());
		taskParent.setOpaque(false);
		taskParent.setBackground(Color.BLACK);
		taskParent.setBounds(50, 0, 800, 450);
		
		JButton prevBtn = new PinkRoundButton("<");
		prevBtn.setPreferredSize(new Dimension(30, 100));
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
		from = new RoundTextField();
		from.setPreferredSize(new Dimension(272, 30));
		from.setEnabled(false);
		deadlinePanel.add(from);
		fromto = new PinkLabel("~");
		fromto.setPreferredSize(new Dimension(101, 30));
		deadlinePanel.add(fromto);
		to = new RoundTextField();
		to.setPreferredSize(new Dimension(272, 30));
		to.setEnabled(false);
		deadlinePanel.add(to);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		JTextField performerName = new RoundTextField();
		performerName.setEditable(false);
		shortPanel.add(performerName);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		task.add(shortPanel);//, BorderLayout.NORTH);
		
		JTextArea performWhat = new RoundTextArea();
		performWhat.setEnabled(false);
		JScrollPane scroll = new PinkScroll(performWhat);
		task.add(scroll);//, BorderLayout.CENTER);
		
		
		taskParent.add(task, BorderLayout.CENTER);
		
		nextBtn = new PinkRoundButton(">");
		nextBtn.setPreferredSize(new Dimension(30, 100));
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
		doLink.setPreferredSize(new Dimension(30, 30));
		additionalBounds.add(doLink);
		
		moveBtn = new PinkRoundIconButton(new File("src\\images\\compareButton.png"));
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
		JTextField from = new RoundTextField();
		from.setPreferredSize(new Dimension(100, 30));
		deadlinePanel.add(from);
		JLabel fromto = new PinkLabel("~");
		fromto.setPreferredSize(new Dimension(50, 30));
		deadlinePanel.add(fromto);
		JTextField to = new RoundTextField();
		to.setPreferredSize(new Dimension(100, 30));
		deadlinePanel.add(to);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		JTextField performerName = new RoundTextField();
		performerName.setAlignmentX(CENTER_ALIGNMENT);
		shortPanel.add(performerName);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		cPanel.add(shortPanel);//, BorderLayout.NORTH);
		
		JTextArea performWhat = new RoundTextArea();
		JScrollPane scroll = new PinkScroll(performWhat);
		cPanel.add(scroll);//, BorderLayout.CENTER);
		
		this.from.setPreferredSize(new Dimension(100, 30));
		this.fromto.setPreferredSize(new Dimension(50, 30));
		this.to.setPreferredSize(new Dimension(100, 30));
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
		from.setPreferredSize(new Dimension(272, 30));
		fromto.setPreferredSize(new Dimension(101, 30));
		to.setPreferredSize(new Dimension(272, 30));
		task.setPreferredSize(new Dimension(675, 450));
		taskParent.remove(tPanel);
		taskParent.remove(nextBtn);
		taskParent.add(task);
		taskParent.add(nextBtn);
		tPanel.remove(cPanel);
	}
	
	public void setTasks(List<Task> tl) {
		tasks = tl;
		if(tasks != null)
			showTask(tasks.get(0));
	}
	
	public void showTask(Task t) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		to.setText(sdf.format(t.startDate));
		from.setText(sdf.format(t.endDate));
		performerName.setText(t.worker.name);
		performWhat.setText(t.content);
		currentTaskId = t.taskId;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new TaskHistoryPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
