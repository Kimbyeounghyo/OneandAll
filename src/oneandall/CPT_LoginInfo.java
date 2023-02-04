package oneandall;

import java.util.List;
import java.util.stream.Collectors;

import oneandall.CPT_Coworker;
import oneandall.P_Project;

public class CPT_LoginInfo {
	//로그인 시에는 나중에 tag로 비교할 생각중
	long currentTag;
	//
	//수정 필요
	public static CPT_Coworker getLoggedInfo() {
		String id = "teamleaderkim";
		String pwd = "aaa";
		List<CPT_Coworker> cl = CPT_CPTManager.cList.stream().filter(c -> c.id.equals(id) && c.pwd.equals(pwd)).collect(Collectors.toList());
		
		if(cl == null || cl.size() == 0) return null;
		
		return cl.get(0);
	}

	public static List<P_Project> getCurrentProjects(){
		CPT_Coworker cw = getLoggedInfo();
		
		if(cw == null || CPT_CPTManager.pList == null) return null;
		
		System.out.println(cw.tag);
		List<P_Project> currentProjects = CPT_CPTManager.pList.stream()
				.filter(p -> p.workers.stream().filter(c -> c.equals(cw))
									.collect(Collectors.toList()).size() > 0)
				.collect(Collectors.toList());
		
		return currentProjects;
	}

}
