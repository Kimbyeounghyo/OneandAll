package oneandall;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oneandall.CPT_Coworker;
import oneandall.P_Project;

public class CPT_LoginInfo {
	//로그인 유저를 저장해놓는다
	public static CPT_Coworker loginUser;

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

}
