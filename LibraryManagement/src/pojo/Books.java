package pojo;

public class Books {
	private int id;
	private String name, author, subject;
	private double price;
	private String isbn;
	public Books() {	
	}
	public Books(int id, String name, String author, String subject, double price, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}
}
