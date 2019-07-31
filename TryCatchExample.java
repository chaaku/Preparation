
public class TryCatchExample {

	public static void main(String[] args) {
		int i = 5;
		try {
			i = Integer.parseInt("I");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("exception handled");
		}

		System.out.println("Print this ");
		System.out.println(i);
		System.out.println("Print this ");
	}
}
