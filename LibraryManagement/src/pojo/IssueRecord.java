package pojo;

public class IssueRecord {
	private int id,copyId,memberId;
	private Date issueDate,returnDueDate,returnDate;
	private double fineAmount;
	public IssueRecord() {	
	}
	public IssueRecord(int id, int copyId, int memberId, Date issueDate, Date returnDueDate, Date returnDate,
			double fineAmount) {
		super();
		this.id = id;
		this.copyId = copyId;
		this.memberId = memberId;
		this.issueDate = issueDate;
		this.returnDueDate = returnDueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCopyId() {
		return copyId;
	}
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDueDate() {
		return returnDueDate;
	}
	public void setReturnDueDate(Date returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	@Override
	public String toString() {
		return "IssueRecord [id=" + id + ", copyId=" + copyId + ", memberId=" + memberId + ", issueDate=" + issueDate
				+ ", returnDueDate=" + returnDueDate + ", returnDate=" + returnDate + ", fineAmount=" + fineAmount
				+ "]";
	}
}
