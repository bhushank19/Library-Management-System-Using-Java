package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import pojo.Books;
import pojo.Copies;
import pojo.IssueRecord;
import utils.DButils;

public class CopiesDao {
	private Connection connection;
	private Statement statement;
	public CopiesDao() throws Exception {
		this.connection = DButils.getConnection();
		this.statement = this.connection.createStatement();
	}
	@SuppressWarnings("unused")
	public void addNewCopy(Copies copies) throws SQLException {
		String sql = "Select max(id) from copies";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Integer count = rs.getInt(1);
		if(count == null)
			count = 1;
		else
			copies.setId(++count);
		sql = "Insert into copies values ("+copies.getId()+","+copies.getBookId()+", "+copies.getRack()+", '"+copies.getStatus()+"')";
		statement.executeUpdate(sql);
		System.out.println("New Copy added......");
	}
	public void checkBookAvailability(Copies copies) throws SQLException {
		String sql = "Select * from copies where bookid = "+copies.getBookId()+"";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			copies.setId(rs.getInt(1));
			copies.setBookId(rs.getInt(2));
			copies.setRack(rs.getInt(3));
			copies.setStatus(rs.getString(4));
			System.out.println(copies.toString());
		}
	}
	public void checkBookAvailabilityMember(Copies copies) throws SQLException {
		String sql = "Select count(*) from copies where id = "+copies.getBookId()+"";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		System.out.println("Available copies : "+count);
	}
	public void changeRack(Copies copies)  throws SQLException {
		String sql = "Update copies set rack = "+copies.getRack()+" where bookid = "+copies.getBookId()+"";
		statement.executeUpdate(sql);
		System.out.println("Rack Changed successfully.....");
	}
	public void listIssuedBook() throws SQLException {
		String sql = " Select b.id, b.name, b.author, b.subject, b.price, b.isbn, i.copyid, i.id, i.issue_date, i.return_duedate From copies c INNER JOIN books b ON b.id = c.bookid INNER JOIN issuerecord i ON i.copyid = c.id WHERE c.status='issued'";
		ResultSet rs = statement.executeQuery(sql);
		Books book = new Books();
		IssueRecord issuerecord = new IssueRecord();
		while(rs.next()) {
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setSubject(rs.getString(4));
			book.setPrice(rs.getDouble(5));
			book.setIsbn(rs.getString(6));
			issuerecord.setCopyId(rs.getInt(7));
			issuerecord.setId(rs.getInt(8));
			Date dt1 = (rs.getDate(9));
			Date dt2 = (rs.getDate(10));
			System.out.println("id : "+book.getId()+", name : "+book.getName()+", author : "+book.getSubject()+", price : "+book.getPrice()+", isbn : "+book.getIsbn()+", issue_date : "+issuerecord.getCopyId()+", issue_id : "+issuerecord.getId()+", issue_date : "+dt1+", return_duedate : "+dt2+"");                    	
		}
	}
	public void listIssuedBookMember(int[] id) throws SQLException {
		String sql = " Select b.id, b.name, b.author, b.subject, b.price, b.isbn, i.copyid, i.id, i.issue_date, i.return_duedate From copies c INNER JOIN books b ON b.id = c.bookid INNER JOIN issuerecord i ON i.copyid = c.id WHERE c.status='issued' and i.memberid ="+id[0]+"";
		ResultSet rs = statement.executeQuery(sql);
		Books book = new Books();
		IssueRecord issuerecord = new IssueRecord();
		while(rs.next()) {
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setSubject(rs.getString(4));
			book.setPrice(rs.getDouble(5));
			book.setIsbn(rs.getString(6));
			issuerecord.setCopyId(rs.getInt(7));
			issuerecord.setId(rs.getInt(8));
			Date dt1 = (rs.getDate(9));
			Date dt2 = (rs.getDate(10));
			System.out.println("id : "+book.getId()+", name : "+book.getName()+", author : "+book.getSubject()+", price : "+book.getPrice()+", isbn : "+book.getIsbn()+", issue_date : "+issuerecord.getCopyId()+", issue_id : "+issuerecord.getId()+", issue_date : "+dt1+", return_duedate : "+dt2+"");                    		
		}	
	}
	public void subjectwiseCopiesReport() throws SQLException {
		String sql = "select subject, count(bookid) from books b inner join copies c on b.id=c.bookid group by c.bookid";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String sub = rs.getString(1);
			int count = rs.getInt(2);
			System.out.println("Subject : "+sub+"	Count : "+count);
		}
	}
	public void bookwiseCopiesReport() throws SQLException {
		String sql = " select c.bookid, b.name, sum(if(c.status='available', 1, 0)),sum(if(c.status='issued',1,0)), count(c.id) as count from copies c Inner join books b on b.id = c.bookid Group by b.id";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int available = rs.getInt(3);
			int issued = rs.getInt(4);
			int count = rs.getInt(5);
			System.out.println("id : "+id+", name : "+name+", available : "+available+", issued : "+issued+", count : "+count+"");
		}
	}
}
