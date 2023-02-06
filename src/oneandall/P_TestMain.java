package oneandall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class P_TestMain {

	public static void main(String[] args) {

//		P_EnvironmentConfigure.createFrame(new P_ProjectSelectFrame("projectHistory"));
		
//		try {
//			TempObjectWriter.invoke();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		List<P_Task> sl = new ArrayList<P_Task>();
		sl.add(new P_Task("a", "aaa", null, "2022-02-12", "2023-02-02", -1));
		sl.add(new P_Task("b", "baa", null, "2022-02-10", "2023-02-04", -1));
		sl.add(new P_Task("c", "caa", null, "2022-02-12", "2023-02-07", -1));

		sl = sl.stream().sorted(Comparator.comparing(P_Task::getEndDate)).collect(Collectors.toList());
		
		
		
		ListIterator<P_Task>  li = sl.listIterator();
		System.out.println(li.next().endDate);
		System.out.println(li.next().endDate);
		System.out.println(li.next().endDate);
		
//		System.out.println(String.compare("2022-02-02", "2022-02-03"));
	}

}
