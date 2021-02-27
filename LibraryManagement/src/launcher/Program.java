package launcher;

import dao.BookDao;
import dao.CopiesDao;
import dao.IssueRecordDao;
import dao.PaymentsDao;
import dao.UserDao;
import pojo.Books;
import pojo.Copies;
import pojo.Payments;
import pojo.Users;

public class Program {
	static Users user = new Users();
	static TestUser test = new TestUser();
	static Books book = new Books();
	static Copies copies = new Copies();
	static Payments payments = new Payments();
	private static void owner(int[] id) throws Exception {
		int choice;
		UserDao  userdao = new UserDao();
		CopiesDao copiesdao = new CopiesDao();
		PaymentsDao paymentsdao = new PaymentsDao();
		while( (choice = MenuList.ownerMenu()) != 0) {
			switch(choice) {
			case 1: // Edit Profile	
				test.acceptEditProfile(user);
				userdao.editProfile(user , id);
				break;
			case 2: //Change Password
				test.acceptPassword(user);
				userdao.changePassword(user, id);
				break;
			case 3:  //Subjectwise Copies Report
				copiesdao.subjectwiseCopiesReport();
				break;
			case 4: //Bookwise Copies Report
				copiesdao.bookwiseCopiesReport();
				break;
			case 5://Fees/Fine Report
				paymentsdao.feesFineReport();
				break;
			}
		}
	}
	private static void librarian(int[] id) throws Exception {
		int choice;
		
		BookDao bookDao = new BookDao();
		UserDao  userdao = new UserDao();
		CopiesDao copiesdao = new CopiesDao();
		PaymentsDao paymentsdao = new PaymentsDao();
		IssueRecordDao issueRecordDao = new IssueRecordDao();
		
		while( (choice = MenuList.librarianMenu()) != 0) {
			switch(choice) {
			case 1:// Edit Profile	
				test.acceptEditProfile(user);
				userdao.editProfile(user , id);
				break;
			case 2: //Change Password
				test.acceptPassword(user);
				userdao.changePassword(user, id);
				break;
			case 3://Find Book By Name
				test.acceptBookName(book);
				bookDao.findBookByName(book);
				break;
			case 4://Check Book Avialability
				test.acceptBookId(copies);
				copiesdao.checkBookAvailability(copies);
				break;
			case 5:// Add New Book
				book = test.acceptRecord(book);
				bookDao.insertBook(book);
				break;
			case 6://Add New Copy
				copies = test.acceptNewCopy(copies);
				copiesdao.addNewCopy(copies);
				break;
			case 7:	//Issue Book Copy
				issueRecordDao.issueBook();
				break;
			case 8://Return Book Copy
				issueRecordDao.returnBookCopy();
				break;
			case 9://List Issued Book
				copiesdao.listIssuedBook();
				break;
			case 10://Edit Book
				test.acceptEditBookName(book);
				bookDao.editBook(book);
				break;
			case 11://Change Rack
				test.acceptBookIdRack(copies);
				copiesdao.changeRack(copies);
				break;
			case 12://Add Member
				user = test.acceptRecord(user);
				userdao.insertUser(user);
				break;
			case 13://Take Payment
				test.acceptPayments(payments);
				paymentsdao.takePayment(payments);
				break;
			case 14://Payment History
				paymentsdao.paymentHistory();
				break;
			case 15://List All Users
				userdao.listAllUsers();
				break;
			}
		}	
	}
	private static void member(int[] id) throws Exception {
		int choice;
		UserDao  userdao = new UserDao();
		BookDao bookDao = new BookDao();
		CopiesDao copiesdao = new CopiesDao();
		PaymentsDao paymentsdao = new PaymentsDao();
		while( (choice = MenuList.memberMenu()) != 0) {
			switch(choice) {
			case 1: // Edit Profile	
				test.acceptEditProfile(user);
				userdao.editProfile(user , id);
				break;
			case 2: // Change Password
				test.acceptEditProfile(user);
				userdao.editProfile(user , id);
				break;
			case 3://Find Book By Name
				test.acceptBookName(book);
				bookDao.findBookByName(book);
				break;
			case 4://Check Book Avialability
				test.acceptBookId(copies);
				copiesdao.checkBookAvailabilityMember(copies);
				break;
			case 5://List Issued Book
				copiesdao.listIssuedBookMember(id);
				break;
			case 6://Payment History
				paymentsdao.paymentHistoryMember(id);
				break;
			}
		}	
	}
	public static void main(String[] args) throws Exception {
		int choice;
		boolean status;
		UserDao userdao = new UserDao();
		String[] str = new String[2];
		String []role = new String[1];
		int[] id = new int[1];
		while( (choice = MenuList.mainMenu()) != 0) {
			switch(choice) {
			case 1: // Sign In
				try {
					test.acceptRecord(str);
					status = userdao.checkUser(str,role, id);
					if(status && role[0].equals("owner")) {
						Program.owner(id);
					}
					else if(status && role[0].equals("librarian")) {
						Program.librarian(id);
					}
					else if(status && role[0].equals("member")){
						Program.member(id);
					}
					else 
						System.out.println("Enter valid input");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2: // Sign Up
				user = test.acceptRecord(user);
				userdao.insertUser(user);
				break;
			}
		}
	}
}
