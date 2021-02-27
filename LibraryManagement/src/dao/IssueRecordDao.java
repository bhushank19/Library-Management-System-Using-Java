package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import utils.DButils;

public class IssueRecordDao {
	Scanner sc = new Scanner(System.in);
	private Connection connection;
	private Statement statement;
	public IssueRecordDao() throws Exception {
		this.connection = DButils.getConnection();
		this.statement = this.connection.createStatement();
	}
	public void issueBook() throws SQLException {
		int memberId;
		System.out.print("Enter Member Id : ");
		memberId = sc.nextInt();
		String sql = "select count(*) from payments where userid="+memberId+"";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		if(count != 0 ) {
			System.out.print("Enter Book Id : ");
			int bookId = sc.nextInt();
			sql = "select count(*) from copies where bookid="+bookId+" and status='available'";
			rs = statement.executeQuery(sql);
			rs.next();
			int count1 = rs.getInt(1);
			if(count1 != 0 ) {
				sql = "select distinct(bookid),id from copies where bookid="+bookId+" and status='available'";
				rs = statement.executeQuery(sql);
				rs.next();
				int copyId =  rs.getInt(2);
				issueRecord(memberId, copyId);
			}else
				System.out.println("book NOT avialable");
		}
		else 
			System.out.println("NOT PAID");
	}
	@SuppressWarnings("unused")
	private void issueRecord(int memberId, int copyId) throws SQLException {
		String sql = "select max(id) from issuerecord";
		ResultSet rs = statement.executeQuery(sql);
		int id;
		rs.next();
	    Integer count = rs.getInt(1);
	    if(count == null)
	    	id = 1;
	    else
	    	id = ++count;
	    LocalDateTime dt = LocalDateTime.now();
	    int year = dt.getYear();
		int month =  dt.getMonthValue();
		int day = dt.getDayOfMonth();
		LocalDateTime dt1 = dt.plusDays(7);
		int nextMonth = dt1.getMonthValue();
		int nextYear = dt1.getYear();
		int nextDay = dt1.getDayOfMonth();
		sql = "insert into issuerecord (id,copyid, memberid, issue_date, return_duedate) values("+id+", "+copyId+", "+memberId+", '"+year+"-"+month+"-"+day+"', '"+nextYear+"-"+nextMonth+"-"+nextDay+"')";                                          
		statement.executeUpdate(sql);
		String sql1 = "Update copies set status='issued' where id="+copyId+"";
		statement.executeUpdate(sql1);
		System.out.println("Book Issued .....");
	}

	public void returnBookCopy() throws Exception {
		PaymentsDao paymentsdao = new PaymentsDao();
		System.out.print("Enter Book Issue Id : ");
		int issueId = sc.nextInt();
		String sql = "select id ,return_duedate, memberid from issuerecord where id="+issueId+"";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int id = rs.getInt(1);
		String ldt1 = rs.getString(2);
		int memberid = rs.getInt(3);
		LocalDate rdd = LocalDate.parse(ldt1);
		LocalDate nd = LocalDate.now();
		long noOfDaysBetween = ChronoUnit.DAYS.between(rdd, nd);
		String sql1 = "update copies set status='avialable' where id="+id+"";
		statement.executeUpdate(sql1);
		LocalDateTime dt = LocalDateTime.now();
		int year = dt.getYear();
    	int month =  dt.getMonthValue();
		int day = dt.getDayOfMonth();
		String sql2 = "update issuerecord set return_date='"+year+"-"+month+"-"+day+"' where id="+issueId+"";
		statement.executeUpdate(sql2);
		System.out.println("Book return succesfully .....");
		if ( noOfDaysBetween > 0) {
			int fine = (int) (noOfDaysBetween * 5);
			paymentsdao.Takefine(memberid,fine);
			System.out.println("fine amount : "+fine);
			String sql3 = "update issuerecord set fine_amount="+fine+" where id = "+id+"";
			statement.executeUpdate(sql3);
			System.out.println("payments done successfully.....");
		}
	}
}



