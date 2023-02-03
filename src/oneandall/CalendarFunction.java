package oneandall;

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
		return year+"년 " +month+"월";
	}
	
	//버튼 날짜 출력
	public void calSet() {
		//calendar 객체 날짜 1일 설정
		cal.set(year, month-1, 1);

		//그 달의 1일 요일 수 
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		//요일 수 1일 시작, 배열 0 부터 시작
		firstDay--;
		
		for(int i=0; i<=cal.getActualMaximum(cal.DATE)-1;i++){
		
			Label_Day[firstDay+i].setText(String.valueOf(i+1));
			Label_Day[firstDay+i].setHorizontalAlignment(JLabel.CENTER); //JLabel 가운데 정렬
			
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