package Second_Inning;

public class Constructor {

	// static String str;
	// public Constructor() {
	// // TODO Auto-generated constructor stub
	// System.out.println("Here ");
	// str= "Hello world";
	// }
	//
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// Constructor c = new Constructor();
	// System.out.println(str);
	//
	// }

	public static void main(String[] args) {

		int a = 1, b = 2;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a + " " + b);
	}

}
