package oneandall;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oneandall.GroupFunction;
import oneandall.MemoFrame;
import ui.GreenButton;
import ui.PinkButton;
import ui.PinkRoundButton;
import ui.RedButton;
import ui.RoundTextArea;
import ui.RoundTextField;

public class GroupSchedule {
	public static void main(String[] args) {
		new CalendarGroup();
	}
}

class CalendarGroup extends JFrame implements ActionListener{
	

JFrame frame = new JFrame();
	
	
	//캘린더 영역
	Scanner sc = new Scanner(System.in);
	Container container = getContentPane();

	CalendarFunction cF = new CalendarFunction();
	
	GroupFunction gF= new GroupFunction();
	
	ImageIcon star = new ImageIcon("별.png");
	ImageIcon panelpng = new ImageIcon("패널.png");
	ImageIcon save = new ImageIcon("disk.png");
	ImageIcon reset = new ImageIcon("reset.png");
	
	
	//TODO Panel
	JPanel p_Month = new JPanel();
	JPanel p_Calendar = new JPanel();
	JPanel p_Center = new JPanel();
	JPanel p_South = new JPanel();
	JPanel p_West = new JPanel();
	JPanel p_North = new JPanel();
	JPanel Pchat = new JPanel();
	 
	JButton p_bar_G = new JButton();
	JButton p_bar_R = new JButton();
	JButton Calendar_bar = new JButton(star);
	
	JButton buttonBefore = new PinkRoundButton("<");
	JButton buttonAfter = new PinkRoundButton(">");
	//JButton delBarBtn = new GreenButton("추가");
	//JButton insBarBtn = new RedButton("삭제");
	
	JButton[] buttonsOfDay = new GreenButton[7];
	
	//label은 p_month에 담았음
	JLabel label = new JLabel("00년 0월");
	
	JLabel[] Label_Day = new JLabel[42];
	
	
	String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	String[] memberName = {"메뉴선택","전체일정", "A조", "B조", "C조"};
	JComboBox<String> jComboBox = new JComboBox<>(memberName);
   
	//TODO Default Color: PINK 
	Color bg = new Color(255, 188, 218);
	
	RoundTextArea c_textArea = new RoundTextArea();
	
   

	//입력상자
    JTextField tf = new RoundTextField();
	
	JTextField tf2 = new RoundTextField();
	
