package oneandall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import customComponent.PinkLabel;
import customComponent.PinkScroll;

public class M_AddMember extends JFrame {

   JTextField tName; // 팀원 이름 받기
   JRadioButton rb1; // 직급 선택(팀장)
   JRadioButton rb2; // 직급 선택(부팀장)
   JRadioButton rb3; // 직급 선택(팀원)
   JTextField tTel; // 전화번호 받기
   JButton saveBtn; // 저장 버튼   
   String grade; // 버튼 누르면 grade에 직함 저장
   
  
   public M_AddMember() {

      setTitle("One and All");
      setSize(1200, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(true);
      setBackground(Color.black);
      setLayout(null);

      JPanel pMenu = new JPanel();
      pMenu.setBounds(0, 0, 1200, 50);
      pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      getContentPane().add(pMenu);
      pMenu.setBackground(new Color(0, 0, 0));
      pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행 4열에 10공백
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

      // 왼쪽안쪽패널
      JPanel PlefIn = new JPanel();
      PlefIn.setBounds(50, 20, 500, 430);
      PlefIn.setBackground(new Color(255, 198, 218));
      PlefIn.setLayout(null);
      
      // 왼쪽안쪽패널(JTextArea)
      JPanel Pta = new JPanel();
      Pta.setBounds(0, 40, 500, 390);
      Pta.setLayout(new BorderLayout());
           
      JTextArea ta = new JTextArea();
      ta.setBackground(new Color(255, 198, 218));
      ta.setBounds(0, 0, 500, 390);
      ta.setFont(new Font("함초롱바탕", Font.PLAIN, 20));
      ta.setLineWrap(true);
      ta.setEditable(false);
      
      PinkScroll scroll = new PinkScroll(ta) {
         @Override
            public void setBorder(Border border) {
          } 
      };
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      Pta.add(scroll);
      

      // 왼쪽안쪽패널 -> 상단버튼
      JPanel pL = new JPanel();
      pL.setBounds(50, 20, 500, 40);
      pL.setBackground(Color.BLACK);
      pL.setLayout(new GridLayout(1, 3, 5, 0));
      pL.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

      var btL1 = new PinkLabel("List");
      btL1.setBackground(new Color(255, 198, 218));
      // btL1.setBorderPainted(false);

      JLabel btL2 = new JLabel();
      btL2.setBackground(Color.BLACK);

      JLabel btL3 = new JLabel();
      btL3.setBackground(Color.BLACK);

      pL.add(btL1);
      pL.add(btL2);
      pL.add(btL3);

      // 채팅패널
      JPanel Pchat = new JPanel();
      Pchat.setBounds(50, 475, 1100, 30);
      Pchat.setBackground(new Color(255, 198, 218));
      Pchat.setLayout(null);

      // 오른쪽안쪽패널 -> 멤버추가
      JPanel PrgIn = new JPanel();
      PrgIn.setBounds(650, 20, 500, 430);
      PrgIn.setBackground(new Color(255, 198, 218));
      PrgIn.setLayout(null);

      Font font = new Font("맑은고딕", Font.BOLD, 20);
      JLabel lName = new JLabel("이름");
      lName.setBounds(40, 65, 100, 40);
      lName.setFont(font);
      PrgIn.add(lName);

      tName = new JTextField(6);
      Font tfFont = new Font("함초롱바탕", Font.PLAIN, 18);
      tName.setBounds(40, 110, 120, 40);
      tName.setBackground(Color.LIGHT_GRAY);
      tName.setFont(tfFont);
      tName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      PrgIn.add(tName);

      JLabel lGrade = new JLabel("직급");
      lGrade.setBounds(40, 170, 100, 40);
      lGrade.setFont(font);
      PrgIn.add(lGrade);
      // 직급선택버튼
      JPanel pRBtn = new JPanel();
      pRBtn.setBackground(new Color(255, 198, 218));
      pRBtn.setBounds(690, 240, 420, 40);
      pRBtn.setLayout(new GridLayout(1, 3, 25, 0));

      
      rb1 = new JRadioButton("팀장");
      rb2 = new JRadioButton("부팀장");
      rb3 = new JRadioButton("팀원");
      
      
      //rb1 = new JRadioButton("팀장");
      rb1.setBackground(Color.WHITE);
      rb1.setBorderPainted(false);
      rb1.setFont(font);
      rb1.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            JRadioButton rb1 = (JRadioButton) e.getSource();
            rb1.setBackground(Color.LIGHT_GRAY);
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            JRadioButton rb1  = (JRadioButton) e.getSource();
            rb1.setBackground(Color.LIGHT_GRAY);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            JRadioButton rb1 = (JRadioButton) e.getSource();
            rb1.setBackground(Color.WHITE);
         }
      });
      rb1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("팀장")) {
               grade="팀장";
            }
            
         }
      });

      //rb2 = new JRadioButton("부팀장");
      rb2.setBackground(Color.WHITE);
      rb2.setBorderPainted(false);
      rb2.setFont(font);
      rb2.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            JRadioButton rb2  = (JRadioButton) e.getSource();
            rb2.setBackground(Color.LIGHT_GRAY);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            JRadioButton rb2 = (JRadioButton) e.getSource();
            rb2.setBackground(Color.WHITE);
         }
      });
      rb2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("부팀장")) {
               grade="부팀장";
            }
            
         }
      });

      //rb3 = new JRadioButton("팀원");
      rb3.setBackground(Color.WHITE);
      rb3.setBorderPainted(false);
      rb3.setFont(font);
      rb3.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            JRadioButton rb3  = (JRadioButton) e.getSource();
            rb3.setBackground(Color.LIGHT_GRAY);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            JRadioButton rb3 = (JRadioButton) e.getSource();
            rb3.setBackground(Color.WHITE);
         }
      });
      rb3.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("팀원")) {
               grade="팀원";
            }
            
         }
      });

      ButtonGroup group = new ButtonGroup();
      group.add(rb1);
      group.add(rb2);   
      group.add(rb3);
      
      JLabel lTel = new JLabel("전화번호");
      lTel.setBounds(40, 280, 100, 40);
      lTel.setFont(font);
      PrgIn.add(lTel);

      tTel = new JTextField(16);
      tTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tTel.setBounds(40, 330, 260, 40);
      tTel.setBackground(Color.LIGHT_GRAY);
      tTel.setFont(tfFont);
      PrgIn.add(tTel);

      saveBtn = new JButton("저장");
      saveBtn.setFont(font);
      saveBtn.setBackground(Color.WHITE);
      saveBtn.setBounds(380, 330, 80, 40);
      saveBtn.setBorderPainted(false);
      PrgIn.add(saveBtn);
      saveBtn.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            JButton saveBtn = (JButton) e.getSource();
            saveBtn.setBackground(Color.LIGHT_GRAY);
            
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            JButton saveBtn = (JButton) e.getSource();
            saveBtn.setBackground(Color.LIGHT_GRAY);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            JButton saveBtn = (JButton) e.getSource();
            saveBtn.setBackground(Color.WHITE);
         }
      });
      //왼쪽패널에 파일 불러오기
      try {
		  Charset cs = Charset.forName("UTF-8");
          List<String> addList = Files.readAllLines(Paths.get("NiNi.txt"),cs);
          System.out.println(addList);
          for(String i : addList) {
        	  ta.append(i.toString()+"\n");
          }
       } catch (IOException e2) {
          e2.printStackTrace();
       }
      //저장 버튼을 누르면 파일에 저장
      saveBtn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            File file = new File("NiNi.txt");
            FileWriter fw = null;
            String name = tName.getText();
            String tel = tTel.getText();
                        
            try {
               fw = new FileWriter(file, true);
               fw.write(name+" "+grade+" "+tel);
               fw.write("\r\n");               
               fw.flush();
            } catch (IOException e2) {
               e2.printStackTrace();
            }                     
            JOptionPane.showMessageDialog(null, "등록되었습니다");   
            
            tName.setText("");
            tTel.setText("");
            ta.setText(""); //저장버튼 누르면 왼쪽 비워지고 다시 채워짐
            
            try {
                 Charset cs = Charset.forName("UTF-8");
                     List<String> addList = Files.readAllLines(Paths.get("NiNi.txt"),cs);
                     System.out.println(addList);
                     for(String i : addList) {
                        ta.append(i.toString()+"\n");
                     }
                  } catch (IOException e2) {
                     e2.printStackTrace();
                  }
         }
      });     
      
      // 오른쪽안쪽패널 > 상단 버튼
      JPanel pR = new JPanel();
      pR.setBounds(650, 20, 500, 40);
      pR.setBackground(Color.black);
      pR.setLayout(new GridLayout(1, 3, 5, 0));
      pR.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
      // Add 버튼
      var btAdd = new UI_PinkButton("Add");
      btAdd.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            new M_AddMember();
            
         }
      });
      // Remove 버튼
      var btRemove = new UI_PinkButton("Remove");
      btRemove.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            new M_RemoveMember();
         }
      });
      // Modify 버튼
      var btModify = new UI_PinkButton("Modify");
      btModify.setBackground(new Color(255, 198, 218));
      btModify.setBorderPainted(false);
      btModify.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            new M_ModifyMember();
         }
      });

      Pn1.add(pR);
      Pn1.add(pL);

      pR.add(btAdd);
      pR.add(btRemove);
      pR.add(btModify);

      pRBtn.add(rb1);
      pRBtn.add(rb2);
      pRBtn.add(rb3);
      Pn1.add(pRBtn);

      Pn1.add(PrgIn);
      Pn1.add(PlefIn);
      PlefIn.add(Pta);

      Pn1.add(Pchat);
      add(Pn1);

      setVisible(true);

   }// AddMember()
   
   

   public static void main(String[] args) {
      new M_AddMember();
   }

}// c