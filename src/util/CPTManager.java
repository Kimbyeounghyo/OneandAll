package util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import project.Coworker;
import project.Project;
import project.Task;

public class CPTManager {
	
	public static List<Project> pList;  //프로젝트들
	public static List<Coworker> cList; //팀원들
	public static List<Task> tList;		//업무들
	public static Task clipBoard; //복사본
	
	public static Object findObject(Object o) {
		
		if(o instanceof Project) {
			Iterator<Project> pir = pList.iterator();
			while(pir.hasNext()) {
				Project dest = pir.next();
				if(dest.equals(o)) {
					return dest;
				}
			}
		} else if(o instanceof Coworker) {
			Iterator<Coworker> cir = cList.iterator();
			while(cir.hasNext()) {
				Coworker dest = cir.next();
				if(dest.equals(o)) {
					return dest;
				}
			}
		} else if(o instanceof Task) {
			Iterator<Task> tir = tList.iterator();
			while(tir.hasNext()) {
				Task dest = tir.next();
				if(dest.equals(o)) {
					return dest;
				}
			}
		}
		return null;
	}
	
	public static void printList(String className) {
		
		className = className.toLowerCase();
		
		if("project".equals(className)) {
			Iterator<Project> pir = pList.iterator();
			while(pir.hasNext()) {
				System.out.println(pir.next());
			}
		} else if("coworker".equals(className)) {
			Iterator<Coworker> cir = cList.iterator();
			while(cir.hasNext()) {
				System.out.println(cir.next());
			}
		} else if("task".equals(className)) {
			Iterator<Task> tir = tList.iterator();
			while(tir.hasNext()) {
				System.out.println(tir.next());
			}
		}
	}
	
	//oaadb에서 특정 패키지의 파일로부터 데이터를 list에 불러오는 메소드
	public static void getFromOaaDB(String objectName) {
		
		//특정 패키지의 경로
		String filePath = "src\\oaadb\\" + objectName.toLowerCase() + "\\";
		File targetFile = getFileFromPackage(filePath);
		
		//파일의 크기가 0이면 데이터가 없어 파일을 새로 생성한 것이므로 아무것도 일어나지 않는다.
		try {
			long fileSize = Files.size(Paths.get(targetFile.getPath()));
			if(fileSize == 0) {
				System.out.println("새 파일을 생성했습니다 불러올 데이터가 없습니다");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//List 초기화
		switch(objectName.toLowerCase()) {
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
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(targetFile);
			ois = new ObjectInputStream(fis);
			
			//매개변수에 따라 list에 대상파일의 처음부터 끝까지 데이터를 집어넣는다
			while(true) {
				if(ois != null) {
					switch(objectName.toLowerCase()) {
					case "project":
						CPTManager.pList.add((Project)ois.readObject());
						break;
					case "coworker":
						CPTManager.cList.add((Coworker)ois.readObject());
						break;
					case "task":
						CPTManager.tList.add((Task)ois.readObject());
						break;
					}
				}else
					break;
			}
		} catch(EOFException e) {
			//파일의 끝임으로부터 일어나는 오류는 의도된 것이므로 아무것도 출력하지 않는다.
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//oaadb의 하위 모든 패키지 최근 파일로부터 데이터를 list에 불러오는 메소드
	public static void getFromOaaDB() {
		getFromOaaDB("Project");
		getFromOaaDB("Coworker");
		//getFromOaaDB("Task");
	}
	
	//oaadb 패키지 하위 파일을 불러오는 메소드
	//path : 패키지 경로(파일은 포함하면 안된다)
	private static File getFileFromPackage(String path) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		File targetFile = null;
		File file = new File(path);
		//가장 최근에 저장한 파일을 불러온다
		File[] files = file.listFiles();
		if(files.length == 0) {
			File newFile = new File(path + sdf.format(now));
			
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			targetFile = newFile;
		} else {
			targetFile = files[files.length - 1]; //날짜별로 파일을 저장했으므로, 가장 최근 파일을 불러온다
		}
		
		return targetFile;
	}
	
	public static String getNewFileNameFromPackage(String path) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		File file = new File(path);
		File[] files = file.listFiles();
		File targetFile;
		String newFileName;
		if(files.length != 0) {
			targetFile = files[files.length - 1];
			//오늘자 파일이 이미 있으면
			if(targetFile.getName().indexOf(sdf.format(now)) > -1) {
				String[] currentName = targetFile.getName().split("\\.");
				newFileName = currentName[0] + "z";
			}else {
				newFileName = targetFile.getName();
			}			
		}else {
			newFileName = sdf.format(now);
		}
		
		return newFileName;
	}
	
	public static void saveProjects() throws IOException {
		String filePath = "src\\oaadb\\project\\";
		File f = new File(filePath + getNewFileNameFromPackage(filePath));
		
		Iterator<Project> pir = pList.iterator();
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		while(pir.hasNext()) {
			oos.writeObject(pir.next());
		}
	}
	
	public static void getTasksFromProject(Project p) {
		
	}
	
	public static void getPeopleNotJoin(Project p) {
		
	}

}
