package oneandall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customComponent.PinkButton;
import customComponent.PinkIconButton;
import customComponent.PinkLabel;
import customComponent.RoundTextField;
public class P_ProjectManagementPanel extends JPanel {
	
	JPanel projectInfo;
	JPanel optionPanel;
	public JDesktopPane taskManagement;
	public P_Project currentProject;
	
	public P_ProjectManagementPanel(P_Project p) {
		
		currentProject = p;
		
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
		
		JTextField handPersonName = new RoundTextField();
		handPersonName.setPreferredSize(new Dimension(100, 50));
		piHandOver.add(handPersonName);
		System.out.println(CPT_LoginInfo.getLoggedInfo().grade);
		handPersonName.setText(CPT_LoginInfo.getLoggedInfo().name);
		
		JButton personFindBtn = new PinkIconButton(new File("src\\images\\pinkReadingGlass.png"));
		personFindBtn.setToolTipText("팀장을 찾아봐요");
		personFindBtn.setPreferredSize(new Dimension(50, 50));
		piHandOver.add(personFindBtn);
		
		projectInfo.add(piHandOver);
		//==============
		
		//프로젝트 정보 수정=
		JButton updateBtn = new PinkButton("정보수정하기√");
		updateBtn.setPreferredSize(new Dimension(200, 50));
		projectInfo.add(updateBtn);
		//==============
		
		add(projectInfo, BorderLayout.NORTH);
		//==========================================================================
		
		//===========================프로젝트 관리(업무 정보, 버튼 등)======================
	
		taskManagement = new P_TaskManagementPanel();
//		taskManagement.setPreferredSize(new Dimension(1000, 500));
		taskManagement.setLocation(50, 300);
		
		optionPanel = new P_ProjectOptionPanel();
		optionPanel.setPreferredSize(new Dimension(300, 500));
		
		add(taskManagement, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.EAST);
		
		//=========================================================================
	}
	
	public JPanel getProjectInfoPanel() {
		return projectInfo;
	}
	public JDesktopPane getTaskManagementPanel() {
		return taskManagement;
	}
	
	public void setTaskListToShow(List<P_Task> tl) {
		((P_TaskManagementPanel)taskManagement).setTasks(tl);
	}

}
