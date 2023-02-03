package project;

import java.io.IOException;

import oneandall.EnvironmentConfigure;
import oneandall.TempObjectReader;
import oneandall.TempObjectWriter;
import util.CPTManager;

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
