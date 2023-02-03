package oneandall;

import java.awt.*;

import java.awt.event.*;

import java.util.Calendar;

import javax.swing.*;

public class Date extends JFrame implements ActionListener {

	// North

	JPanel topPane = new JPanel();

	JButton prevBtn = new JButton("◀");

	JButton nextBtn = new JButton("▶");

	JButton dayBtn = new JButton();
	JButton Calculator = new JButton("계산");
	
	JButton qjq = new JButton("이름");

	JLabel yearLbl = new JLabel("년");

	JLabel monthLbl = new JLabel("월");

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	JComboBox<Integer> monthCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
	
	String[] name = {"이름선택", "김00" ,"이00"};
	JComboBox<String> nameComboBox = new JComboBox<>(name);
	

	// Center

	JPanel centerPane = new JPanel(new BorderLayout());

	JPanel titlePane = new JPanel(new GridLayout(1, 7));

	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };

	JPanel datePane = new JPanel(new GridLayout(0, 7));

	Calendar now;

	int year, month, date;

	
	
	public Date() {

		super("달력");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 자원 해제 후 종료

		now = Calendar.getInstance(); // 현재 날짜

		year = now.get(Calendar.YEAR);

		month = now.get(Calendar.MONTH) + 1;

		date = now.get(Calendar.DATE);

		topPane.add(nameComboBox);
		topPane.add(prevBtn);

		for (int i = year - 100; i <= year + 50; i++) {

			yearModel.addElement(i);

		}

		yearCombo.setModel(yearModel);

		yearCombo.setSelectedItem(year); // 현재 년도 선택

		topPane.add(yearCombo);

		topPane.add(yearLbl);

		topPane.add(Calculator);

		for (int i = 1; i <= 12; i++) {

			monthModel.addElement(i);

		}

		monthCombo.setModel(monthModel);

		monthCombo.setSelectedItem(month); // 현재 월 선택

		topPane.add(monthCombo);

		topPane.add(monthLbl);

		topPane.add(nextBtn);

		topPane.add(Calculator);

		topPane.setBackground(new Color(255, 198, 218));

		add(topPane, "North");
		
		// Center

		titlePane.setBackground(Color.white);

		for (int i = 0; i < titleStr.length; i++) {

			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);

			if (i == 0) {

				lbl.setForeground(Color.red);

			} else if (i == 6) {

				lbl.setForeground(Color.blue);

			}

			titlePane.add(lbl);

		}

		centerPane.add(titlePane, "North");

		// 날짜 출력

		dayPrint(year, month);

		centerPane.add(datePane, "Center");

		add(centerPane, "Center");

		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		prevBtn.addActionListener(this);

		nextBtn.addActionListener(this);

		yearCombo.addActionListener(this);

		monthCombo.addActionListener(this);

		Calculator.addActionListener(this);

		qjq.addActionListener(this);

		dayBtn.addActionListener(this);
	}

	// Overring

	public void actionPerformed(ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj instanceof JButton) {

			JButton eventBtn = (JButton) obj;

			int yy = (Integer) yearCombo.getSelectedItem();

			int mm = (Integer) monthCombo.getSelectedItem();

			if (eventBtn.equals(prevBtn)) { // 전달

				if (mm == 1) {

					yy--;
					mm = 12;

				} else {

					mm--;

				}

			} else if (eventBtn.equals(nextBtn)) { // 다음달

				if (mm == 12) {

					yy++;
					mm = 1;

				} else {

					mm++;

				}

			}

			yearCombo.setSelectedItem(yy);

			monthCombo.setSelectedItem(mm);

			if (qjq == obj) {
				String name = JOptionPane.showInputDialog(this, "이름을  입력하세요!");

			}
			if (Calculator == obj) {
//				Calculator cl = new Calculator();
//				JOptionPane.showInputDialog(cl);

			}

		}

		else if (obj instanceof JComboBox) { // 콤보박스 이벤트 발생시

			createDayStart();

		}
	}

	public void createDayStart() {

		datePane.setVisible(false); // 패널 숨기기

		datePane.removeAll(); // 날짜 출력한 라벨 지우기

		dayPrint((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());

		datePane.setVisible(true); // 패널 재출력

	}

	public void dayPrint(int y, int m) {

		Calendar cal = Calendar.getInstance();

		cal.set(y, m - 1, 1); // 출력할 첫날의 객체 만든다.

		int week = cal.get(Calendar.DAY_OF_WEEK); // 1일에 대한 요일 일요일 : 0

		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 그 달의 마지막 날

		for (int i = 1; i < week; i++) { // 날짜 출력 전까지의 공백 출력
			datePane.add(new JLabel(" "));

		}

		for (int i = 1; i <= lastDate; i++) {

			JButton dayBtn = new JButton(String.valueOf(i));

			cal.set(y, m - 1, i);

			int outWeek = cal.get(Calendar.DAY_OF_WEEK);

			if (outWeek == 1) {

				dayBtn.setForeground(Color.red);

			} else if (outWeek == 7) {

				dayBtn.setForeground(Color.BLUE);

			}

			datePane.add(dayBtn);
			dayBtn.addActionListener(new MyActionListener());
			
		}
	}

	public static void main(String[] args) {

		new Date();

	}
}

class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()+"일");

	}
	
}