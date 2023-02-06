package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Notice extends JFrame {

	JPanel defaultPanel;

	public Notice() {
		setTitle("OneAndAll");

		setContentPane(defaultPanel = new JPanel(null));
		getContentPane().setBackground(Color.BLACK);

		// Panel-------------s----------------------------------

		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, EnvironmentConfigure.PROJECT_WIDTH, 50);
		pMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(pMenu);
		pMenu.setBackground(new Color(0, 0, 0));
		pMenu.setLayout(new GridLayout(1, 5, 10, 0)); // 1행4열에 10공백
		add(pMenu);

		var login = new PinkButton("Login");
		login.addMouseListener(new MouseAdapter() {
		});

		var member = new PinkButton("Member");
		member.addMouseListener(new MouseAdapter() {
		});

		pMenu.add(new PinkButton("Home"));
		pMenu.add(login);
		pMenu.add(member);
		pMenu.add(new PinkButton("Project"));
		pMenu.add(new PinkButton("Schedule"));

		// ------------------------------------
		projectNotice(new PinkButtonPanel("공지사항"));
		JPanel jlp = new JPanel();
		jlp.setOpaque(false);
		jlp.setLayout(null);
		jlp.setBackground(new Color(0, 0, 0, 0));
		jlp.setBounds(0,  0, 1173, 540);

		PinkPanel pinkbuttonpanelteam = new PinkPanel();
		pinkbuttonpanelteam.setLayout(null);
		pinkbuttonpanelteam.setBackground(new Color(255, 198, 218, 255));
		pinkbuttonpanelteam.setBounds(10, 110, 1200, 380);
		jlp.add(pinkbuttonpanelteam);
		
		PinkIconplus jb=new PinkIconplus("+");
		jb.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        jb.setBounds(10,480,1200,70);
        jb.addActionListener(null);
//        jb.setBackground(new Color(255,255,255));
        jlp.add(jb,JLayeredPane.POPUP_LAYER);
        

		JTextField pan = new JTextField();
//		pan.setOpaque(false);
		pan.setLayout(null);
		pan.setPreferredSize(new Dimension(200, 1000));

		JTextField pb = new JTextField();
		pb.setBackground(new Color(255, 198, 218));
		pb.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        pb.setPreferredSize(new Dimension(490,30));
		pb.setBounds(0, 0, 1200, 50);
		pan.add(pb);
		pinkbuttonpanelteam.add(pb);
	
		PinkIconplus2 jb2=new PinkIconplus2("▶");
		jb2.setBackground(new Color(255,255,255));
		jb2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		jb2.setBounds(1120, 10, 30, 30);
		pb.add(jb2);

		PinkScroll2 js = new PinkScroll2(pan);
		js.setBounds(0, 0, 1164, 380);
		js.setBorder(BorderFactory.createEmptyBorder());
		pinkbuttonpanelteam.add(js);

		getContentPane().add(jlp);

		setSize(1200, 600);
		setLocationRelativeTo(null); // 사이즈를 먼저 설정해주고 불러주기!
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼

	}

	private void projectNotice(PinkButtonPanel pinkButtonPanel) {
		pinkButtonPanel.setBounds(10, 50, 1164, 50);
		getContentPane().add(pinkButtonPanel);

	}

	public static void main(String[] args) {
		new Notice();

	}

}
