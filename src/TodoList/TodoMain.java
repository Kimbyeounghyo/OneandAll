package TodoList;

import java.util.Scanner;

public class TodoMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TodoMenu menu = new TodoMenu();
		WorkList work = new WorkList();
		String condition ="";
		
		System.out.println("���� ���� �÷��ִ� [������ TodoList] �ۼ��ϱ�!");
		System.out.println();
		System.out.print("���� �԰� ���� ������ �Է��� �ּ��� : ");
		menu.setFood(sc.next());
		System.out.println("������ ������� ��Ű���? '����' Ȥ�� '����' �� �Է����ּ���.");
		condition=sc.next();
		
		if(condition.equals("����")) {
			System.out.println("��� Ȱ���� �������°� �����? : ) ");
			System.out.println("��ϵ� ���Ȱ���� ������ �����ϴ�.");	
			menu.setHobby("1. Visiting Animate");
			menu.setShopping("2. Buy Clothes");
			
			System.out.println("========[��             ��]======");
			System.out.println(menu.getHobby());
			System.out.println(menu.getShopping());
			System.out.println("===========[���� �ű� ���]=========");
			System.out.println("���� ��α� Ȱ�� ���Դϴ�... ���õ� ��α� Ȱ���� �Ͻðڽ��ϱ�? '1' �Է�");
			if(sc.nextInt()==1) {
				System.out.println("���� �������� ������ �����ϰ� �Է��� �ּ���.");
				work.setBlogPosting(sc.next());//next���� ���� �ȸ���
				System.out.println("������ ��ϵǾ����ϴ�. : " + work.getBlogPosting());
			}
			
		}else if(condition.equals("����")){
			System.out.println("������� �������ôٸ� ������ ���°� ����? ");
		}
		
	}
	
}
