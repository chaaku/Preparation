package Second_Inning;

public class ToStringExample {

	int rollno;
	String name;
	String city;

	ToStringExample(int rollno, String name, String city) {
		this.rollno = rollno;
		this.name = name;
		this.city = city;
	}

	// overriding the toString() method
	@Override
	public String toString() {
		return rollno + " " + name + " " + city;
	}

	public static void main(String args[]) {
		ToStringExample s1 = new ToStringExample(101, "Raj", "lucknow");
		ToStringExample s2 = new ToStringExample(102, "Vijay", "ghaziabad");

		System.out.println(s1);// compiler writes here s1.toString()
		System.out.println(s2);// compiler writes here s2.toString()
	}
}
