package TodoList;

public class TodoMenu {

	private String hobby;//���
	private String work;//��
	private String shopping;//�Ƿ�
	private String food;//��
	
	public void info() {
		System.out.println("�ߡޡߡޡߡޡߡ�[������ �� ��]�ߡޡߡޡߡޡߡ�");
		System.out.println();
		System.out.println("�� �Ծ�� ����? : " + getFood());
		System.out.println("�� �ؾ� ����?  : " + getWork());
	}
	
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getShopping() {
		return shopping;
	}
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	
	
}
