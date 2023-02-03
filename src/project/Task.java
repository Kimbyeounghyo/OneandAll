package project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.List;

public class Task implements Externalizable{
	
	String projectName; //프로젝트 이름
	String content; //업무내용
	Coworker worker; //수행자 이름 + 태그
	Date startDate; //시작일
	Date endDate; //종료일
	List<Task> priorTasks; //선행업무

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	

}
