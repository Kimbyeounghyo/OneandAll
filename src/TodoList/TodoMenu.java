package TodoList;

public class TodoMenu {

	private String hobby;//취미
	private String work;//일
	private String shopping;//의류
	private String food;//식
	
	public void info() {
		System.out.println("◆◇◆◇◆◇◆◇[오늘의 할 일]◆◇◆◇◆◇◆◇");
		System.out.println();
		System.out.println("뭘 먹어야 하지? : " + getFood());
		System.out.println("뭘 해야 하지?  : " + getWork());
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
