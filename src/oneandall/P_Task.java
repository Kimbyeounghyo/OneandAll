package oneandall;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class P_Task implements Externalizable{
	
	public long taskId; //비교하기위한 값
	public String projectName; //프로젝트 이름 @ id
	public String content; //업무내용
	public CPT_Coworker worker; //회원 이름 @ 태그
	public Date startDate; //시작일
	public Date endDate; //종료일
	public long priorTaskIds; //선행업무
	
	public P_Task() {
		// TODO Auto-generated constructor stub
	}

	public P_Task(String projectName, String content, CPT_Coworker worker, String startDate, String endDate,
			long priorTaskIds) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		this.taskId = new Date().getTime();
		this.projectName = projectName;
		this.content = content;
		this.worker = worker;
		try {
			this.startDate = sdf.parse(startDate);
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.priorTaskIds = priorTaskIds;
	}
	
	



	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(taskId);
		out.writeUTF(projectName);
		out.writeUTF(content);
		out.writeObject(worker);
		out.writeObject(startDate);
		out.writeObject(endDate);
		out.writeLong(priorTaskIds);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		taskId = in.readLong();
		projectName = in.readUTF();
		content = in.readUTF();
		worker = (CPT_Coworker)in.readObject();
		startDate = (Date)in.readObject();
		endDate = (Date)in.readObject();
		priorTaskIds = in.readLong();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof P_Task) {
			P_Task t = (P_Task)obj;
			return taskId == t.taskId;
		}
		return false;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	

}
