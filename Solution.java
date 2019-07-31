import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

public class Solution {

    abstract class Person {
        protected int id; // ID of every person related to library
        protected String password; // Password of every person related to library
        protected String name; // Name of every person related to library
        protected int phoneNo; // PhoneNo of every person related to library

        public Person(int dd, String n, int p) // para cons.
        {

            id = dd;
            password = Integer.toString(id);
            name = n;
            phoneNo = p;
        }

        // Printing Info of a Person
        public void printInfo() {
            System.out.println("-----------------------------------------");
            System.out.println("\nThe details are: \n");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
        }

        /*---------Setter func---------*/

        public void setName(String n) {
            name = n;
        }

        /*-------Getter func--------*/
        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public int getID() {
            return id;
        }
        /*---------------------------*/

    } // Person Class Closed

    public class Librarian extends Person {

        public Librarian(int id, String n, int p) {
            super(id, n, p);
        }

        // Printing Librarian's Info
        @Override
        public void printInfo() {
            super.printInfo();
            System.out.println("Id " + id);
        }
    }

    public class Main {

        public void allFunctionalities(Person person, int choice) throws IOException {
            Library lib = new Library().getInstance();

            lib.searchForBooks();

            int input = 0;

            // Issue a Book
            ArrayList<Book> books = lib.searchForBooks();

            if (books != null) {
                Book b = books.get(0);

                Borrower bor = lib.findBorrower();
                b.issueBook(bor, (Staff) person);
            }

            // Remove a Book
            else if (choice == 12) {
                ArrayList<Book> booksa = lib.searchForBooks();

                if (books != null) {

                    lib.removeBookfromLibrary(booksa.get(input));
                }
            }
        }

        /*-------------------------------------MAIN---------------------------------------------------*/

        public void main(String[] args) {
            Scanner admin = new Scanner(System.in);

            // -------------------INTERFACE---------------------------//

            Library lib = new Library().getInstance();

            // Making connection with Database.
            Connection con = lib.makeConnection();

            if (con == null) // Oops can't connnect !
            {
                System.out.println("\nError connecting to Database. Exiting.");
                return;
            }

            try {

                lib.populateLibrary(con); // Populating Library with all Records

                boolean stop = false;
                while (!stop) {

                    // FRONT END //
                    System.out.println("--------------------------------------------------------");
                    System.out.println("\tWelcome to Library Management System");
                    System.out.println("--------------------------------------------------------");

                    System.out.println("Following Functionalities are available: \n");
                    System.out.println("1- Login");
                    System.out.println("2- Exit");
                    System.out.println("3- Admininstrative Functions"); // Administration has access only

                    System.out.println("-----------------------------------------\n");

                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 3) {
                        System.out.println("\nEnter Password: ");
                        String aPass = admin.next();

                        if (aPass.equals("lib")) {
                            while (true) // Way to Admin Portal
                            {

                                System.out.println("--------------------------------------------------------");
                                System.out.println("\tWelcome to Admin's Portal");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Following Functionalities are available: \n");

                                System.out.println("1- Add Clerk");
                                System.out.println("2- Add Librarian");
                                System.out.println("3- View Issued Books History");
                                System.out.println("4- View All Books in Library");
                                System.out.println("5- Logout");

                                System.out.println("---------------------------------------------");

                                choice = new Scanner(System.in).nextInt();

                                if (choice == 5)
                                    break;

                                if (choice == 1)
                                    lib.createPerson('c');
                                else if (choice == 2)
                                    lib.createPerson('l');

                                else if (choice == 4)
                                    lib.viewAllBooks();

                                System.out.println("\nPress any key to continue..\n");
                                admin.next();
                            }
                        } else
                            System.out.println("\nSorry! Wrong Password.");
                    }

                    else if (choice == 1) {
                        Person person = lib.login();

                        if (person == null) {
                        }

                        else if (person.getClass().getSimpleName().equals("Borrower")) {
                            while (true) // Way to Borrower's Portal
                            {

                                System.out.println("--------------------------------------------------------");
                                System.out.println("\tWelcome to Borrower's Portal");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Following Functionalities are available: \n");
                                System.out.println("1- Search a Book");
                                System.out.println("2- Place a Book on hold");
                                System.out.println("3- Check Personal Info of Borrower");
                                System.out.println("4- Check Total Fine of Borrower");
                                System.out.println("5- Check Hold Requests Queue of a Book");
                                System.out.println("6- Logout");
                                System.out.println("--------------------------------------------------------");

                                choice = new Scanner(System.in).nextInt();

                                if (choice == 6)
                                    break;

                                allFunctionalities(person, choice);
                            }
                        }

                        else if (person.getClass().getSimpleName().equals("Librarian")) {
                            while (true) // Way to Librarian Portal
                            {

                                System.out.println("--------------------------------------------------------");
                                System.out.println("\tWelcome to Librarian's Portal");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Following Functionalities are available: \n");
                                System.out.println("1- Search a Book");
                                System.out.println("2- Place a Book on hold");
                                System.out.println("3- Check Personal Info of Borrower");
                                System.out.println("4- Check Total Fine of Borrower");
                                System.out.println("5- Check Hold Requests Queue of a Book");
                                System.out.println("6- Check out a Book");
                                System.out.println("7- Check in a Book");
                                System.out.println("8- Renew a Book");
                                System.out.println("9- Add a new Borrower");
                                System.out.println("10- Update a Borrower's Info");
                                System.out.println("11- Add new Book");
                                System.out.println("12- Remove a Book");
                                System.out.println("13- Change a Book's Info");
                                System.out.println("14- Check Personal Info of Clerk");
                                System.out.println("15- Logout");
                                System.out.println("--------------------------------------------------------");

                                choice = new Scanner(System.in).nextInt();

                                if (choice == 15)
                                    break;

                                allFunctionalities(person, choice);
                            }
                        }

                    }

                    else
                        stop = true;

                    System.out.println("\nPress any key to continue..\n");
                    Scanner scanner = new Scanner(System.in);
                    scanner.next();
                }

            } catch (Exception e) {
                System.out.println("\nExiting...\n");
            } // System Closed!

        } // Main Closed

