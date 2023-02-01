package project;

import java.io.IOException;

import util.CPTManager;
import util.EnvironmentConfigure;
import util.TempObjectReader;
import util.TempObjectWriter;

public class TestMain {

	public static void main(String[] args) {

		EnvironmentConfigure.createFrame(new ProjectSelectFrame("projectHistory"));
		
//		try {
//			TempObjectWriter.invoke();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
