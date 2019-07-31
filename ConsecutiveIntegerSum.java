import java.util.Scanner;

public class ConsecutiveIntegerSum {

	// program to get the count and all consequitive integers whose sum is equal to
	// the given number

	public static void main(String[] args) {

		System.out.println("Please enter the number : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int j = 0, sum = 0, c = 0;
		for (int i = 0; i < n/2 + 1; i++) {
			sum = i;
			j = i + 1;

			while (sum < n) {
				sum = sum + j;
				j++;
			}

			if (sum == n) {
				c++;
				for (int k = i; k < j; k++) {
					System.out.print( k+" ");
				}
				System.out.println();
			}

		}
		if (c > 0)
			System.out.println("\nCount is :  " + c);
		else
			System.out.println("No Numbers found ");

	}
}