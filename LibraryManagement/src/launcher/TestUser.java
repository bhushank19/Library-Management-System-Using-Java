package launcher;

import java.util.Scanner;

import pojo.Books;
import pojo.Copies;
import pojo.Payments;
import pojo.Users;

public class TestUser {
	static Scanner sc = new Scanner(System.in);
	public void acceptRecord(String[] str) {
		System.out.print("Email : ");
		str[0] = sc.nextLine();
		System.out.print("Password : ");
		str[1] = sc.nextLine();
	}
	public Users acceptRecord(Users user) {
		System.out.print("Enter Name : ");
		user.setName(sc.nextLine());
		System.out.print("Enter Email : ");
		user.setEmail(sc.nextLine());
		System.out.print("Enter Phone : ");
		user.setPhone(sc.nextLine());
		System.out.print("Enter Password : ");
		user.setPassword(sc.nextLine());
		user.setRole("member");
		return user;
	}
	public Books acceptRecord(Books book) {
		System.out.print("Enter Name : ");
		book.setName(sc.nextLine());
		System.out.print("Enter Author : ");
		book.setAuthor(sc.nextLine());
		System.out.print("Enter Subject : ");
		book.setSubject(sc.nextLine());
		System.out.print("Enter Price : ");
		book.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.print("Enter ISBN : ");
		book.setIsbn(sc.nextLine());
		return book;
	}
	public void acceptEditProfile(Users user) {
		System.out.print("new Email : ");
		user.setEmail(sc.nextLine());
		System.out.print("new Phone : ");
		user.setPhone(sc.nextLine());
	}
	public void acceptPassword(Users user) {
		System.out.print("new Password : ");
		user.setPassword(sc.nextLine());
	}
	public void acceptBookName(Books book) {
		System.out.print("Enter Book name : ");
		book.setName(sc.nextLine());
	}
	public Copies acceptNewCopy(Copies copies) {
		System.out.print("enter book id : ");
		copies.setBookId(sc.nextInt());
		System.out.print("enter rack : ");
		copies.setRack(sc.nextInt());
		copies.setStatus("available");
		return copies;
	}
	public void acceptBookId(Copies copies) {
		System.out.print("enter book id : ");
		copies.setBookId(sc.nextInt());
	}
	public void acceptEditBookName(Books book) {
		System.out.print("Enter Book Name : ");
		book.setName(sc.nextLine());
	}
	public void acceptBookIdRack(Copies copies) {
		System.out.print("Enter Book Id : ");
		copies.setBookId(sc.nextInt());
		System.out.print("Enter new rack no. : ");
		copies.setRack(sc.nextInt());
	}
	public void acceptPayments(Payments payments) {
		System.out.print("Enter Member id : ");
		payments.setUserId(sc.nextInt());
		System.out.print("Enter Payment Amount : ");
		payments.setAmount(sc.nextDouble());
		sc.nextLine();
		System.out.print("Enter Payment Type (fee / fine): ");
		payments.setType(sc.nextLine());
	}
	
}