        public class Loan {
            private Book book;

            public Loan(Book b) // Para cons.
            {
                book = b;
            }

            /*----- Getter FUNCs.------------*/

            public Book getBook() // Returns the book
            {
                return book;
            }

        }

        class Borrower extends Person {

            private ArrayList<Loan> borrowedBooks;

            public Borrower(int id, String n, String a, int p) // para. cons
            {
                super(id, n, p);
            }

            public ArrayList<Loan> getBorrowedBooks() {
                return borrowedBooks;
            }

            public void addBorrowedBook(Loan iBook) {
                borrowedBooks.add(iBook);
            }

        }

        class Book {

            private int bookID;
            private boolean isIssued;

            public Book(int id, boolean issued) // Parameterise cons.
            {

                bookID = id;
                isIssued = issued;

            }

            /*------------Getter FUNCs.---------*/

            public boolean getIssuedStatus() {
                return isIssued;
            }

            public void setIssuedStatus(boolean s) {
                isIssued = s;
            }

            public int getID() {
                return bookID;
            }

            // Issuing a Book
            public void issueBook(Borrower borrower, Staff staff) {
                // First deleting the expired hold requests
                Date today = new Date();

                if (isIssued) {
                    throw new RuntimeErrorException(null, "Book is already issued");
                }

                else {
                    // Iif book is available, then simply issue the book.
                    setIssuedStatus(true);

                    Loan iHistory = new Loan(this);
                    new Library().getInstance().addLoan(iHistory);
                    System.out.println("\nIssued by: " + staff.getName());
                }
            }

            // Returning a Book
            public void returnBook(Borrower borrower, Loan l, Staff staff) {
                l.getBook().setIssuedStatus(false);

                System.out.println("\nThe book " + l.getBook().getID() + " is successfully returned by "
                        + borrower.getName() + ".");
                System.out.println("\nReceived by: " + staff.getName());
            }

        } // Book Class Closed

