package oneandall;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import oneandall.Coworker;
import oneandall.Project;
import oneandall.Task;

public class TempObjectReader {
	
	public static String packageName = "coworker";
	public static String date = "20230128";

	public static void invoke() throws IOException {
		
		String filePath = "src\\oaadb\\" + packageName + "\\" + date + ".out";

		File file = new File(filePath);

		//List 초기화
		switch(packageName.toLowerCase()) {
		case "project":
			CPTManager.pList = new ArrayList<Project>();
			break;
		case "coworker":
			CPTManager.cList = new ArrayList<Coworker>();
			break;
		case "task":
			CPTManager.tList = new ArrayList<Task>();
			break;
		}
		
		if(file.exists()) {
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				switch(packageName.toLowerCase()) {
				case "project":
					while(true) {
						CPTManager.pList.add((Project)ois.readObject());
					}
				case "coworker":
					while(true) {
						CPTManager.cList.add((Coworker)ois.readObject());
					}
				case "task":
					while(true) {
						CPTManager.tList.add((Task)ois.readObject());
					}
				}
			} catch(EOFException e) {
				
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				CPTManager.printList(packageName);
			}
			
		}else {
			System.out.println("없는 파일에 접근하여 아무것도 못했어요 ㅠㅠ");
		}
	}

}
