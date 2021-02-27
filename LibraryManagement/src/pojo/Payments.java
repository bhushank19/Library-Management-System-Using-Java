package pojo;

public class Payments {

	private int id,userId;
	private double amount;
	private String type;
	private Date transactionTime,nextPaymentDueDate;
	public Payments() {
		
	}
	public Payments(int id, int userId, double amount, String type, Date transactionTime, Date nextPaymentDueDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.type = type;
		this.transactionTime = transactionTime;
		this.nextPaymentDueDate = nextPaymentDueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Date getNextPaymentDueDate() {
		return nextPaymentDueDate;
	}

	public void setNextPaymentDueDate(Date nextPaymentDueDate) {
		this.nextPaymentDueDate = nextPaymentDueDate;
	}

	@Override
	public String toString() {
		return "Payments [id=" + id + ", userId=" + userId + ", amount=" + amount + ", type=" + type
				+ ", transactionTime=" + transactionTime + ", nextPaymentDueDate=" + nextPaymentDueDate + "]";
	}
	
	
}
