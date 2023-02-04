package oneandall;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import oneandall.CPT_Coworker;
import oneandall.P_Project;
import oneandall.P_Task;

public class P_TempObjectWriter {

	public static void invoke() throws IOException {
		
		String packageName = "project";
		String date = "20230128";
		String filePath = "src\\oaadb\\" + packageName + "\\" + date + ".out";

		File file = new File(filePath);
		
		//List 초기화
		switch(packageName.toLowerCase()) {
		case "project":
			CPT_CPTManager.pList = new ArrayList<P_Project>();
			break;
		case "coworker":
			CPT_CPTManager.cList = new ArrayList<CPT_Coworker>();
			break;
		case "task":
			CPT_CPTManager.tList = new ArrayList<P_Task>();
			break;
		}
		
		//기존에 있던 데이터를 손상시키지 않기 위해 먼저 데이터를 로드한다.
		if(file.exists()) {
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				switch(packageName.toLowerCase()) {
				case "project":
					while(true) {
						CPT_CPTManager.pList.add((P_Project)ois.readObject());
					}
				case "coworker":
					while(true) {
						CPT_CPTManager.cList.add((CPT_Coworker)ois.readObject());
					}
				case "task":
					while(true) {
						CPT_CPTManager.tList.add((P_Task)ois.readObject());
					}
				}
			} catch(EOFException e) {
				//파일의 끝임으로부터 일어나는 오류는 의도된 것이므로 아무것도 출력하지 않는다.
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		P_TempObjectReader.invoke();
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//new Project("캐치독", "강아지, 고양이 입양 웹페이지", "20230101", "20230115");
		//new Project("찰리서커스", "고전 레트로 게임, 레벨디자인 포함", "20221222", "20231231");
		//new Project("솔라시스템", "실제 거리를 바탕으로, 태양계 구성 및 카메라이동", "20221101", "20231115");
		//new Project("페인트툰", "언리얼 엔진을 이용하여 물감을 벽에 칠하고 많이 칠한팀이 승리", "20221101", "20231115");
		//new Coworker("teamleaderkim", "aaa", "김팀장", "팀장");
		Object o = new P_Project("페인트툰", "언리얼 엔진을 이용하여 물감을 벽에 칠하고 많이 칠한팀이 승리", "20221101", "20231115");
		P_Project pj = (P_Project) o;
		pj.workers = new ArrayList<CPT_Coworker>() ;
		pj.workers.add(CPT_CPTManager.cList.get(0));
		switch(packageName.toLowerCase()) {
		case "project":
			CPT_CPTManager.pList.add((P_Project)o);
			break;
		case "coworker":
			CPT_CPTManager.cList.add((CPT_Coworker)o);
			break;
		case "task":
			CPT_CPTManager.tList.add((P_Task)o);
			break;
		}	
		
		Iterator<P_Project> pir = null;
		Iterator<CPT_Coworker> cir = null; 
		Iterator<P_Task> tir = null;
		
		if(o instanceof P_Project) {
			pir = CPT_CPTManager.pList.iterator();
			while(pir.hasNext()) {
				P_Project p = pir.next();
				oos.writeObject(p);
			}
		} else if(o instanceof CPT_Coworker) {
			cir = CPT_CPTManager.cList.iterator();
			while(cir.hasNext()) {
				CPT_Coworker p = cir.next();
				oos.writeObject(p);
			}
		} else if(o instanceof P_Task) {
			tir = CPT_CPTManager.tList.iterator();
			while(tir.hasNext()) {
				P_Task p = tir.next();
				oos.writeObject(p);
			}
		}
	}

}
