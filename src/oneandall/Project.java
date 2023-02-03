package oneandall;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Project implements Externalizable{
	
	public long projectId; //비교하기위한 값
	public String name; //프로젝트 이름
	public String content; //프로젝트 내용
	public Date startDate; //프로젝트 시작일
	public Date endDate; //프로젝트 마감일
	public List<Coworker> workers; //프로젝트 참여자
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String name, String content, String startDate, String endDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		this.projectId = new Date().getTime();
		this.name = name;
		this.content = content;
		try {
			this.startDate = sdf.parse(startDate);
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.workers = null;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(projectId);
		out.writeUTF(name);
		out.writeUTF(content);
		out.writeObject(startDate);
		out.writeObject(endDate);
		out.writeObject(workers);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		projectId = in.readLong();
		name = in.readUTF();
		content = (String)in.readUTF();
		startDate = (Date)in.readObject();
		endDate = (Date)in.readObject();
		workers = (List<Coworker>)in.readObject();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Long.hashCode(projectId);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Project) {
			Project p = (Project)obj;
			return name != null && name.equals(p.name);
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "-----" + projectId + "-----\n" + name + "\n" + content + "\n" + startDate + "\n" + endDate;
	}

	
	

}
