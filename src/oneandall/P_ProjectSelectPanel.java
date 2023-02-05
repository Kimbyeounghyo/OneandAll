package oneandall;

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

public class P_ProjectSelectPanel extends JPanel {
	
	List<P_Project> pl = null;
	JButton[] btns = null;
	
	public P_ProjectSelectPanel(String targetProject) {
		
		pl = CPT_LoginInfo.getCurrentProjects();
		
		setBackground(Color.BLACK);
//		setLayout(new GridBagLayout());
		
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.NONE;
//		gbc.weightx = 1;
		setLayout(new GridLayout(0, 1, 5, 10));
		
		btns = new JButton[pl.size()];
		for(int i=0; i<pl.size(); i++) {
			P_Project p = pl.get(i);
			btns[i] = new UI_PinkButton(p.name + "\n" + p.content);
			btns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					P_ProjectSelectFrame.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					
					switch(targetProject) {
	
					case "projectManagement":
						System.out.println("management selected");
						P_EnvironmentConfigure.createFrame(new P_ProjectManagementFrame(p));
						break;
					case "projectHistory":
						System.out.println("history selected");
						P_EnvironmentConfigure.createFrame(new P_ProjectHistoryFrame(p));
						break;
					case "projectArrange":
						System.out.println("arrange selected");
						P_EnvironmentConfigure.createFrame(new P_Projectarrangeexample2(p));
						break;
					}
					
					P_ProjectSelectFrame.frame.dispose();
				}
			});
			
			btns[i].setPreferredSize(new Dimension(P_EnvironmentConfigure.PROJECT_WIDTH, 200));
			add(btns[i]);
		}
	}
	
}
