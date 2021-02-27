package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import launcher.TestUser;
import pojo.Books;
import utils.DButils;

public class BookDao {
	static Scanner sc = new Scanner(System.in);
	static TestUser test = new TestUser();
	private Connection connection;
	private Statement statement;
	public BookDao() throws Exception {
		this.connection = DButils.getConnection();
		this.statement = this.connection.createStatement();
	}
	@SuppressWarnings("unused")
	public void insertBook(Books book) throws SQLException {
		String sql = "Select max(id) from copies";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Integer count = rs.getInt(1);
		if(count == null)
			count = 1;
		else
			book.setId(++count);
	    sql = "insert into books values("+book.getId()+",'"+book.getName()+"','"+book.getAuthor()+"','"+book.getSubject()+"','"+book.getPrice()+"', '"+book.getIsbn()+"')";
	    statement.executeUpdate(sql);
	    System.out.println("New book inserted......");
	}
	public void findBookByName(Books book) throws SQLException {
		String sql = "Select * from books where name='"+book.getName()+"'";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setSubject(rs.getString(4));
			book.setPrice(rs.getDouble(5));
			book.setIsbn(rs.getString(6));
			System.out.println(book.toString());
		}
	}
	public void editBook(Books oldBook) throws SQLException {
		String sql = "Select * from books where name = '"+oldBook.getName()+"'";
		ResultSet rs = statement.executeQuery(sql);
		Books newBook = new Books();
		rs.next();
		oldBook.setId(rs.getInt(1));
		oldBook.setName(rs.getString(2));
		oldBook.setAuthor(rs.getString(3));
		oldBook.setSubject(rs.getString(4));
		oldBook.setPrice(rs.getDouble(5));
		oldBook.setIsbn(rs.getString(6));
		System.out.println(oldBook.toString());
		System.out.print("Enter book id to edit : ");
		newBook.setId(sc.nextInt());
		newBook = test.acceptRecord(newBook);
		sql = "Update books Set name= '"+newBook.getName()+"', author='"+newBook.getAuthor()+"', subject='"+newBook.getSubject()+"',price = "+newBook.getPrice()+", isbn='"+newBook.getIsbn()+"' where id = "+newBook.getId()+"";
		statement.executeUpdate(sql);
		System.out.println("book Updated Successfully....");
	}
}
