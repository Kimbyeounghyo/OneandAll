package OneAndAll_TeamMate;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemoFrame extends JPanel {

	String addtxt = new String();

	public String getAddtxt() {
		return addtxt;
	}

	public void setAddtxt(String addtxt) {
		this.addtxt = addtxt;
	}

	//생성자
	public MemoFrame() {//(Movie m) 생략
		TextArea txt = new TextArea(getAddtxt(), 0, 0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		txt.setEditable(false);
		//txt.append(m.getReview()); ->정보를 받아오는 코드
		txt.setSize(400,100);
		txt.setLocation(0,0);
		txt.setFont(new Font("CookieRun",Font.PLAIN,18));
		add(txt);
		
		ImageIcon bg = new ImageIcon("팀로고.png");
		
		JLabel bglabel = new JLabel(bg);
		bglabel.setBounds(0,400,200,100);
		
		
		
		  Frame fr= new Frame();
	      fr.setTitle("IT프렌즈의 그룹 일정");
	      fr.setSize(400, 300);
	      fr.setLocationRelativeTo(null);
	      fr.add(bglabel);
	      bglabel.add(txt);
	      fr.setVisible(true);
	      
	      //리뷰창의 x를 눌렀을 때 System.exit(0)를 하면 예매프로그램 자체가 종료되므로
	      //dispose()를 통해 서브 프레임만 종료해줘야 한다.
	      fr.addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            fr.setVisible(false);
	            fr.dispose();
	         }
	      }); 
		
	}

}
