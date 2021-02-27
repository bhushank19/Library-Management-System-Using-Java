package launcher;

import java.util.Scanner;

public class MenuList {
	static Scanner sc = new Scanner(System.in);
	public static int mainMenu() {
		System.out.println("0.Exit");
		System.out.println("1.Sign In");
		System.out.println("2.Sign Up");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}
	public static int ownerMenu() {
		System.out.println("0.Sign Out");
		System.out.println("1.Edit Profile");
		System.out.println("2.Change Password");
		System.out.println("3.Subjectwise Copies Report");
		System.out.println("4.Bookwise Copies Report");
		System.out.println("5.Fees/Fine Report");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}
	public static int librarianMenu() {
		System.out.println("0.Sign Out");
		System.out.println("1.Edit Profile");
		System.out.println("2.Change Password");
		System.out.println("3.Find Book By Name");
		System.out.println("4.Check Book Avialability");
		System.out.println("5.Add New Book");
		System.out.println("6.Add New Copy");
		System.out.println("7.Issue Book Copy");
		System.out.println("8.Return Book Copy");
		System.out.println("9.List Issued Book");
		System.out.println("10.Edit Book");
		System.out.println("11.Change Rack");
		System.out.println("12.Add Member");
		System.out.println("13.Take Payment");
		System.out.println("14.Payment History");
		System.out.println("15.List All Users");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}
	public static int memberMenu() {
		System.out.println("0.Sign Out");
		System.out.println("1.Edit Profile");
		System.out.println("2.Change Password");
		System.out.println("3.Find Book By Name");
		System.out.println("4.Check Book Avialability");
		System.out.println("5.List Issued Book");
		System.out.println("6.Payment History");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}
	
}
