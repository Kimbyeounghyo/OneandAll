package TodoList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class JframeTest extends JFrame implements ActionListener{
	
	//TODO 전역변수 생성 부분
	static JframeTest mainActivity;
	static JLabel txt;
	//TODO 부모 프레임 생성
	static JFrame frm = new JFrame("프레임 창 메뉴바 생성");
	static JTextArea textarea = new JTextArea();
	static JTextField tf;
	
	//TODO 메인 메소드 시작 부분
	public static void main(String[] args) {
		
		JPanel p1 = new JPanel();
		tf=new JTextField(15);
		
		//TODO 클래스 객체 생성 (클릭 이벤트 위함)
		mainActivity = new JframeTest();
		
		
 
		//TODO 부모 프레임 크기 설정 (가로, 세로)
		frm.setSize(600	, 1200);
 
		//TODO 부모 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);
 
		//TODO 부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TODO 부모 프레임 창 크기 고정 실시
		frm.setResizable(false);
 
		//TODO 부모 레이아웃 설정
		frm.getContentPane().setLayout(null);
				
		frm.add(p1);
		//TODO 자식 레이아웃 [메뉴바] 생성
		JMenuBar menu = new JMenuBar(); //메뉴바 틀 설정

		
		JMenu schedule = new JMenu("스케쥴");
		JMenuItem groupSchedule = new JMenuItem("그룹 일정관리");
		JMenuItem personalSchedule = new JMenuItem("개인 일정관리");
		groupSchedule.addActionListener(mainActivity); //TODO 메뉴에 클릭이벤트 적용
		personalSchedule.addActionListener(mainActivity); //TODO 메뉴에 클릭이벤트 적용	
		schedule.add(groupSchedule);
		schedule.add(personalSchedule);
		
		menu.add(schedule);
		menu.setBounds(0, 0, 500, 30); //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		
		//TODO 자식 레이아웃 [라벨 텍스트] 생성
		txt = new JLabel("");
		txt.setBounds(0, 35, 500, 100); //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		txt.setFont(new Font("맑은 고딕", 0, 20)); //TODO 폰트 정의
		txt.setHorizontalAlignment(JLabel.CENTER); //TODO 텍스트 센터 표시 설정
				
		//TODO 부모 프레임에다가 자식 컴포넌트 추가
		frm.getContentPane().add(menu);
		frm.getContentPane().add(txt);
		
		//TODO 부모 프레임이 보이도록 설정
		frm.setVisible(true);
		
		
		
		
	}//메인 종료
	
	//TODO 버튼 클릭 이벤트 수행 부분
	@Override
	public void actionPerformed(ActionEvent e) { 
		//TODO Auto-generated method stub
			
		//TODO 컴포넌트에 정의된 text 받아오는역할 
		switch(e.getActionCommand()){
			
		//TODO getActionCommand() 버튼의 텍스트를 얻어옵니다
		case "그룹 일정관리": 
			
			
			txt.setText("그룹 일정"); 
			break;
			
		case "개인 일정관리": 
			//테이블
			JTableTest jtable = new JTableTest();
			jtable.setDefaultCloseOperation(EXIT_ON_CLOSE);
			txt.setText("개인 일정"); 
			break;	
			
		
		default :
			txt.setText("NO"); 
			break;
		}
	}
	

}//클래스 종료