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

public class TaskManagementPanel extends JDesktopPane {
	
	JButton addTask;
	JButton showPriorTask;
	Coworker performer;
	
	public TaskManagementPanel() {
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		JPanel taskPanel = new JPanel(new FlowLayout());
//		taskPanel.setOpaque(false);
		taskPanel.setBackground(Color.BLACK);
		taskPanel.setBounds(50, 0, 800, 450);
		
		JButton prevBtn = new PinkRoundButton("<");
		prevBtn.setPreferredSize(new Dimension(30, 100));
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
		JTextField from = new RoundTextField();
		from.setPreferredSize(new Dimension(272, 30));
		deadlinePanel.add(from);
		JLabel fromto = new PinkLabel("~");
		fromto.setPreferredSize(new Dimension(101, 30));
		deadlinePanel.add(fromto);
		JTextField to = new RoundTextField();
		to.setPreferredSize(new Dimension(272, 30));
		deadlinePanel.add(to);
		shortPanel.add(deadlinePanel);
		
		
		JLabel performerLabel = new PinkLabel("할사람");
		shortPanel.add(performerLabel);
		JTextField performerName = new RoundTextField();
		performerName.setAlignmentX(CENTER_ALIGNMENT);
		shortPanel.add(performerName);
		JLabel performContent = new PinkLabel("할내용");
		shortPanel.add(performContent);
		
		taskContentPanel.add(shortPanel);//, BorderLayout.NORTH);
		
		JTextArea performWhat = new RoundTextArea();
		JScrollPane scroll = new PinkScroll(performWhat);
		taskContentPanel.add(scroll);//, BorderLayout.CENTER);
		
		
		taskPanel.add(taskContentPanel, BorderLayout.CENTER);
		
		JButton nextBtn = new PinkRoundButton(">");
		nextBtn.setPreferredSize(new Dimension(30, 100));
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
				Task newTask = new Task();
				newTask.projectName = ((ProjectManagementPanel)getParent()).currentProject.name;
				try {
					newTask.startDate = sdf.parse(from.getText());
					newTask.endDate = sdf.parse(to.getText());
				} catch (ParseException e1) {
					newTask.startDate = null;
					newTask.endDate = null;
				}
				newTask.worker = performer;
				newTask.content = performWhat.getText();
				
				CPTManager.tList.add(newTask);
				
				JOptionPane.showMessageDialog(null, "해당 업무를 " + performerName + "에게 시켰어요");
			}
		});
		additionalBtns.add(addTask);
		
		JButton updateTaskBtn = new PinkRoundIconButton(new File("src\\images\\updateTaskButton.png"));
		updateTaskBtn.setToolTipText("업무 수정 버튼");
		updateTaskBtn.setPreferredSize(new Dimension(30, 30));
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
				CPTManager.clipBoard = new Task();
				CPTManager.clipBoard.projectName = ((ProjectManagementPanel)getParent()).currentProject.name;
				try {
					CPTManager.clipBoard.startDate = sdf.parse(from.getText());
					CPTManager.clipBoard.endDate = sdf.parse(to.getText());
				} catch (ParseException e1) {
					System.out.println(CPTManager.clipBoard.projectName + "의 업무기한 복사 실패");
					CPTManager.clipBoard.startDate = null;
					CPTManager.clipBoard.endDate = null;
				}
				CPTManager.clipBoard.worker = performer;
				CPTManager.clipBoard.content = performWhat.getText();
			}
		});
		additionalBtns.add(copyBtn);
		
		JButton downCopiedButton = new PinkRoundIconButton(new File("src\\images\\downCopiedButton.png"));
		downCopiedButton.setToolTipText("복사정보 붙여넣기 버튼");
		downCopiedButton.setPreferredSize(new Dimension(30, 30));
		additionalBtns.add(downCopiedButton);
		
		showPriorTask = new PinkRoundIconButton(new File("src\\images\\priorButton.png"));
		showPriorTask.setToolTipText("선행업무 조회버튼");
		showPriorTask.setPreferredSize(new Dimension(30, 30));
		additionalBtns.add(showPriorTask);
		
		add(additionalBtns, JDesktopPane.POPUP_LAYER);
		
	}
	
	public JButton getAddButton() {
		return addTask;
	}
	public JButton getLinkedButton() {
		return showPriorTask;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle(EnvironmentConfigure.PROJECT_TITLE); //타이틀 이름 설정
		frame.setSize(EnvironmentConfigure.PROJECT_WIDTH, EnvironmentConfigure.PROJECT_HEIGHT); //화면 사이즈 설정
		frame.setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		frame.getContentPane().add(new TaskManagementPanel());
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	}

}
