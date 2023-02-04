package oneandall;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import oneandall.CPT_Coworker;
import oneandall.P_Project;

public class CPT_ConnectCoworkerFromProject {

	//Coworker 에서 가져온 데이터를 특정프로젝트에 넣기위해 만든 임시 기능
	public static void main(String[] args) throws IOException {
		
		P_TempObjectReader.packageName = "project";
		P_TempObjectReader.invoke();
		P_TempObjectReader.packageName = "coworker";
		P_TempObjectReader.invoke();
		String pName = "솔라시스템"; //프로젝트이름
		String cName = "김팀장"; //협업자이름
		String cPwd = "aaa"; //협업자비밀번호
		
		List<CPT_Coworker> cl = CPT_CPTManager.cList.stream()
				.filter(c -> c.id.equals(cName) && c.pwd.equals(cPwd))
				.collect(Collectors.toList());
		
		List<P_Project> pl = CPT_CPTManager.pList.stream()
				.filter(p -> p.name.equals(pName))
				.collect(Collectors.toList());
		
		
		for(CPT_Coworker c : cl) {	
			for(P_Project p : pl) {
				if(p.workers == null) {
					p.workers = new ArrayList<>();
				}
				p.workers.add(c);
			}	
		}
		
		String packageName = "project";
		String date = "20230128";
		String filePath = "src\\oaadb\\" + packageName + "\\" + date + ".out";
		File file = new File(filePath);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Iterator<P_Project> pir = CPT_CPTManager.pList.iterator();
		while(pir.hasNext()) {
			P_Project p = pir.next();
			oos.writeObject(p);
		}
	}

}
