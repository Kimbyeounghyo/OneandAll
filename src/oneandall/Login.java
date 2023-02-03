package OneAndAll_TeamMate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

	
public class Login extends JFrame{	
	
	
	
	Login() {


		
		JPanel LoginP = new JPanel();
		
		
		JLabel LoginL = new JLabel("ID");
		JTextField txtID = new JTextField(10);
		
		
		
		txtID.setForeground(Color.black); //아이디 글씨색

		
		JLabel LoginPw = new JLabel( "Password"); 
		JPasswordField txtPass = new JPasswordField(10);
		
		
		JButton logBtn = new JButton("Log In");
		JButton logNew = new JButton("Sign Up");
	
		
		
		LoginPw.setVerticalTextPosition(JLabel.BOTTOM);	 //비밀번호 글씨색(ABORT);
		txtPass.setForeground(Color.red);	 //비밀번호 글씨색
		
		
		LoginP.setBackground(Color.black);
		
		
		
	
		LoginL.setForeground(Color.pink); //로그인창글씨
		LoginPw.setForeground(Color.pink); //비번창글씨
		
	
		

		logNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sign_in();
				
			}
		});

		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String id = "Soldesk";
			String pass = "1234";
			
			if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())){
				JOptionPane.showMessageDialog(null, "로그인 성공");;
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");;
			}
		
				 
			}
		});
		
		
		LoginP.setLayout(null);
		LoginL.setBounds(50, 25, 30, 30);
		txtID.setBounds(100, 30, 150, 20);
		LoginPw.setBounds(30, 65, 100, 30);
		txtPass.setBounds(100, 70, 150, 20);
		logBtn.setBounds(40,110,100,30);
		logNew.setBounds(150, 110, 100, 30);
		
		LoginP.add(LoginL);
		LoginP.add(txtID);
		
		LoginP.add(LoginPw);
		LoginP.add(txtPass);
		
		LoginP.add(logBtn);
		LoginP.add(logNew);
		
		add(LoginP);
		
		
		 addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					setDefaultCloseOperation(HIDE_ON_CLOSE);
					((JFrame)e.getSource()).dispose(); //getsource는 obj이므로 JFramm으로 다운캐스팅 idspose가 끄는거
					System.out.println(e.getSource().toString());
			
				}
		    	  
			});
		      
		 
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	
	public static void main(String[] args) {
		new Login();
	}
	
}
