
public class Overloading {

	// methods with same name but different i/p parameters.

	int add(int a, int b) {
		return a + b;
	}

	int add(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String args) {
		System.out.println("main with String");
	}

	public static void main() {
		System.out.println("main without args");
	}

	public static void main(String[] args) {
		System.out.println("main with String[ ] called");

		Overloading obj = new Overloading();
		System.out.println(obj.add(10, 20));
		System.out.println(obj.add(10, 20, 30));
		System.out.println(obj.add(10, 20, 10));
		Overloading.main(); // you can call explicitly with object.
		Overloading.main("args");

	}

}
