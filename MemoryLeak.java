import java.util.HashMap;
import java.util.Scanner;

public class MemoryLeak {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a number between 1 and 100");
			int i = sc.nextInt(); // not shown
			System.out.println("Answer " + square(i));
		}
	}

	public static int square(int i) {

		HashMap cache = new HashMap();

		int result = i * i;

		cache.put(i, result);

		return result;
	}

}