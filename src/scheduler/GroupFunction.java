package scheduler;

import javax.swing.JLabel;

public class GroupFunction {
	
	public String gName;//�׷��̸�
	public String mName;//����̸�
	public JLabel label = new JLabel();
	
	public String getGroupNameText() {
		
		gName = "[������ ver 1.0]";
		return gName;
	}
	
	public String getMemberNameText() {
		return mName+"��"+" ���� ����";
	}
	
	public JLabel getMemberHoliday() {
		
		return label;
	}
	
}
