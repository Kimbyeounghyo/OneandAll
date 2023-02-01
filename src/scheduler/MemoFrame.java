package scheduler;

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

	//������
	public MemoFrame() {//(Movie m) ����
		TextArea txt = new TextArea(getAddtxt(), 0, 0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		txt.setEditable(false);
		//txt.append(m.getReview()); ->������ �޾ƿ��� �ڵ�
		txt.setSize(400,100);
		txt.setLocation(0,0);
		txt.setFont(new Font("CookieRun",Font.PLAIN,18));
		add(txt);
		
		ImageIcon bg = new ImageIcon("���ΰ�.png");
		
		JLabel bglabel = new JLabel(bg);
		bglabel.setBounds(0,400,200,100);
		
		
		
		  Frame fr= new Frame();
	      fr.setTitle("IT�������� �׷� ����");
	      fr.setSize(400, 300);
	      fr.setLocationRelativeTo(null);
	      fr.add(bglabel);
	      bglabel.add(txt);
	      fr.setVisible(true);
	      
	      //����â�� x�� ������ �� System.exit(0)�� �ϸ� �������α׷� ��ü�� ����ǹǷ�
	      //dispose()�� ���� ���� �����Ӹ� ��������� �Ѵ�.
	      fr.addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            fr.setVisible(false);
	            fr.dispose();
	         }
	      }); 
		
	}

}
