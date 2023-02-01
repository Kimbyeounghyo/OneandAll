package TodoList;

public class WorkList {

	private String ReadingBook;
	private String BlogPosting;
	private String Lecture;//°­ÀÇ
	
	public WorkList() {
		// TODO Auto-generated constructor stub
	}
	
	public WorkList(String ReadingBook, String BlogPosting, String Lecture) {
		
		this.ReadingBook = ReadingBook;
		this.BlogPosting = BlogPosting;
		this.Lecture = Lecture;
		
	}
	
	public WorkList( String BlogPosting, String Lecture) {
		
		this.BlogPosting = BlogPosting;
		this.Lecture = Lecture;
		
	}

	public String getReadingBook() {
		return ReadingBook;
	}

	public void setReadingBook(String readingBook) {
		ReadingBook = readingBook;
	}

	public String getBlogPosting() {
		return BlogPosting;
	}

	public void setBlogPosting(String blogPosting) {
		BlogPosting = blogPosting;
	}

	public String getLecture() {
		return Lecture;
	}

	public void setLecture(String lecture) {
		Lecture = lecture;
	}
	

	
	
	
}
