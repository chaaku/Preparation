package March_2019;
import java.lang.*;
import java.util.*;

/*
	Entities
*/
class User{
	private String name;
	private int id;
	private boolean superUser;
	private boolean isApproved;
	List<Book> booksLoanedByUser;

	User(int id, String name, boolean isSuperUser, boolean isApproved){
		this.name = name;
		this.id = id;
		this.superUser = isSuperUser;
		this.isApproved = isApproved;
		this.booksLoanedByUser = new ArrayList<>();
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}


	public int getId(){
		return this.id;
	}

	public void setId(){
		this.id = id;
	}

	public boolean getSuperUser(){
		return this.superUser;
	}

	public void setApproved(boolean val){
		this.isApproved = val;
	}

	public boolean getApproved(){
		return this.isApproved;
	}

	public List<Book> getBooksLoaned(){
		return this.booksLoanedByUser;
	}
}

class Book{
	private String id;
	private String name;
	private String author;

	Book(String id, String name, String author){
		this.id = id;
		this.name = name;
		this.author = author;
	}


	public String getAuthor(){
		return this.author;
	}

	public String getName(){
		return this.name;
	}

	public String getId(){
		return this.id;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public void setId(String id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}
}

class Admin extends User{
	Admin(int id, String name){
		super(id, name, true, true);
	}
}

class NonAdmin extends User{
	NonAdmin(int id, String name){
		super(id, name, false, false);
	}
}

class AuthService{
	// expose API for registration
	// register_new_user(String user_name, is_admin)
	// users must in a DB, consider TreeSet of userIds
	TreeMap<String, User> users = new TreeMap<>();
	// to maintain uniqueness of users, in real we will have to create an index
	TreeSet<String> userNames = new TreeSet<>();

	HashMap<String, User> approvedUsers = new HashMap<>();


	public User registerNewUser(String userName, boolean isAdmin){
		// check if user_name chosen is unique
		if(userNames.contains(userName)){
			System.out.println("UserName occupied");
			return null;
		}

		// get the next id for the user
		int possibleId = users.size();

		if(isAdmin){
			User admin = new Admin(possibleId, userName);
			users.put(userName, admin);
			userNames.add(userName);
			return admin;	
		}else{
			User nonAdmin = new NonAdmin(possibleId, userName);
			users.put(userName, nonAdmin);
			userNames.add(userName);
			return nonAdmin;
		}
	}

	public boolean approveUserWithUserName(User admin, String userName){
		// check if the user who needs to approve is authorized to do so.
		if(admin.getSuperUser()){
			// get the user with the particular userName
			User toApprove = users.get(userName);
			toApprove.setApproved(true);
			users.remove(userName);
			approvedUsers.put(userName, toApprove);
			System.out.println("Successfully Approved");
			return true;

		}else{
			System.out.println("You are not allowed to approve");
			return false;
		}

	}
}


class LibraryManagementService{
	// book storage
	HashMap<String, Book> books = new HashMap<>();
	HashMap<String, Boolean> isLoaned = new HashMap<>();

	public boolean addBook(String id, String title, String author){
		books.put(id, new Book(id, title, author));
		isLoaned.put(id, false);
		return true;
	}

	public boolean loanBook(User user, String bookId){
		// check if the book is already occupied
		if(isLoaned.get(bookId) == false){
			// check if the user already has this book
			if(user.getBooksLoaned().contains(books.get(bookId))){
				System.out.println("You already have loaned this book");
				return false;
			}else{
				isLoaned.put(bookId, true);
				return true;
			}
		}else{
			System.out.println("This book is already loaned");
			return false;
		}
	}

	public Book searchBook(String bookName){
		for (Map.Entry<String, Book> entry : books.entrySet()){
			Book b = entry.getValue();
			if(b.getName().equalsIgnoreCase(bookName)){
				return b;
			}
		}
		System.out.println("No books match search criteria");
		return null;
	}
}

class APIGateWay{

	private AuthService authService;
	private LibraryManagementService libraryManagementService;
	
	APIGateWay(AuthService authService, LibraryManagementService libraryManagementService){
		this.authService = authService;
		this.libraryManagementService = libraryManagementService;
	}


	public User addAdmin(String adminName){
		return this.authService.registerNewUser(adminName, true);
	}

	public User addUser(String userName){
		return this.authService.registerNewUser(userName, false);
	}

	public boolean approve(User admin, String userName){
		return this.authService.approveUserWithUserName(admin, userName);
	}

	public boolean loanBook(User user, String bookId){
		return this.libraryManagementService.loanBook(user, bookId);
	}

	public Book search(String bookName){
		return this.libraryManagementService.searchBook(bookName);
	}

	public boolean addBook(String id, String title, String author){
		return this.libraryManagementService.addBook(id, title, author);
	}

}



public class SalesForce{

	public static void main(String [] args){
		// Register User
		//    validate that user id chosen is unique
		//    return the registration status
		// Approve registration
		//    This should be used by the administrator to approve registered user
		// loan a book
		//    only approved users can loan book
		//    search criteria
		// 

		AuthService authService = new AuthService();
		LibraryManagementService libraryManagementService = new LibraryManagementService();
		APIGateWay gateWay = new APIGateWay(authService, libraryManagementService);

		// create admin user
		User admin = gateWay.addAdmin("admin");
		User userOne = gateWay.addUser("userOne");
		User userTwo = gateWay.addUser("userTwo");
		User userThree = gateWay.addUser("userThree");

		gateWay.approve(admin, userOne.getName());
		gateWay.approve(admin, userTwo.getName());
		gateWay.approve(admin, userThree.getName());

		// add books
		gateWay.addBook("1","My Fav Book 1","autho1");
		gateWay.addBook("2","My Fav Book 2","autho1");
		gateWay.addBook("3","My Fav Book 3","autho2");
		gateWay.addBook("4","My Fav Book 4","autho3");
		gateWay.addBook("5","My Fav Book 5","autho5");

		System.out.println(gateWay.loanBook(userOne, "1"));
		System.out.println(gateWay.loanBook(userTwo, "1"));

		// search book
		System.out.println(gateWay.search("My Fav Book 4").getId());

	}
}