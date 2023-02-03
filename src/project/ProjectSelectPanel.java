package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import customComponent.PinkButton;
import util.CPTManager;
import util.EnvironmentConfigure;
import util.LoginInfo;

public class ProjectSelectPanel extends JPanel {
	
	List<Project> pl = null;
	JButton[] btns = null;
	
	public ProjectSelectPanel(String targetProject) {
		
		pl = LoginInfo.getCurrentProjects();
		
		setBackground(Color.BLACK);
//		setLayout(new GridBagLayout());
		
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.NONE;
//		gbc.weightx = 1;
		setLayout(new GridLayout(0, 1, 5, 10));
		
		btns = new JButton[pl.size()];
		for(int i=0; i<pl.size(); i++) {
			Project p = pl.get(i);
			btns[i] = new PinkButton(p.name + "\n" + p.content);
			btns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ProjectSelectFrame.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					
					switch(targetProject) {
	
					case "projectManagement":
						System.out.println("management selected");
						EnvironmentConfigure.createFrame(new ProjectManagementFrame(p));
						break;
					case "projectHistory":
						System.out.println("history selected");
						EnvironmentConfigure.createFrame(new ProjectHistoryFrame(p));
						break;
					}
					
					ProjectSelectFrame.frame.dispose();
				}
			});
			
			add(btns[i]);
		}
	}
	
}
