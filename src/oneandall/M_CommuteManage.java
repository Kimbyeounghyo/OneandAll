package oneandall;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import customComponent.PinkScroll;

public class M_CommuteManage extends JFrame {
	LocalDateTime now;
	String formatedNow;
	String ymd;
	String hm;

	public M_CommuteManage() {

		setTitle("One and All");
		setSize(1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setBackground(Color.black);
		setLayout(null);

		now = LocalDateTime.now();
		// System.out.println(now);
		formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 "));
		// System.out.println(formatedNow);
		ymd = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		hm = now.format(DateTimeFormatter.ofPattern("HH시 mm분"));

		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 1200, 50);
		pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(pMenu);
		pMenu.setBackground(new Color(0, 0, 0));
		pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행5열에 10공백
		add(pMenu);

		var home = new UI_PinkButton("Home");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new _Home();
			}

		});

		var login = new UI_PinkButton("Login");
		login.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new _Login();
			}

		});

		var member = new UI_PinkButton("Member");
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

			}

		});

		var project = new UI_PinkButton("Project");
		project.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				new _Tap2();
			}
		});

		var schedule = new UI_PinkButton("Schedule");
		schedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				new _Tap2();
			}
		});

		pMenu.add(home);
		pMenu.add(member);
		pMenu.add(project);
		pMenu.add(schedule);
		pMenu.add(login);
		// 전체패널
		JPanel Pn1 = new JPanel();
		Pn1.setBounds(0, 50, 1200, 1200);
		Pn1.setBackground(Color.black);
		Pn1.setLayout(null);

		// 출퇴근기록 패널
//		JPanel pCommute = new JPanel();
//		pCommute.setBackground(Color.BLACK);
//		pCommute.setLayout(new BorderLayout());
//		pCommute.setBounds(50, 70, 1100, 380);
		Font font = new Font("함초롱바탕", Font.PLAIN, 20);
		// 왼쪽 출근 패널
		JPanel PLeft = new JPanel();
		PLeft.setBounds(50, 70, 580, 380);
		PLeft.setBackground(Color.CYAN);
		PLeft.setLayout(new BorderLayout());

		JTextArea taLeft = new JTextArea();
		taLeft.setBounds(0, 0, 580, 380);
		taLeft.setBackground(Color.BLACK);
		taLeft.setFont(font);
		taLeft.setForeground(Color.WHITE);
		taLeft.setLineWrap(true);
		taLeft.setEditable(true); // false로 바꾸기
		// ta.setBorder(new LineBorder(Color.black));

		PinkScroll scrollL = new PinkScroll(taLeft) {
			@Override
			public void setBorder(Border border) {
			}
		};
		scrollL.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PLeft.add(scrollL);

		//왼쪽패널에 파일 불러오기
//	      try {
//			  Charset cs = Charset.forName("UTF-8");
//	          List<String> addList = Files.readAllLines(Paths.get("RecordIn.txt"),cs);
//	          System.out.println(addList);
//	          for(String i : addList) {
//	        	  taLeft.append(i.toString()+"\n");
//	          }
//	       } catch (IOException e2) {
//	          e2.printStackTrace();
//	       }
		// 오른쪽 퇴근, 조퇴 패널
		JPanel PRight = new JPanel();
		PRight.setBounds(650, 70, 500, 380);
		PRight.setBackground(Color.CYAN);
		PRight.setLayout(new BorderLayout());
		JTextArea taRight = new JTextArea();

		taRight.setBackground(Color.BLACK);
		taRight.setFont(font);
		taRight.setForeground(Color.WHITE);
		taRight.setLineWrap(true);
		taRight.setEditable(true); // false로 바꾸기
		// ta.setBorder(new LineBorder(Color.black));
		
		PinkScroll scrollR = new PinkScroll(taRight) {
			@Override
			public void setBorder(Border border) {
			}
		};
		scrollR.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PRight.add(scrollR);
		
		//오른쪽패널에 파일 불러오기
//	      try {
//			  Charset cs = Charset.forName("UTF-8");
//	          List<String> addList = Files.readAllLines(Paths.get("RecordOut.txt"),cs);
//	          System.out.println(addList);
//	          for(String i : addList) {
//	        	  taRight.append(i.toString()+"\n");
//	          }
//	       } catch (IOException e2) {
//	          e2.printStackTrace();
//	       }
		

		// 팀원 선택
