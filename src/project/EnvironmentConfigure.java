package project;
import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class EnvironmentConfigure {
   
   public static String PROJECT_TITLE = "OneAndAll"; //프로젝트 제목
   public static int PROJECT_WIDTH = 1189; //프로젝트 너비
   public static int PROJECT_HEIGHT = 563; //프로젝트 높이
   
   //화면을 만들 때, Frame의 경계를 포함하지 않고 해당 너비 높이로 만들기 위해 작성
   public static void createFrame(JFrame frame) {
      int borderWidth = frame.getInsets().left + frame.getInsets().right;
      int borderHeight = frame.getInsets().top + frame.getInsets().bottom;
      frame.setSize(new Dimension(EnvironmentConfigure.PROJECT_WIDTH + borderWidth, 
                           EnvironmentConfigure.PROJECT_HEIGHT + borderHeight));
   }

   
   public void setWindowSize() {
	   EnvironmentConfigure.PROJECT_WIDTH = 1189;
	   EnvironmentConfigure.PROJECT_HEIGHT = 563;	   
   }
   public void setMacSize() {
	   EnvironmentConfigure.PROJECT_WIDTH = 1200;
	   EnvironmentConfigure.PROJECT_HEIGHT = 600;
   }
}