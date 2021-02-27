package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;

import pojo.Payments;
import utils.DButils;

public class PaymentsDao {
	private Connection connection;
	private Statement statement;
	public PaymentsDao() throws Exception {
		this.connection = DButils.getConnection();
		this.statement = this.connection.createStatement();
	}
	@SuppressWarnings("unused")
	public void takePayment(Payments payments) throws SQLException {
		String sql = "Select max(id) from payments";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Integer count = rs.getInt(1);
		if(count == null)
			count = 1;
		else
			payments.setId(++count);
		LocalDateTime dt = LocalDateTime.now();
		int year = dt.getYear();
		int month = dt.getMonthValue();
		int day = dt.getDayOfMonth();
		int hour = dt.getHour();
		int minute = dt.getMinute();
		int second = dt.getSecond();
		LocalDateTime dt1 = dt.plusMonths(1);
		int nextMonth = dt1.getMonthValue();
		int nextYear = dt1.getYear();
		int nextDay = dt1.getDayOfMonth();
		sql = "Insert into payments values("+payments.getId()+", "+payments.getUserId()+", "+payments.getAmount()+", '"+payments.getType()+"', '"+year+"-"+month+"-"+day+" " +hour+":"+minute+":"+second+"', '"+nextYear+"-"+nextMonth+"-"+nextDay+"')";
		statement.executeUpdate(sql);
		System.out.println("Payment Accepted.....");
	}
	public void paymentHistory() throws SQLException {
		String sql = "Select * from payments";
		ResultSet rs = statement.executeQuery(sql);
		Payments payments = new Payments();
		while(rs.next()) {
			payments.setId(rs.getInt(1));
			payments.setUserId(rs.getInt(2));
			payments.setAmount(rs.getDouble(3));
			payments.setType(rs.getString(4));
			Date dt = (rs.getDate(5));
			Date dt1 = rs.getDate(6);
			System.out.println(payments.toString()+" Transaction Time :  "+dt+" Next Due Date : "+dt1);
		}	
	}
	public void paymentHistoryMember(int [] id ) throws SQLException {
		String sql = "Select * from payments where userid = "+id[0]+"";
		ResultSet rs = statement.executeQuery(sql);
		Payments payments = new Payments();
		while(rs.next()) {
			payments.setId(rs.getInt(1));
			payments.setUserId(rs.getInt(2));
			payments.setAmount(rs.getDouble(3));
			payments.setType(rs.getString(4));
			Date dt = (rs.getDate(5));
			Date dt1 = rs.getDate(6);
			System.out.println(payments.toString()+" Transaction Time :  "+dt+" Next Due Date : "+dt1);
		}
	}
	@SuppressWarnings("unused")
	public void Takefine(int memberid, int fine) throws SQLException {
		Payments payments = new Payments();
		String sql = "Select max(id) from payments";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Integer count = rs.getInt(1);
		if(count == null)
			count = 1;
		else
			payments.setId(++count);
		LocalDateTime dt = LocalDateTime.now();
		int year = dt.getYear();
		int month = dt.getMonthValue();
		int day = dt.getDayOfMonth();
		int hour = dt.getHour();
		int minute = dt.getMinute();
		int second = dt.getSecond();
		sql = "Insert into payments(id, userid, amount , type, transaction_time) values("+payments.getId()+", "+memberid+", "+fine+",'fine', '"+year+"-"+month+"-"+day+" " +hour+":"+minute+":"+second+"')";
		statement.executeUpdate(sql);
	}
	@SuppressWarnings("deprecation")
	public void feesFineReport() throws SQLException {
		String sql = "select min(transaction_time), max(transaction_time) from payments";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Date date = rs.getDate(1);
		int minyear = date.getYear() +1900;
		int minmonth = date.getMonth() + 1;
		int minday = date.getDate();
		Date date1 = rs.getDate(2);
		int maxyear = date1.getYear() +1900;
		int maxmonth = date1.getMonth() + 1;
		int maxday = date1.getDate();
		System.out.println("from date (dd-mm-yyyy) : "+minday+"-"+minmonth+"-"+minyear+"");
		System.out.println("to date (dd-mm-yyyy) : "+maxday+"-"+maxmonth+"-"+maxyear+"");
		String sql1= "select sum(amount) from payments group by type";
		ResultSet rs1 = statement.executeQuery(sql1);
		int count = 0;
		while(rs1.next()) {
		int Amount = rs1.getInt(1);
			 if (count == 0 ) 
				 System.out.println("Type : fee , amount(fee) : "+Amount);
			 else
				 System.out.println("Type : fine , amount(fine) : "+Amount);
			 ++count;
	    }
	}
}




