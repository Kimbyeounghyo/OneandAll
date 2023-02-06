package oneandall;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import oneandall.CPT_Coworker;
import oneandall.P_Project;
import oneandall.P_Task;

public class CPT_CPTManager implements Runnable{
	
	public static List<P_Project> pList;  //프로젝트들
	public static List<CPT_Coworker> cList; //팀원들
	public static List<P_Task> tList;		//업무들
	public static P_Task clipBoard; //복사본
	
	public static Object findObject(Object o) {
		
		if(o instanceof P_Project) {
			Iterator<P_Project> pir = pList.iterator();
			while(pir.hasNext()) {
				P_Project dest = pir.next();
				if(dest.equals(o)) {
					return dest;
				}
			}
		} else if(o instanceof CPT_Coworker) {
			Iterator<CPT_Coworker> cir = cList.iterator();
			while(cir.hasNext()) {
				CPT_Coworker dest = cir.next();
				if(dest.equals(o)) {
					return dest;
				}
			}
		} else if(o instanceof P_Task) {
			Iterator<P_Task> tir = tList.iterator();
			while(tir.hasNext()) {
				P_Task dest = tir.next();
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
			Iterator<P_Project> pir = pList.iterator();
			while(pir.hasNext()) {
				System.out.println(pir.next());
			}
		} else if("coworker".equals(className)) {
			Iterator<CPT_Coworker> cir = cList.iterator();
			while(cir.hasNext()) {
				System.out.println(cir.next());
			}
		} else if("task".equals(className)) {
			Iterator<P_Task> tir = tList.iterator();
			while(tir.hasNext()) {
				System.out.println(tir.next());
			}
		}
	}
	
	//oaadb에서 특정 패키지의 파일로부터 데이터를 list에 불러오는 메소드
	public static void getFromOaaDB(String objectName) {
		
		//특정 패키지의 경로
		String filePath = "src" + File.separator + "oaadb" + File.separator + objectName.toLowerCase() + File.separator;
		File targetFile = null;
		
		targetFile = new File(getFileNameFromPackage(filePath));
		System.out.println(targetFile.getAbsolutePath());
		if(!targetFile.exists()) {
			System.out.println("불러올 데이터가 없습니다");
			return;
		}
		
		//List 초기화
		switch(objectName.toLowerCase()) {
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
						CPT_CPTManager.pList.add((P_Project)ois.readObject());
						break;
					case "coworker":
						CPT_CPTManager.cList.add((CPT_Coworker)ois.readObject());
						break;
					case "task":
						CPT_CPTManager.tList.add((P_Task)ois.readObject());
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
		getFromOaaDB("Task");
	}
	
	//oaadb 패키지 하위 파일을 불러오는 메소드
	//path : 패키지 경로(파일은 포함하면 안된다)
	private static String getFileNameFromPackage(String path) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		File file = new File(path);
		//가장 최근에 저장한 파일을 불러온다
		File[] files = file.listFiles();
		if(files.length == 0) {
			return path + sdf.format(now) + ".out";
		} else {
			//날짜별로 파일을 저장했으므로, 가장 최근 파일을 불러온다
			return files[files.length - 1].getAbsolutePath();
		}
	}
	
	public static String getNewFileNameFromPackage(String path) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		System.out.println(path);
		
		File file = new File(path);
		File[] files = file.listFiles();
		File targetFile;
		String newFileName;
		if(files.length != 0) {
			targetFile = files[files.length - 1];
			//오늘자 파일이 이미 있으면
			if(targetFile.getName().indexOf(sdf.format(now)) > -1) {
				String[] currentName = targetFile.getName().split("\\.");
				newFileName = currentName[0] + "z.out";
			}else {
				newFileName = sdf.format(now) + ".out";
			}			
		}else {
			newFileName = sdf.format(now) + ".out";
		}
		System.out.println(newFileName);
		return newFileName;
	}
	
	public static void save(String path) throws IOException {
		File f = new File(path + getNewFileNameFromPackage(path));
		
		FileOutputStream fos = new FileOutputStream(f, false);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Iterator<P_Project> pir = null;
		Iterator<CPT_Coworker> cir = null;
		Iterator<P_Task> tir = null;		
		switch (path.split("\\" + File.separator)[2]) {
		case "coworker":
			if(cList == null || cList.size() == 0) {
				FileChannel.open(Paths.get(f.getAbsolutePath()), StandardOpenOption.WRITE).truncate(0).close();
				break;
			}
			cir = cList.iterator();
			while(cir.hasNext()) {
				oos.writeObject(cir.next());
			}
			break;
		case "project":
			if(pList == null || pList.size() == 0) {
				FileChannel.open(Paths.get(f.getAbsolutePath()), StandardOpenOption.WRITE).truncate(0).close();
				break;
			}
			pir = pList.iterator();
			while(pir.hasNext()) {
				oos.writeObject(pir.next());
			}
			break;
		case "task":
			if(tList == null || tList.size() == 0) {
				FileChannel.open(Paths.get(f.getAbsolutePath()), StandardOpenOption.WRITE).truncate(0).close();
				break;
			}
			tir = tList.iterator();
			while(tir.hasNext()) {
				oos.writeObject(tir.next());
			}
			break;
		}
	}
	
	public static void saveAll() {
		try {
			CPT_CPTManager.save("src" + File.separator + "oaadb" + File.separator + "project" + File.separator);
			CPT_CPTManager.save("src" + File.separator + "oaadb" + File.separator + "coworker" + File.separator);
			CPT_CPTManager.save("src" + File.separator + "oaadb" + File.separator + "task" + File.separator);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<P_Task> getTasksFromProject(P_Project p) {
		if(CPT_CPTManager.tList == null) return null;
		
		CPT_CPTManager.tList.stream().forEach(c -> System.out.println("getTasksFromProject >>> : " + c.taskId));
		
		List<P_Task> tl = CPT_CPTManager.tList.stream()
				.filter(t -> t.projectName.equals(p.name + "@" + p.projectId))
				.collect(Collectors.toList());
		
		if(tl.size() == 0) return null;
		
		return tl;
		
	}

	public static List<CPT_Coworker> getTeamLeaders() {
		List<CPT_Coworker> cl = CPT_CPTManager.cList.stream()
				.filter(c -> c.grade.equals("팀장"))
				.collect(Collectors.toList());
		
		if(cl.size() == 0) return null;
		
		return cl;
	}
	
	public static List<P_Task> findTaskByPriorId(long id) {
		List<P_Task> tl = new ArrayList<P_Task>();
		if(CPT_CPTManager.tList == null || CPT_CPTManager.tList.size() == 0) return null;
		
		while(id != -1) {
			final long fid = id;
			List<P_Task> tempTl = CPT_CPTManager.tList.stream()
					.filter(t -> t.taskId == fid)
					.collect(Collectors.toList());
			if(tempTl == null || tempTl.size() == 0) {
				id = -1; break;
			}
			P_Task t = tempTl.get(0);
			if(t.priorTaskIds == 0) id = -1;
			else id = t.priorTaskIds;
			tl.add(0, t);
		}
		
		return tl;
	}
	
	public static P_Task findTaskById(long id) {
		if(CPT_CPTManager.tList == null || CPT_CPTManager.tList.size() == 0) return null;
		
		for(P_Task t : CPT_CPTManager.tList) {
			if(t.taskId == id) return t;
		}
		
		return null;
	}

	@Override
	public void run() {
		saveAll();
	}
}
