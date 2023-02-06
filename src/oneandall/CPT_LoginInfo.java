package oneandall;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import oneandall.CPT_Coworker;
import oneandall.P_Project;

public class CPT_LoginInfo implements Runnable {
	//로그인 유저를 저장해놓는다
	public static CPT_Coworker loginUser;
	public JLabel l;
	
	public CPT_LoginInfo() {
		
	}
	public CPT_LoginInfo(JLabel l) {
		this.l = l;
	}

	public static List<P_Project> getCurrentProjects(){
		if(loginUser == null || CPT_CPTManager.pList == null) return null;
		
		System.out.println(loginUser.tag);
		List<P_Project> currentProjects = CPT_CPTManager.pList.stream()
				.filter(p -> p.workers.stream().filter(c -> c.equals(loginUser))
									.collect(Collectors.toList()).size() > 0)
				.collect(Collectors.toList());
		
		return currentProjects;
	}
	
	public static void goHome(JFrame f) {
		JOptionPane.showMessageDialog(null, "로그인 후 이용해주세요");
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		new _OneandAll_MainScreen();
		f.dispose();
	}
	
	public static boolean authCheck(String[] str) {
		
		for(int i=0; i<str.length; i++) {
			if(str[i].equals(loginUser.grade)) {
				return false;
			}
		}
		
		JOptionPane.showMessageDialog(null, "권한이 없어요");
		return true;
	}

	@Override
	public void run() {
		while(true) {
			l.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
	}

}
