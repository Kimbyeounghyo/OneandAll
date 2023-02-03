package util;

import java.util.List;
import java.util.stream.Collectors;

import project.Coworker;
import project.Project;

public class LoginInfo {
	//로그인 시에는 나중에 tag로 비교할 생각중
	long currentTag;
	
	//수정 필요
	public static Coworker getLoggedInfo() {
		String id = "teamleaderkim";
		String pwd = "aaa";
		List<Coworker> cl = CPTManager.cList.stream().filter(c -> c.id.equals(id) && c.pwd.equals(pwd)).collect(Collectors.toList());
		
		if(cl == null || cl.size() == 0) return null;
		
		return cl.get(0);
	}

	public static List<Project> getCurrentProjects(){
		Coworker cw = getLoggedInfo();
		
		if(cw == null || CPTManager.pList == null) return null;
		
		System.out.println(cw.tag);
		List<Project> currentProjects = CPTManager.pList.stream()
				.filter(p -> p.workers.stream().filter(c -> c.equals(cw))
									.collect(Collectors.toList()).size() > 0)
				.collect(Collectors.toList());
		
		return currentProjects;
	}

}
