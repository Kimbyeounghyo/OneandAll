package oneandall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customComponent.PinkButton;
import customComponent.PinkIconButton;
import customComponent.PinkLabel;
import customComponent.RoundTextField;
public class P_ProjectManagementPanel extends JPanel {
	
	JPanel myPanel;
	JPanel projectInfo;
	JPanel optionPanel;
	JTextField handPersonName;
	public JDesktopPane taskManagement;
	public P_Project currentProject;
	public CPT_Coworker replaceLeader;
	
	public P_ProjectManagementPanel(P_Project p) {
	
		myPanel = this;
		currentProject = p;
		replaceLeader = p.workers.stream().filter(c -> c.grade.equals("팀장")).collect(Collectors.toList()).get(0);
		
		setLayout(new BorderLayout());
		
		//===========================프로젝트 정보(프로젝트 기한, 프로젝트 인계)================
		projectInfo = new JPanel();
		projectInfo.setBackground(new Color(0, 0, 0));
		
		//프로젝트 기한=====
		JPanel piDeadLine = new JPanel();
		piDeadLine.setOpaque(false);
		piDeadLine.setBackground(new Color(0, 0, 0, 0));
		
		JLabel projectName = new PinkLabel(currentProject.name + " 기한");
		projectName.setPreferredSize(new Dimension(150, 50));
		piDeadLine.add(projectName);
		
		JTextField startDate = new RoundTextField();
		startDate.setPreferredSize(new Dimension(150, 50));
		piDeadLine.add(startDate);
		startDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(currentProject.startDate));
		
		JLabel toFrom = new PinkLabel("~");
		toFrom.setPreferredSize(new Dimension(50, 50));
		piDeadLine.add(toFrom);
		
		JTextField endDate = new RoundTextField();
		endDate.setPreferredSize(new Dimension(150, 50));
		piDeadLine.add(endDate);
		endDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(currentProject.endDate));
		
		projectInfo.add(piDeadLine);
		//==============
		
		//프로젝트 인계=====
		JPanel piHandOver = new JPanel();
		piHandOver.setOpaque(false);
		piHandOver.setBackground(new Color(0, 0, 0, 0));
		
		JLabel handPerson = new PinkLabel("프로젝트 담당");
		handPerson.setPreferredSize(new Dimension(150, 50));
		piHandOver.add(handPerson);
		
		handPersonName = new RoundTextField();
		handPersonName.setPreferredSize(new Dimension(100, 50));
		handPersonName.setFocusable(false);
		handPersonName.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<CPT_Coworker> cl = CPT_CPTManager.cList.stream().filter(c -> c.grade.equals("팀장")).collect(Collectors.toList());
				P_EnvironmentConfigure.createFrame(new P_SelectWorkerFrame(cl, myPanel), 150, 300);
			}
			
		});
		piHandOver.add(handPersonName);
		handPersonName.setText(CPT_LoginInfo.loginUser.name);
		
//		JButton personFindBtn = new PinkIconButton(new File("src\\images\\pinkReadingGlass.png"));
//		personFindBtn.setToolTipText("팀장을 찾아봐요");
//		personFindBtn.setPreferredSize(new Dimension(50, 50));
//		piHandOver.add(personFindBtn);
		
		projectInfo.add(piHandOver);
		//==============
		
		//프로젝트 정보 수정=
		JButton updateBtn = new PinkButton("정보수정하기√");
		updateBtn.setPreferredSize(new Dimension(200, 50));
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					currentProject.startDate = sdf.parse(startDate.getText());
					currentProject.endDate = sdf.parse(endDate.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "날짜 형식을 yyyy-MM-dd 형태로 입력해주세요");
					return;
				}
				List<CPT_Coworker> cl = currentProject.workers.stream().filter(c -> c.grade.equals("팀장")).collect(Collectors.toList());
				
				currentProject.workers.removeAll(cl);
				currentProject.workers.add(replaceLeader);
				
				JOptionPane.showMessageDialog(null, "프로젝트 정보가 수정되었습니다");
				
			}
		});
		projectInfo.add(updateBtn);
		//==============
		
		add(projectInfo, BorderLayout.NORTH);
		//==========================================================================
		
		//===========================프로젝트 관리(업무 정보, 버튼 등)======================
	
		taskManagement = new P_TaskManagementPanel();
//		taskManagement.setPreferredSize(new Dimension(1000, 500));
		taskManagement.setLocation(50, 300);
		List<P_Task> tl = CPT_CPTManager.getTasksFromProject(currentProject);
		((P_TaskManagementPanel)taskManagement).setTasks(tl);
		
		optionPanel = new P_ProjectOptionPanel();
		optionPanel.setPreferredSize(new Dimension(300, 500));
		
		add(taskManagement, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.EAST);
		
		((P_ProjectOptionPanel)optionPanel).refreshTask(this);
		
		//=========================================================================
	}
	
	public JPanel getProjectInfoPanel() {
		return projectInfo;
	}
	public JDesktopPane getTaskManagementPanel() {
		return taskManagement;
	}
	
	public void setPerformerInfo(CPT_Coworker pfm) {
		this.replaceLeader = pfm;
		handPersonName.setText(replaceLeader.name);
	}
	
	public void setTaskListToShow(List<P_Task> tl) {
		((P_TaskManagementPanel)taskManagement).setTasks(tl);
	}
	
	public void requestRefresh() {
		((P_ProjectOptionPanel)optionPanel).refreshTask(this);
	}
	
	public long getCurrentTaskId() {
		return ((P_TaskManagementPanel)taskManagement).getCurrentTaskId();
	}

}