        public class Staff extends Person {
            protected double salary;

            public Staff(int id, String n, String a, int p, double s) {
                super(id, n, p);
                salary = s;
            }
        }

        public class Library {

            private String name; // name of library
            private Librarian librarian; // object of Librarian (only one)
            private ArrayList<Person> persons; // all clerks and borrowers
            private ArrayList<Book> booksInLibrary; // all books in library are here!

            private ArrayList<Loan> loans; // history of all books which have been issued

            public int book_return_deadline; // return deadline after which fine will be generated each day
            public double per_day_fine;

            public int hold_request_expiry; // number of days after which a hold request will expire

            /*----Following Singleton Design Pattern (Lazy Instantiation)------------*/
            private Library obj;

            public Library getInstance() {
                if (obj == null) {
                    obj = new Library();
                }

                return obj;
            }
            /*---------------------------------------------------------------------*/

            private Library() // default cons.
            {
                name = null;
                librarian = null;
                persons = new ArrayList();

                booksInLibrary = new ArrayList();
                loans = new ArrayList();
            }

            // Setter Func.
            public void setName(String n) {
                name = n;
            }

            /*-----------Getter FUNCs.------------*/

            public int getHoldRequestExpiry() {
                return hold_request_expiry;
            }

            public ArrayList<Person> getPersons() {
                return persons;
            }

            public Librarian getLibrarian() {
                return librarian;
            }

            public String getLibraryName() {
                return name;
            }

            public ArrayList<Book> getBooks() {
                return booksInLibrary;
            }

            /*---------------------------------------*/

            /*-----Adding all People in Library----*/
            public boolean addLibrarian(Librarian lib) {
                // One Library can have only one Librarian
                if (librarian == null) {
                    librarian = lib;
                    persons.add(librarian);
                    return true;
                } else
                    System.out
                            .println("\nSorry, the library already has one librarian. New Librarian can't be created.");
                return false;
            }

            public void addBorrower(Borrower b) {
                persons.add(b);
            }

            public void addLoan(Loan l) {
                loans.add(l);
            }

            /*----------------------------------------------*/