	JButton btn = new PinkButton("시작일");
	JButton endDateBtn = new PinkButton("종료일");
	
	
	public CalendarGroup() {
		setTitle("스케쥴 작성하기");
		setSize(1200, 600);//width height
		container.setBackground(Color.black);
		setLocationRelativeTo(null);
	    init();
		start();
		setVisible(true);
	}
	public void init() {
		
		 //----------------------------Menu----------------------------
		JPanel pMenu = new JPanel();
	      pMenu.setBounds(0, 0, 1200, 50);
	      pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      getContentPane().add(pMenu);
	      pMenu.setBackground(new Color(0, 0, 0));
	      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); //1행4열에 10공백
	      add(pMenu);
	      
	     
	      var home = new PinkButton("Home");
	      home.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mousePressed(MouseEvent e) {
					new OneandAll_Main();
					}
			
		});
	      
	      var login = new PinkButton("Logout");
	      login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				}
	      });
	     
	      
	      
	      var member = new PinkButton("Member");
	      member.addMouseListener(new MouseAdapter() {
	    	  
			@Override
			public void mouseExited(MouseEvent e) {
		
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				new _Tap2();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Member();
			}
	    	  
		});
	      
	      var project = new PinkButton("Project");
	      project.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      
	      var schedule = new PinkButton("Schedule");
	      schedule.addMouseListener(new MouseAdapter() {
	    	  @Override
				public void mouseEntered(MouseEvent e) {
					new _Tap2();
				}
		});
	      
	      
	      pMenu.add(home); 
	      pMenu.add(login);
	      pMenu.add(member);
	      pMenu.add(project);
	      pMenu.add(schedule);
	      
	      //----------------------------Menu----------------------------
	      
	      
	      
		//TODO container
		 container.setLayout(null);
		 container.add(p_Month);
		 container.add(p_Calendar);
		 container.add(p_Center);
		 container.add(p_South);
		 container.add(p_North);
		 container.add(p_West);
		 container.add(Pchat);
		 
		// container.add(p_bar_G);
		 //위치 관련 코드
		 p_North.setBounds(20,10,300,40);
		 p_North.setBackground(Color.BLACK);
		 
		 p_Month.setBounds(100,105,300,40);
		 p_Month.setBackground(Color.BLACK);
		 
		 p_Calendar.setBounds(500,80,650,380);
		 
		 p_Center.setBounds(92,150,300,240);
		 p_Center.setBackground(Color.black);
		 
		 
		
		 //panel_bar_Green을 줄인 말 : 달력에 스케쥴바
		 p_bar_G.setBackground(Color.GREEN);
		 p_bar_G.setVisible(true);
		 
		 p_Calendar.setBorder(BorderFactory.createEmptyBorder());
		 p_Calendar.setLayout(new GridLayout(7, 7, 7, 7));
		 p_Calendar.setBackground(Color.white);
		 //p_Calendar.setBorder(border);
		 
		 Calendar_bar.setBackground(bg);
		 Calendar_bar.setBounds(61,5,20,20);
		 Calendar_bar.setVisible(true);
		
		 
		
		 p_Month.setLayout(new FlowLayout());
		 p_Month.add(buttonBefore);
		 p_Month.add(label);
		 p_Month.add(buttonAfter);
		 
		 //개인일정 드랍다운 메뉴
		 p_West.add(jComboBox);
		 p_West.setBounds(80, 70, 140, 50);
		 p_West.setBackground(Color.BLACK);
		 
		
		 c_textArea.setBackground(Color.white);
		 //			int width, int height
		 c_textArea.setPreferredSize(new Dimension(300,200));
		 
		 //                              행 열 높이 행 갭

		
		
		
		 Font font = new Font("맑은고딕", Font.BOLD, 25);
		 //buttonAfter.setFont(font);
		 //buttonBefore.setFont(font);
		 label.setFont(font);
		 label.setOpaque(true); 
		 label.setBackground(Color.BLACK);
	     label.setForeground(bg);
		 
		 label.setText(cF.getCalText());
		 
		 Pchat.setBounds(50, 505, 1100, 30);
		 Pchat.setBackground(new Color(255, 198, 218));
		 Pchat.setLayout(null);
		 
		 
		 tf.setPreferredSize(new Dimension(35,23));
		 tf2.setPreferredSize(new Dimension(35,23));
		 
		 
		 //==========================▼▼▼▼▼ 이벤트 처리 소스코드 ▼▼▼▼=================================
		 
		 //그룹일정 등록 버튼
		 JTextField w_work = new RoundTextField();
		 w_work.setPreferredSize(new Dimension(300,30));
		 //서쪽 버튼 이벤트 로직
		 w_work.addKeyListener(new KeyAdapter() {
			
			 @Override
			 public void keyTyped(KeyEvent e) {

				
				 if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					 
				     //(추후 VO클래스를 통해 받아올 예정)
					 c_textArea.append(w_work.getText()+"\n");
					 
					 //텍스트필드 비워주고 포커스 이동
					 w_work.setText("");
					 w_work.requestFocus();
				 }
				
			 }
		});
		
		p_Center.add(w_work);
		 
		 //텍스트 상자가 주목 받을때 문자가 사라지고 아니면 문자가 나타나고
		 w_work.addFocusListener(new FocusListener() {
		
			@Override
			public void focusLost(FocusEvent e) {
			
				if(w_work.getText().equals("")) {
				 w_work.setText("여기에 일정을 입력해주세요");
				 
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(w_work.getText().equals("여기에 일정을 입력해주세요")) {
					 w_work.setText("");
					 
				}
				 System.out.println(jComboBox.getSelectedItem().toString());
			}
		});
		 
		 //TODO p_South 
		 p_Center.add(c_textArea);
		 p_South.setBounds(42,420,400,40);
		 p_South.setBackground(Color.black);
		 p_South.add(btn);
		 p_South.add(tf);
		 p_South.add(endDateBtn);
		 p_South.add(tf2);
		 
		 ImageIcon personal = new ImageIcon("solmember.png");
		 JButton personalbtn = new JButton(personal);
		 container.add(personalbtn);
		 personalbtn.setBounds(20,320,30,30); // 그룹버튼
		 personalbtn.setPreferredSize(new Dimension(10,25));
		 personalbtn.setBorder(BorderFactory.createEmptyBorder());
		 personalbtn.setBackground(null);

		 personalbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Calendarmain();
			}
		});
		 
		 
		 //리셋버튼
		 JButton resetBtn = new JButton(reset);
		 resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CalendarGroup();
				dispose();
			}
		 });
		 container.add(resetBtn);
		 resetBtn.setBounds(20,180,30,30); // 리셋버튼
		 resetBtn.setPreferredSize(new Dimension(10,25));
		 resetBtn.setBorder(BorderFactory.createEmptyBorder());
		 
		 
		
		 
		 
		//TODO SaveButton
		 JButton saveBtn = new JButton(save);
		 saveBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = c_textArea.getText();
					try {
						//FileDialog(save, load할때 사용되는 공통모듈(대화상자)
						FileDialog fd = new FileDialog(frame,"저장", FileDialog.SAVE);
						fd.setVisible(true);
						//System.out.println(fd.getDirectory()+fd.getFile());
						String path=fd.getDirectory()+fd.getFile();
						if(!message.equals("")) {//message에 데이터가 비워있지 않다면
							FileWriter fw = new FileWriter(path);
							BufferedWriter bw = new BufferedWriter(fw);
							
							bw.write(message);
							//FileDialog의 취소버튼을 누르지 않고 정상 저장
							//저장한 경우
							if(fd.getFile()!=null) {
								JOptionPane.showMessageDialog(frame,path+"\n 경로에 저장되었습니다.");
							}
							bw.close();
						}else {//TextArea에 기록할게 없다면
							JOptionPane.showMessageDialog(frame, "저장 할 내용이 없습니다.");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		 //			     	x	y width height								
		 saveBtn.setBounds(10,250,50,40); // 저장 버튼
		 saveBtn.setPreferredSize(new Dimension(10,25));		 
		 saveBtn.setBorder(BorderFactory.createEmptyBorder());
		 saveBtn.setBackground(null);
		 container.add(saveBtn);//저장버튼
		 
		
		 tf.setText("");
		 tf.requestFocus();
		 tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				 if(e.getKeyChar() == KeyEvent.VK_ENTER && tf2.getText().equals("")) {
					 JOptionPane.showMessageDialog(frame,"종료일을 입력해 주세요.");
				 }else if(e.getKeyChar() == KeyEvent.VK_ENTER) {
//					 c_textArea.append("2월 "+ tf.getText()+"일");
//					 c_textArea.append(tf2.getText()+"일까지 작업!"+"\n");
					 
					 
					 barMethod();
				 }	 	
				
				 System.out.println(jComboBox.getSelectedItem().toString());
			}
		 });
		 //텍스트필드 비워주고 포커스 이동
		 tf2.setText("");
		 tf2.requestFocus();
		 
		 tf2.addKeyListener(new KeyAdapter() {
			 //KeyEvent 모든 키보드 키가 들어있음
			 @Override
			 public void keyTyped(KeyEvent e) {
				 if(e.getKeyChar() == KeyEvent.VK_ENTER && tf.getText().equals("")) {
					 JOptionPane.showMessageDialog(frame,"시작일을 입력해 주세요.");
				 } else if(e.getKeyChar() == KeyEvent.VK_ENTER) {
//					 c_textArea.append("2월 "+ tf.getText()+"일");
//					 c_textArea.append(tf2.getText()+"일까지 작업!"+"\n");
					 barMethod();
				 }//if end
				 
//				 System.out.println(tf.getText());
//				 System.out.println(jComboBox.getSelectedItem().toString());
//				 System.out.println(tf2.getText());
				
			}
			 
		 });
		
		 //다음 달로 가면 일정 초기화가 되는 기능
			ActionListener cbtn = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clearLabelDay();
				}
			};
	     buttonBefore.addActionListener(cbtn);		 
		 buttonAfter.addActionListener(cbtn);
		 
		 
		 //========= 달력에 들어가는 소스 코드 ==========
		 
		 //월 화 수 목 금 토 일
		 for(int i=0;i<buttonsOfDay.length;i++) {
			 buttonsOfDay[i] = new GreenButton();
			 p_Calendar.add(buttonsOfDay[i]);
			 buttonsOfDay[i].setFont(new Font("SansSerif", Font.BOLD, 25));
			 buttonsOfDay[i].setText(dayNames[i]);
		 }
		 
		 // 1 2 3 4 5...
		 // 토, 일은 색이 다름
		 for(int i=0;i<Label_Day.length;i++) {
			 Label_Day[i] = new JLabel();
			 
			 p_Calendar.add(Label_Day[i]);
			 Label_Day[i].setFont(new Font("SansSerif", Font.PLAIN, 10));
			 Label_Day[i].setOpaque(true);//배경색을 적용하려면 필요함
			 Label_Day[i].setBackground(Color.white);
			 if(i%7 == 0) Label_Day[i].setForeground(Color.RED);
			 if(i%7 == 6) Label_Day[i].setForeground(Color.BLUE);
			
			
		 }
		 
		//----------------------------------------------------
	
		
		 cF.setButtons(Label_Day);
		 cF.calSet();
		//TODO ComboBox
		 jComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jComboBox.getSelectedItem().equals("A조")) {
					//JOptionPane.showMessageDialog(frame,"이것좀해주세요");
					loadSch();
					
				}
				else if(jComboBox.getSelectedItem().equals("B조")) {
					loadSch();
					
				}
				else if(jComboBox.getSelectedItem().equals("C조")) {
					loadSch();
					
				}
				else if(jComboBox.getSelectedItem().equals("전체일정")) {
					loadSch();
					personalSch("groupsch");
				}
				
			}
		});
		 
	}
	

	//개인 일정을 
	//2월 3일 으로 입력했을때 일을 가져와서 해당일자에 스케쥴이 저장되는 메소드 
	public void personalSch(String name) {//name = 파일 명
		try {
			Charset charset = Charset.forName("MS949");
			List<String> lines = Files.readAllLines(Paths.get(name),charset);
			System.out.println(lines);
			List<Integer> list = new ArrayList<>();
			for(String line : lines) {
				int day = 0;
				String todo = "";
				
				if(line.charAt(4)=='일') {//숫자가 아니면  1일 ~9일 사이
					//System.out.print(i.charAt(3));
					day = (int)line.charAt(3)-48;
					
					for(int i=6; i<line.length();i++) {
						todo += line.charAt(i);
					}
					
					if(list.contains(day)) {
						 //System.out.println("중복 발생 " );
						 tempH+=12;
					 }else if(!list.contains(day)) {
						// System.out.println("중복이 아니면 높이 초기화");
						 tempH=0;
					 }
					list.add(day);
				}else if(line.charAt(4)>=48&&line.charAt(4)<=57) { //10일 ~31일 사이
					
					//System.out.print(((int)i.charAt(3)-48)*10 +(int)i.charAt(4)-48);
					day = ((int)line.charAt(3)-48)*10 +(int)line.charAt(4)-48;
				
					for(int i=7; i<line.length();i++) {
						todo += line.charAt(i);
					}
					
					if(list.contains(day)) {
						 //System.out.println("중복 발생 " );
						 tempH+=12;
					 }else if(!list.contains(day)) {
						 //System.out.println("중복이 아니면 높이 초기화");
						 tempH=0;
					 }
					 list.add(day);
				}
				//System.out.println();
				
				c_textArea.append(line.toString()+"\n");//불러온 글을 텍스트 에리아에 올리는 로직
				
				if(tempH<12) {
					 p_bar_G=new PinkButton(todo);
					 p_bar_G.setBounds(14,tempH,70,12);
				}else if(tempH>=12 && tempH<24) {
					 p_bar_G=new GreenButton(todo);
					 p_bar_G.setBounds(14,tempH,70,12);
				}
				
				 Label_Day[day+2].setBackground(new Color(255,255,242));
				 Label_Day[day+2].add(p_bar_G);
			
				 
				 
				 
			}//for line end
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	
	//TODO BarMethod
	int tempH =0;//달력 중복 바 체크
	public void barMethod() {
		
		try {
		//버튼자료형 list
		List<JButton> list = new ArrayList<>();
		
		 for(int i=0; i<Label_Day.length;i++) {
			 int a = Integer.parseInt(tf2.getText());
			 int b = Integer.parseInt(tf.getText());
			 
			 //라벨값을 가져오는 메서드는 getText();
			 if(Label_Day[i].getText().equals(tf2.getText())) {

				 for(int j=0; j<=a-b;j++) {
				 Label_Day[i-j].setBackground(new Color(255,255,222));
				 Label_Day[i-j].setOpaque(true);
				 p_bar_G=new PinkButton();
				 list.add(p_bar_G);
				 	if(tempH<12) {
				 		Label_Day[i-j].setBackground(new Color(255,255,242));
				 	}else if(tempH>=12 && tempH<24) {
						 Label_Day[i-j].setBackground(new Color(255,255,228));
						 p_bar_G=new RedButton();
					 }else if(tempH>=24 && tempH <36) {
						 Label_Day[i-j].setBackground(new Color(255,255,232));
						 p_bar_G=new GreenButton();
					 }else if(tempH>=36 && tempH <48) {
						 Label_Day[i-j].setBackground(new Color(255,255,242));
						 p_bar_G=new GreenButton();
						 JOptionPane.showMessageDialog(frame,"더이상 입력불가");
						 tempH-=60;
					 	}
					 //바 크기 조정
				 p_bar_G.setBounds(14,tempH,70,12);
				 Label_Day[i-j].add(p_bar_G);
				 }//for j end
			 }
		 }//for i end
		 tempH+=12;
		 
		 //바를 클릭하면 일정 메모가 나옴
		 for(int i=0; i<list.size();i++) {
			 list.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new MemoFrame();
						}
				});
		 }
		}catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("유효하지 않은 형식");
			JOptionPane.showMessageDialog(frame,"시작일 : "+tf.getText()+"\n"+ "종료일 : " +tf2.getText()+"\n"+"올바른 형식이 아닙니다."
			+"\n"+"날짜 입력 형식은 숫자");
		}	
	}//bar Method
	
	public void clearLabelDay() {
		 for(int i=0;i<Label_Day.length;i++) {
			 Label_Day[i].setFont(new Font("SansSerif", Font.PLAIN, 10));
			 Label_Day[i].setOpaque(true);//배경색을 적용하려면 필요함
			 Label_Day[i].setBackground(Color.white);
			 Label_Day[i].removeAll();
		 }
	}
	//다음달 이전달 버튼
	public void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonAfter.addActionListener(this);
		buttonBefore.addActionListener(this);
	}
	
	public void loadSch() {
		c_textArea.setText("");
		clearLabelDay();
		//c_textArea.append(" "+jComboBox.getSelectedItem().toString()+"님의 일정관리 화면"+"\n");
	}
	
	//다음달 이전달 버튼 클릭시 기능 수행
	//gap만큼 공백
	@Override
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == buttonAfter) {				// 1달 후
			gap = 1;
		} else if(e.getSource() == buttonBefore ) {		// 1달 전
			gap = -1;
		}
		cF.allInit(gap);
		label.setText(cF.getCalText());		// 년월 글자 갱신		
		
	}	
	
}