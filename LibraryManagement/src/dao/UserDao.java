package dao;


import java.sql.*;

import pojo.Users;
import utils.DButils;

public class UserDao {
	private Connection connection;
	private Statement statement;
	public UserDao() throws Exception {
		this.connection = DButils.getConnection();
		this.statement = this.connection.createStatement();
	}
	public boolean checkUser(String[] str, String[] role , int[] id) throws SQLException {
		String sql = "SELECT * FROM users WHERE email='"+str[0]+"' and password='"+str[1]+"'";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			role[0] = rs.getString(6);
			id[0] = rs.getInt(1);
		return true;
		}
		return false;
	}
	public void insertUser(Users user) throws SQLException {
		String sql = "select count(*) from users";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
	    int count = rs.getInt(1);
	    user.setId(++count);
		sql = "insert into users values("+user.getId()+",'"+user.getName()+"','"+user.getEmail()+"','"+user.getPhone()+"', '"+user.getPassword()+"', '"+user.getRole()+"' )"; 
		statement.executeUpdate(sql);
		System.out.println("New user Inserted.......");
	}
	public void editProfile( Users user , int[] id) throws SQLException {
		String sql = "Update users SET email='"+user.getEmail()+"',phone='"+user.getPhone()+"'where id = "+id[0]+"";
		statement.executeUpdate(sql);
		System.out.println("Your Profile edited......");
	}
	public void changePassword(Users user, int[] id) throws SQLException {
		String sql = "Update users SET password='"+user.getPassword()+"'where id = "+id[0]+"";
		statement.executeUpdate(sql);
		System.out.println("Your Password changed.......");
	}
	public void listAllUsers() throws SQLException {
		String sql = "Select * from users";
		ResultSet rs = statement.executeQuery(sql);
		Users user = new Users();
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPhone(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));
			System.out.println(user.toString());
		}
	}
}
