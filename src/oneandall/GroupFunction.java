package oneandall;

import javax.swing.JLabel;

public class GroupFunction {
	
	public String gName;//그룹이름
	public String mName;//멤버이름
	public JLabel label = new JLabel();
	
	public String getGroupNameText() {
		
		gName = "[개발중 ver 1.0]";
		return gName;
	}
	
	public String getMemberNameText() {
		return mName+"의"+" 개인 일정";
	}
	
	public JLabel getMemberHoliday() {
		
		return label;
	}
	
}