package Second_Inning;

// Java program to demonstrate working of Comparator 
// interface 
import java.util.*;

// A class to represent a student. 
class Stu {
	int rollno;
	String name, address;

	// Constructor
	public Stu(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	@Override
	public String toString() {
		return "roll number : " + this.rollno + " name :" + this.name + " salary : " + this.address;
	}
}

class Sortbyroll implements Comparator<Stu> {
	// Used for sorting in ascending order of
	// roll number
	@Override
	public int compare(Stu a, Stu b) {
		return a.rollno - b.rollno;
	}
}

class Sortbyname implements Comparator<Stu> {
	// Used for sorting in ascending order of
	// name
	@Override
	public int compare(Stu a, Stu b) {
		return a.name.compareTo(b.name);
	}
}

// Driver class
class ComparatorExample {
	public static void main(String[] args) {
		ArrayList<Stu> ar = new ArrayList<Stu>();
		ar.add(new Stu(111, "bbbb", "london"));
		ar.add(new Stu(131, "aaaa", "nyc"));
		ar.add(new Stu(121, "cccc", "jaipur"));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new Sortbyroll());

		System.out.println("\nSorted by rollno");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new Sortbyname());

		System.out.println("\nSorted by name");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}
}
