package TodoList;

import java.util.Scanner;

public class TodoMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TodoMenu menu = new TodoMenu();
		WorkList work = new WorkList();
		String condition ="";
		
		System.out.println("삶의 질을 올려주는 [오늘의 TodoList] 작성하기!");
		System.out.println();
		System.out.print("오늘 먹고 싶은 음식을 입력해 주세요 : ");
		menu.setFood(sc.next());
		System.out.println("오늘의 컨디션은 어떠신가요? '좋음' 혹은 '나쁨' 을 입력해주세요.");
		condition=sc.next();
		
		if(condition.equals("좋음")) {
			System.out.println("취미 활동을 가져보는건 어떤가요? : ) ");
			System.out.println("등록된 취미활동은 다음과 같습니다.");	
			menu.setHobby("1. Visiting Animate");
			menu.setShopping("2. Buy Clothes");
			
			System.out.println("========[취             미]======");
			System.out.println(menu.getHobby());
			System.out.println(menu.getShopping());
			System.out.println("===========[할일 신규 등록]=========");
			System.out.println("현재 블로그 활동 중입니다... 오늘도 블로그 활동을 하시겠습니까? '1' 입력");
			if(sc.nextInt()==1) {
				System.out.println("오늘 포스팅할 내용을 간략하게 입력해 주세요.");
				work.setBlogPosting(sc.next());//next사용시 띄어쓰기 안먹음
				System.out.println("일정이 등록되었습니다. : " + work.getBlogPosting());
			}
			
		}else if(condition.equals("나쁨")){
			System.out.println("컨디션이 안좋으시다면 집에서 쉬는건 어떨까요? ");
		}
		
	}
	
}
