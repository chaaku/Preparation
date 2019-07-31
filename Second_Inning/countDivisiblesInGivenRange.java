package Second_Inning;

public class countDivisiblesInGivenRange {

	public static void main(String[] args) {
		// A and B define the range, M is the dividend
		int A = 4, B = 8, M = 2;

		// Printing the result
		System.out.println(countDivisibles(A, B, M));
	}

	private static int countDivisibles(int a, int b, int m) {

		if (a % m == 0 || b % m == 0)
			return ((b - a) / m) + 1;
		else
			return (b - a) / m;

	}
}