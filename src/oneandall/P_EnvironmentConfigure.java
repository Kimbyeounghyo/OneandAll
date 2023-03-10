package oneandall;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class P_EnvironmentConfigure {
   
   public static String PROJECT_TITLE = "OneAndAll"; //프로젝트 제목
   public static int PROJECT_WIDTH = 1189; //프로젝트 너비
   public static int PROJECT_HEIGHT = 563; //프로젝트 높이
   
   //화면을 만들 때, Frame의 경계를 포함하지 않고 해당 너비 높이로 만들기 위해 작성
   public static void createFrame(JFrame frame) {
      int borderWidth = frame.getInsets().left + frame.getInsets().right;
      int borderHeight = frame.getInsets().top + frame.getInsets().bottom;
      frame.setSize(new Dimension(P_EnvironmentConfigure.PROJECT_WIDTH + borderWidth, 
    		  P_EnvironmentConfigure.PROJECT_HEIGHT + borderHeight));
   }

   
   public void setWindowSize() {
	   P_EnvironmentConfigure.PROJECT_WIDTH = 1189;
	   P_EnvironmentConfigure.PROJECT_HEIGHT = 563;	   
   }
   public void setMacSize() {
	   P_EnvironmentConfigure.PROJECT_WIDTH = 1200;
	   P_EnvironmentConfigure.PROJECT_HEIGHT = 600;
   }
}