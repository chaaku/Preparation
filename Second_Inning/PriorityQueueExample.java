package Second_Inning;

import java.util.*;

class Book implements Comparable<Book> {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Book b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class PriorityQueueExample {

	public static void main(String[] args) {
		Queue<Book> queue = new PriorityQueue<Book>();
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b4 = new Book(1, "2 Let us C", "2 Yashwant Kanetkar", "2 BPB", 7);
		Book b5 = new Book(11, "3 Let us C", "3 Yashwant Kanetkar", "3 BPB", 2);
		Book b6 = new Book(12, "4 Let us C", "4 Yashwant Kanetkar", "4BPB", 3);

		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		queue.add(b4);
		queue.add(b5);
		queue.add(b6);
		System.out.println("Traversing the queue elements:");
		// Traversing queue elements
		for (Book b : queue) {
			System.out.println("   " + b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
		queue.remove();
		queue.add(new Book(2, "Let us C", "Yashwant Kanetkar", "BPB", 8));
		System.out.println("\nAfter removing one book record:");
		for (Book b : queue) {
			System.out.println("   " + b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
	}
}
