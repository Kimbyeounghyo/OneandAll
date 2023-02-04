package oneandall;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Identity;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class _Sign_in extends JFrame{
	
	   JFrame frame;
      
       JComboBox<String> jComboBox; 
      JLabel nameLabel = new JLabel("이름 "); 
      JTextField nameText = new JTextField();
   //
      JLabel gradeLabel = new JLabel("등급 ");
      JPanel boxPanel = new JPanel();
      JLabel idLabel = new JLabel("아이디 "); 
      JTextField idText = new JTextField();
      JLabel pwLabel = new JLabel("비밀번호 ");
      JTextField passText = new JTextField();
      JLabel pwLabel2 = new JLabel("비밀번호 확인 ");
      JPasswordField pw2Text = new JPasswordField();
      JButton Bokay = new UI_PinkButton("확인");   
      Font font = new Font(null, Font.PLAIN, 15);
      Color color = new Color(255, 198, 218);         
      
      public _Sign_in() {
    	  
    	  frame = this;

         this.setTitle("Sign in");
         this.setSize(380, 450);

         JPanel Psign = new JPanel();
         Psign.setLayout(null);
         Psign.setSize(450, 380);
         Psign.setBackground(Color.black);
         
         nameLabel.setBounds(90, 0, 100, 100);
         nameLabel.setForeground(color);
         nameLabel.setFont(font);
         
         nameText.setBounds(90, 70, 200, 30);
         
         gradeLabel.setBounds(90, 75, 100, 100);
         gradeLabel.setForeground(color);
         gradeLabel.setFont(font);
         
         String[] Grade = {"등급선택", "팀장" ,"부팀장", "팀원"};
         
         jComboBox = new JComboBox<>(Grade);
         boxPanel.add(jComboBox);
         boxPanel.setBounds(140, 110, 90, 30);
         boxPanel.setBackground(Color.black);
         
         
         idLabel.setBounds(90, 110, 100, 100);
         idLabel.setForeground(color);
         idLabel.setFont(font);
         
         idText.setBounds(90, 180, 200, 30);
         
         pwLabel.setBounds(90, 190, 100, 100);
         pwLabel.setForeground(color);
         pwLabel.setFont(font);
         
         
         passText.setBounds(90, 255, 200, 30);
         
         pwLabel2.setBounds(90, 260, 100, 100);
         pwLabel2.setForeground(color);
         pwLabel2.setFont(font);
         
         pw2Text.setBounds(90, 330, 200, 30);
         
         Bokay.setBounds   (155, 385, 70, 20);
         
         
         Psign.add(nameLabel);
         Psign.add(nameText);
         Psign.add(gradeLabel);
         Psign.add(boxPanel);
         Psign.add(idLabel);
         Psign.add(idText);
         Psign.add(pwLabel);
         Psign.add(passText);
         Psign.add(pwLabel2);
         Psign.add(pw2Text);
         Psign.add(Bokay);
         
         add(Psign);
         join();
         //getselecteditem. to String
         
         setLocationRelativeTo(null);
         setVisible(true);
         
         
      
         
   }//Sign_in
      public void join() {
         
         passText.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
               if(!passText.getText().equals(pw2Text.getText())){
                  Bokay.enable(false);
               }
                  
            }
            
         });
         
         pw2Text.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
               if(!passText.getText().equals(pw2Text.getText())){
                  Bokay.enable(false);
               }
                  
            }
            
         });
         
         Bokay.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
//               getInfo();
               
               if(CPT_CPTManager.cList != null) {
            	   List<CPT_Coworker> cl = CPT_CPTManager.cList.stream().filter(c -> c.id.equals(idText.getText())).collect(Collectors.toList());
            	   
            	   for(int i=0; i<cl.size(); i++) {
            		   System.out.println(cl.get(i));
            	   }
            	   
            	   if(cl.size() > 0 ) {
            		   JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
            		   return;
            	   }
               }
               
           
               
               
               JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다");
               
               CPT_Coworker c = new CPT_Coworker(idText.getText(),passText.getText(), nameText.getText(), jComboBox.getSelectedItem().toString()
            		   );
               
               if(CPT_CPTManager.cList==null) {
            	   CPT_CPTManager.cList = new ArrayList<CPT_Coworker>();
               }
               CPT_CPTManager.cList.add(c);
               frame.dispose();
               
               
      
            }
         });
      }//join
      
      public void getInfo() {
         CPT_Coworker c = new CPT_Coworker();
         
         c.grade = jComboBox.getSelectedItem().toString();
         c.id = idText.getText();
         c.pwd = passText.getText();
         System.out.println(c.grade);
         
         CPT_CPTManager.cList = new ArrayList<>();
         CPT_CPTManager.cList.add(c);
         
         for(int i=0; i<CPT_CPTManager.cList.size(); i++) {
            CPT_Coworker cc=CPT_CPTManager.cList.get(i);
            System.out.println(cc.grade);
         }
      }
      
   public static void main(String[] args) {
      new _Sign_in();
   }
}//class

