package oneandall;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class P_SelectWorkerFrame extends JFrame {
	
	public P_SelectWorkerFrame(List<CPT_Coworker> showList, Container target) {
		
		setTitle("업무자 선택"); //타이틀 이름 설정
		setSize(150, 300); //화면 사이즈 설정
		setLocationRelativeTo(null); // 화면 가운데에 뜨도록 설정, 사이즈를 먼저 설정해주고 불러주기!
		setLayout(null);
		
		getContentPane().setBackground(new Color(0, 0, 0, 255));
		
		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(null);
		btnsPanel.setBackground(new Color(0, 0, 0, 255));
		btnsPanel.setPreferredSize(new Dimension(150, 60 * showList.size()));
		
		int cnt = 0;
		for(CPT_Coworker c : showList) {
			UI_PinkButtonTeamName pbt = new UI_PinkButtonTeamName(new Color(255, 198, 255, 255), new Color(255, 255, 255, 255), c);
			pbt.setBounds(0, cnt++ * 65, 150, 60);
			pbt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(target instanceof P_ProjectManagementPanel) {
						
						((P_ProjectManagementPanel)target).setPerformerInfo(pbt.worker);
						
					} else if(target instanceof P_TaskManagementPanel) {
						
						((P_TaskManagementPanel)target).setPerformerInfo(pbt.worker);
						
					} else if(target instanceof P_ProjectOptionPanel) {
						
						((P_ProjectOptionPanel)target).setPerformerInfo(pbt.worker);
						
					}
					
					setDefaultCloseOperation(HIDE_ON_CLOSE);
					dispose();
				}
			});
			btnsPanel.add(pbt);
		}
		
		JScrollPane js = new UI_PinkScroll(btnsPanel);
		js.setBounds(0, 0, 150, 300);
		getContentPane().add(js);
		
		setVisible(true);
		
	}

}
