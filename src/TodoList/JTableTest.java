package TodoList;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame
{
	public JTableTest() {
		

	String title[] = {"A��","B��","C��"};
	String data[][] = {
			{"������","�躴ȿ","������"},
			{"������","��ä��","������"}				
	};
	JTable table = new JTable(data,title);
	JScrollPane sp = new JScrollPane(table);

	getContentPane().add(sp,BorderLayout.CENTER);
	setSize(300,150);
	setVisible(true);
	}
}
