package oneandall;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class CPT_Coworker implements Externalizable {
	
	public long tag; //이름이 중복될 경우, 구분하기위한 코드
	public String id; //id
	public String pwd; //비밀번호
	public String name; //이름
	public String grade; //직위(팀장, 부팀장, 팀원)
	//
	public CPT_Coworker() {
		// TODO Auto-generated constructor stub
	}
	
	public CPT_Coworker(String id, String pwd, String name, String grade) {
		this.tag = new Date().getTime();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.grade = grade;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(tag);
		out.writeUTF(id);
		out.writeUTF(pwd);
		out.writeUTF(name);
		out.writeUTF(grade);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		tag = in.readLong();
		id = in.readUTF();
		pwd = in.readUTF();
		name = in.readUTF();
		grade = in.readUTF();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Long.hashCode(tag);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CPT_Coworker) {
			CPT_Coworker c = (CPT_Coworker)obj;
			return (name + tag).equals(c.name + c.tag);
		}
		return false;
	}

	@Override
	public String toString() {
		return "-----" + tag + "-----" + "\n" + id + "\n" + pwd + "\n" + name + "\n" + grade;
	}
	
	

}
