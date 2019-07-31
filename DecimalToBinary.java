import java.util.Scanner;
import java.util.Stack;

/*  DecimalToBinaryUsingStacks  */
public class DecimalToBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();

		System.out.println("Enter the Decimal number : ");
		int n = sc.nextInt();

		System.out.println("Binary equivalent is : ");

		while (n != 0) {

			int temp = n % 2;
			s.push(temp);
			n = n / 2;
		}
		while (!s.isEmpty())
			System.out.print(s.pop());

		System.out.println();
	}
}