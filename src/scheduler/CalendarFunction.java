package scheduler;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JLabel;


public class CalendarFunction {

	JLabel[] Label_Day;
	
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"),Locale.KOREA);
	int year,month;
	
	public CalendarFunction() {
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;
	}
	
	public void setButtons(JLabel[] Label_Day) {
		this.Label_Day = Label_Day;
	}
	public int getCalDay() {
		int firstDay =cal.get(Calendar.DAY_OF_WEEK);
		
		return firstDay;
	}
	
	public String getCalText() {
		return year+"�� " +month+"��";
	}
	
	//��ư ��¥ ���
	public void calSet() {
		//calendar ��ü ��¥ 1�� ����
		cal.set(year, month-1, 1);

		//�� ���� 1�� ���� �� 
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		//���� �� 1�� ����, �迭 0 ���� ����
		firstDay--;
		
		for(int i=0; i<=cal.getActualMaximum(cal.DATE)-1;i++){
		
			Label_Day[firstDay+i].setText(String.valueOf(i+1));
			Label_Day[firstDay+i].setHorizontalAlignment(JLabel.CENTER); //JLabel ��� ����
			
		}
	}
	public void allInit(int gap) {
		
		for(int i=0; i< Label_Day.length;i++) {
			Label_Day[i].setText("");
		}
		month+=gap;
		if(month<=0) {
			year--;
			month=12;
			
		}else if(month>=13) {
			year++;
			month=1;
		}
		
		calSet();
	}
	
	
	
	
}