            /*-----------Finding People in Library--------------*/
            public Borrower findBorrower() {
                System.out.println("\nEnter Borrower's ID: ");

                int id = 0;

                Scanner scanner = new Scanner(System.in);

                try {
                    id = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\nInvalid Input");
                }

                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).getID() == id && persons.get(i).getClass().getSimpleName().equals("Borrower"))
                        return (Borrower) (persons.get(i));
                }

                System.out.println("\nSorry this ID didn't match any Borrower's ID.");
                return null;
            }

            /*------- FUNCS. on Books In Library--------------*/
            public void addBookinLibrary(Book b) {
                booksInLibrary.add(b);
            }

            // When this function is called, only the pointer of the book placed in
            // booksInLibrary is removed. But the real object of book
            // is still there in memory because pointers of that book placed in IssuedBooks
            // and ReturnedBooks are still pointing to that book. And we
            // are maintaining those pointers so that we can maintain history.
            // But if we donot want to maintain history then we can delete those pointers
            // placed in IssuedBooks and ReturnedBooks as well which are
            // pointing to that book. In this way the book will be really removed from
            // memory.
            public void removeBookfromLibrary(Book b) {
                boolean delete = true;

                // Checking if this book is currently borrowed by some borrower
                for (int i = 0; i < persons.size() && delete; i++) {
                    if (persons.get(i).getClass().getSimpleName().equals("Borrower")) {
                        ArrayList<Loan> borBooks = ((Borrower) (persons.get(i))).getBorrowedBooks();

                        for (int j = 0; j < borBooks.size() && delete; j++) {
                            if (borBooks.get(j).getBook() == b) {
                                delete = false;
                                System.out.println("This particular book is currently borrowed by some borrower.");
                            }
                        }
                    }
                }

                if (delete) {
                    booksInLibrary.remove(b);
                    System.out.println("The book is successfully removed.");
                } else
                    System.out.println("\nDelete Unsuccessful.");
            }

            // Searching Books on basis of title, Subject or Author
            public ArrayList<Book> searchForBooks() throws IOException {
                String choice;
                String title = "", subject = "", author = "";

                Scanner sc = new Scanner(System.in);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    System.out.println(
                            "\nEnter either '1' or '2' or '3' for search by Title, Subject or Author of Book respectively: ");
                    choice = sc.next();

                    if (choice.equals("1") || choice.equals("2") || choice.equals("3"))
                        break;
                    else
                        System.out.println("\nWrong Input!");
                }

                if (choice.equals("1")) {
                    System.out.println("\nEnter the Title of the Book: ");
                    title = reader.readLine();
                }

                else if (choice.equals("2")) {
                    System.out.println("\nEnter the Subject of the Book: ");
                    subject = reader.readLine();
                }

                else {
                    System.out.println("\nEnter the Author of the Book: ");
                    author = reader.readLine();
                }

                ArrayList<Book> matchedBooks = new ArrayList();

                // Retrieving all the books which matched the user's search query
                for (int i = 0; i < booksInLibrary.size(); i++) {
                    Book b = booksInLibrary.get(i);
                    System.out.println(b.getID());

                }

                // Printing all the matched Books
                if (!matchedBooks.isEmpty()) {
                    System.out.println("\nThese books are found: \n");

                    System.out
                            .println("------------------------------------------------------------------------------");
                    System.out.println("No.\t\tTitle\t\t\tAuthor\t\t\tSubject");
                    System.out
                            .println("------------------------------------------------------------------------------");

                    for (int i = 0; i < matchedBooks.size(); i++) {
                        System.out.print(i + "-" + "\t\t");

                        System.out.print("\n");
                    }

                    return matchedBooks;
                } else {
                    System.out.println("\nSorry. No Books were found related to your query.");
                    return null;
                }
            }

            // View Info of all Books in Library
            public void viewAllBooks() {
                if (!booksInLibrary.isEmpty()) {
                    System.out.println("\nBooks are: ");

                    System.out
                            .println("------------------------------------------------------------------------------");
                    System.out.println("No.\t\tTitle\t\t\tAuthor\t\t\tSubject");
                    System.out
                            .println("------------------------------------------------------------------------------");

                    for (int i = 0; i < booksInLibrary.size(); i++) {
                        System.out.print(i + "-" + "\t\t");

                        System.out.print("\n");
                    }
                } else
                    System.out.println("\nCurrently, Library has no books.");
            }

            public void createPerson(char x) {
                Scanner sc = new Scanner(System.in);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("\nEnter Name: ");
                String n = "";
                try {
                    n = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Enter Address: ");
                String address = "";
                try {
                    address = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                }

                int phone = 0;

                try {
                    System.out.println("Enter Phone Number: ");
                    phone = sc.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\nInvalid Input.");
                }

                // If librarian is to be created
                if (x == 'l') {
                    double salary = 0;
                    try {
                        System.out.println("Enter Salary: ");
                        salary = sc.nextDouble();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("\nInvalid Input.");
                    }

                    Librarian l = new Librarian(-1, n, phone);
                    if (addLibrarian(l)) {
                        System.out.println("\nLibrarian with name " + n + " created successfully.");
                    }
                }

                // If borrower is to be created
                else {
                    Borrower b = new Borrower(-1, n, address, phone);
                    addBorrower(b);
                    System.out.println("\nBorrower with name " + n + " created successfully.");

                    System.out.println("\nYour ID is : " + b.getID());
                    System.out.println("Your Password is : " + b.getPassword());
                }
            }

            public void createBook(String title, String subject, String author) {
                Book b = new Book(-1, false);

                addBookinLibrary(b);

                System.out.println("\nBook with Title " + b.getID() + " is successfully created.");
            }

            // Called when want an access to Portal
            public Person login() {
                Scanner input = new Scanner(System.in);

                int id = 0;
                String password = "";

                System.out.println("\nEnter ID: ");

                try {
                    id = input.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\nInvalid Input");
                }

                System.out.println("Enter Password: ");
                password = input.next();

                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).getID() == id && persons.get(i).getPassword().equals(password)) {
                        System.out.println("\nLogin Successful");
                        return persons.get(i);
                    }
                }

                if (librarian != null) {
                    if (librarian.getID() == id && librarian.getPassword().equals(password)) {
                        System.out.println("\nLogin Successful");
                        return librarian;
                    }
                }

                System.out.println("\nSorry! Wrong ID or Password");
                return null;
            }

            // Making Connection With Database
            public Connection makeConnection() {
                try {
                    String host = "jdbc:derby://localhost:1527/LMS";
                    String uName = "haris";
                    String uPass = "123";
                    Connection con = DriverManager.getConnection(host, uName, uPass);
                    return con;
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                    return null;
                }
            }

            // Loading all info in code via Database.
            public void populateLibrary(Connection con) throws SQLException, IOException {
                Library lib = this;
                Statement stmt = con.createStatement();

                /* --- Populating Book ---- */
                String SQL = "SELECT * FROM BOOK";
                ResultSet rs = stmt.executeQuery(SQL);

                if (!rs.next()) {
                    System.out.println("\nNo Books Found in Library");
                } else {
                    int maxID = 0;

                    do {
                        if (rs.getString("TITLE") != null && rs.getString("AUTHOR") != null
                                && rs.getString("SUBJECT") != null && rs.getInt("ID") != 0) {
                            String title = rs.getString("TITLE");
                            String author = rs.getString("AUTHOR");
                            String subject = rs.getString("SUBJECT");
                            int id = rs.getInt("ID");
                            boolean issue = rs.getBoolean("IS_ISSUED");
                            Book b = new Book(id, issue);
                            addBookinLibrary(b);

                            if (maxID < id)
                                maxID = id;
                        }
                    } while (rs.next());

                }

                /* ----Populating Clerks---- */

                SQL = "SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO,SALARY,DESK_NO FROM PERSON INNER JOIN CLERK ON ID=C_ID INNER JOIN STAFF ON S_ID=C_ID";

                rs = stmt.executeQuery(SQL);

                if (!rs.next()) {
                    System.out.println("No clerks Found in Library");
                } else {
                    do {
                        int id = rs.getInt("ID");
                        String cname = rs.getString("PNAME");
                        String adrs = rs.getString("ADDRESS");
                        int phn = rs.getInt("PHONE_NO");
                        double sal = rs.getDouble("SALARY");
                        int desk = rs.getInt("DESK_NO");

                    } while (rs.next());

                }

                /*-----Populating Librarian---*/
                SQL = "SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO,SALARY,OFFICE_NO FROM PERSON INNER JOIN LIBRARIAN ON ID=L_ID INNER JOIN STAFF ON S_ID=L_ID";

                rs = stmt.executeQuery(SQL);
                if (!rs.next()) {
                    System.out.println("No Librarian Found in Library");
                } else {
                    do {
                        int id = rs.getInt("ID");
                        String lname = rs.getString("PNAME");
                        String adrs = rs.getString("ADDRESS");
                        int phn = rs.getInt("PHONE_NO");
                        double sal = rs.getDouble("SALARY");
                        int off = rs.getInt("OFFICE_NO");
                        Librarian l = new Librarian(id, lname, phn);

                        addLibrarian(l);

                    } while (rs.next());

                }

                /*---Populating Borrowers (partially)!!!!!!--------*/

                SQL = "SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO FROM PERSON INNER JOIN BORROWER ON ID=B_ID";

                rs = stmt.executeQuery(SQL);

                if (!rs.next()) {
                    System.out.println("No Borrower Found in Library");
                } else {
                    do {
                        int id = rs.getInt("ID");
                        String name = rs.getString("PNAME");
                        String adrs = rs.getString("ADDRESS");
                        int phn = rs.getInt("PHONE_NO");

                        Borrower b = new Borrower(id, name, adrs, phn);
                        addBorrower(b);

                    } while (rs.next());

                }

                /*----Populating Loan----*/

                SQL = "SELECT * FROM LOAN";

                rs = stmt.executeQuery(SQL);
                if (!rs.next()) {
                    System.out.println("No Books Issued Yet!");
                } else {
                    do {
                        int borid = rs.getInt("BORROWER");
                        int bokid = rs.getInt("BOOK");
                        int iid = rs.getInt("ISSUER");
                        Integer rid = (Integer) rs.getObject("RECEIVER");
                        int rd = 0;
                        Date rdate;

                        Date idate = new Date(rs.getTimestamp("ISS_DATE").getTime());

                        if (rid != null) // if there is a receiver
                        {
                            rdate = new Date(rs.getTimestamp("RET_DATE").getTime());
                            rd = (int) rid;
                        } else {
                            rdate = null;
                        }

                        boolean fineStatus = rs.getBoolean("FINE_PAID");

                        boolean set = true;

                        Borrower bb = null;

                        for (int i = 0; i < getPersons().size() && set; i++) {
                            if (getPersons().get(i).getID() == borid) {
                                set = false;
                                bb = (Borrower) (getPersons().get(i));
                            }
                        }

                        set = true;
                        Staff s[] = new Staff[2];
                        // If not returned yet...
                        if (rid == null) {
                            s[1] = null; // no reciever
                            rdate = null;
                        }

                    } while (rs.next());
                }

                /*----Populationg Hold Books----*/

                SQL = "SELECT * FROM ON_HOLD_BOOK";

                rs = stmt.executeQuery(SQL);
                if (!rs.next()) {
                    System.out.println("No Books on Hold Yet!");
                } else {
                    do {
                        int borid = rs.getInt("BORROWER");
                        int bokid = rs.getInt("BOOK");
                        Date off = new Date(rs.getDate("REQ_DATE").getTime());

                        boolean set = true;
                        Borrower bb = null;

                        ArrayList<Person> persons = lib.getPersons();

                        for (int i = 0; i < persons.size() && set; i++) {
                            if (persons.get(i).getID() == borid) {
                                set = false;
                                bb = (Borrower) (persons.get(i));
                            }
                        }

                        set = true;

                        ArrayList<Book> books = lib.getBooks();

                        for (int i = 0; i < books.size() && set; i++) {
                            if (books.get(i).getID() == bokid) {
                                set = false;
                            }
                        }
                    } while (rs.next());
                }

                /* --- Populating Borrower's Remaining Info---- */

                // Borrowed Books
                SQL = "SELECT ID,BOOK FROM PERSON INNER JOIN BORROWER ON ID=B_ID INNER JOIN BORROWED_BOOK ON B_ID=BORROWER ";

                rs = stmt.executeQuery(SQL);

                if (!rs.next()) {
                    System.out.println("No Borrower has borrowed yet from Library");
                } else {

                    do {
                        int id = rs.getInt("ID"); // borrower
                        int bid = rs.getInt("BOOK"); // book

                        Borrower bb = null;
                        boolean set = true;
                        boolean okay = true;

                        for (int i = 0; i < lib.getPersons().size() && set; i++) {
                            if (lib.getPersons().get(i).getClass().getSimpleName().equals("Borrower")) {
                                if (lib.getPersons().get(i).getID() == id) {
                                    set = false;
                                    bb = (Borrower) (lib.getPersons().get(i));
                                }
                            }
                        }

                        set = true;

                        ArrayList<Loan> books = loans;

                        for (int i = 0; i < books.size() && set; i++) {
                            if (books.get(i).getBook().getID() == bid && books.get(i) == null) {
                                set = false;
                                Loan bBook = new Loan(books.get(i).getBook());
                                bb.addBorrowedBook(bBook);
                            }
                        }

                    } while (rs.next());
                }

                ArrayList<Person> persons = lib.getPersons();

                /* Setting Person ID Count */
                int max = 0;

                for (int i = 0; i < persons.size(); i++) {
                    if (max < persons.get(i).getID())
                        max = persons.get(i).getID();
                }
            }
        }
    }
}