//		JPanel pChoice = new JPanel();
//		pChoice.setBounds(300, 10, 90, 40);
		Choice cMember = new Choice();
		cMember.setBounds(50, 15, 120, 40);
		cMember.setFont(new Font("맑은고딕", Font.PLAIN, 16));
		// 팀원 부를 때 회원가입한 사람들 불러오기
		
		//예시 멤버 (나중에 지우기)
		cMember.add("Jungwoo");
		cMember.add("Mark");
		cMember.add("Jeno");
		cMember.add("Jaemin");
		cMember.add("Doyoung");
		
		// Choice에서 멤버 선택하면 해당 멤버 파일 부르기
		cMember.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				taLeft.setText("");
				taRight.setText("");
				
				File f1 = new File(cMember.getSelectedItem() + ".txt");
				File f2 = new File(cMember.getSelectedItem() + "(2).txt");
				if(f1.exists()) {
					FileReader fr;
					try {
						fr = new FileReader(f1);
						BufferedReader br = new BufferedReader(fr);
						String readData;
						
						while((readData = br.readLine()) != null) {
							System.out.println(readData);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					
					try {
						  Charset cs = Charset.forName("UTF-8");
				          List<String> addList = Files.readAllLines(Paths.get(cMember.getSelectedItem() + ".txt"),cs);
				          System.out.println(cMember.getSelectedItem() + "출근 파일 로드");
				          for(String i : addList) {
				        	  taLeft.append(i.toString()+"\n");
				          }
				       } catch (IOException e2) {
				          e2.printStackTrace();
				       }
				}else {
					System.out.println("파일 없음");
				}
				
				if(f2.exists()) {
					FileReader fr;
					try {
						fr = new FileReader(f2);
						BufferedReader br = new BufferedReader(fr);
						String readData;
						
						while((readData = br.readLine()) != null) {
							System.out.println(readData);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					
					try {
						  Charset cs = Charset.forName("UTF-8");
				          List<String> addList = Files.readAllLines(Paths.get(cMember.getSelectedItem() + "(2).txt"),cs);
				          System.out.println(cMember.getSelectedItem() + "퇴근/조퇴 파일 로드");
				          for(String i : addList) {
				        	  taRight.append(i.toString()+"\n");
				          }
				       } catch (IOException e2) {
				          e2.printStackTrace();
				       }
				}else {
					System.out.println("파일 없음");
				}
			}
		});
		
		// pChoice.add(cMember);

		// 출근버튼
		JButton C1 = new UI_PinkButton("출 근");
		C1.setBounds(655, 10, 120, 40);

		// 출근 버튼 누르면 파일에 저장돼서 taLeft에 출력
		C1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));

				File file = new File(cMember.getSelectedItem() + ".txt");
				FileWriter fw = null;

				try {
					fw = new FileWriter(file, true);
					fw.write(ymd + "\t" + "출근" + "\t" + hm);
					fw.write("\r\n");
					fw.flush();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"[" + cMember.getSelectedItem() + "] \n" + formatedNow + "\n" + "출근");
				System.out.println(formatedNow);

				taLeft.setText(""); // 저장버튼 누르면 왼쪽 비워지고 다시 채워짐

				try {
					Charset cs = Charset.forName("UTF-8");
					List<String> addList = Files.readAllLines(Paths.get(cMember.getSelectedItem() + ".txt"), cs);
					System.out.println(cMember.getSelectedItem() + "출근 파일 로드");
					for (String i : addList) {
						taLeft.append(i.toString() + "\n");
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});

		// 퇴근 또는 조퇴 버튼 누르면 파일에 저장돼서 taRight에 출력
		JButton C2 = new UI_PinkButton("퇴 근");
		C2.setBounds(825, 10, 120, 40);
		C2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));
				
				File file = new File(cMember.getSelectedItem() + "(2).txt");
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(file, true);
					fw.write("퇴근" + "\t" + hm);
					fw.write("\r\n");
					fw.flush();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"[" + cMember.getSelectedItem() + "] \n" + formatedNow + "\n" + "퇴근");
				System.out.println(formatedNow);

				taRight.setText(""); // 저장버튼 누르면 왼쪽 비워지고 다시 채워짐

				try {
					Charset cs = Charset.forName("UTF-8");
					List<String> addList = Files.readAllLines(Paths.get(cMember.getSelectedItem() + "(2).txt"), cs);
					System.out.println(cMember.getSelectedItem() + "퇴근/조퇴 파일 로드");
					for (String i : addList) {
						taRight.append(i.toString() + "\n");
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		// 퇴근 또는 조퇴 버튼 누르면 파일에 저장돼서 taRight에 출력
		JButton C3 = new UI_PinkButton("조 퇴");
		C3.setBounds(995, 10, 120, 40);
		C3.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				UIManager.put("Button.background", new Color(255, 198, 218));
				UIManager.put("OptionPane.background", new Color(255, 198, 218));
				UIManager.put("Panel.background", new Color(255, 198, 218));

				File file = new File(cMember.getSelectedItem() + "(2).txt");
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(file, true);
					fw.write("조퇴" + "\t" + hm);
					fw.write("\r\n");
					fw.flush();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"[" + cMember.getSelectedItem() + "] \n" + formatedNow + "\n" + "조퇴");
				System.out.println(formatedNow);

				taRight.setText(""); // 저장버튼 누르면 왼쪽 비워지고 다시 채워짐

				try {
					Charset cs = Charset.forName("UTF-8");
					List<String> addList = Files.readAllLines(Paths.get(cMember.getSelectedItem() + "(2).txt"), cs);
					System.out.println(cMember.getSelectedItem() + "퇴근/조퇴 파일 로드");
					for (String i : addList) {
						taRight.append(i.toString() + "\n");
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		Pn1.add(C1);
		Pn1.add(C2);
		Pn1.add(C3);

		// 채팅패널
		JPanel Pchat = new JPanel();
		Pchat.setBounds(50, 475, 1100, 30);
		Pchat.setBackground(new Color(255, 198, 218));
		Pchat.setLayout(null);

		// Pn1.add(pChoice);
		Pn1.add(cMember);
		// Pn1.add(pCommute);
		Pn1.add(Pchat);
		Pn1.add(PLeft);
		Pn1.add(PRight);
		add(Pn1);

		setVisible(true);

	}

	public static void main(String[] args) {

		new M_CommuteManage();

	}

}
