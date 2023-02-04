package oneandall;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import oneandall.CPT_Coworker;
import oneandall.P_Project;
import oneandall.P_Task;

public class P_TempObjectReader {
	
	public static String packageName = "coworker";
	public static String date = "20230128";

	public static void invoke() throws IOException {
		
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
				
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				CPT_CPTManager.printList(packageName);
			}
			
		}else {
			System.out.println("없는 파일에 접근하여 아무것도 못했어요 ㅠㅠ");
		}
	}

}
