package pojo;

public class Copies {
	private int id,bookId,rack;
	private String status;
	public Copies() {
	}
	public Copies(int id, int bookId, int rack, String status) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.rack = rack;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getRack() {
		return rack;
	}
	public void setRack(int rack) {
		this.rack = rack;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Copies [id=" + id + ", bookId=" + bookId + ", rack=" + rack + ", status=" + status + "]";
	}
	public int getInt() {
		return ++id;
	}
}
