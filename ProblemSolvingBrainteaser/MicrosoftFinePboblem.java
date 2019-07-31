package ProblemSolvingBrainteaser;

public class MicrosoftFinePboblem {

	public static void main(String[] args) {

		int a[] = { 3, 5, 4, 6, 8, 5, 3, 1, 7, 2, 8 };
		int n = 14;
		System.out.println(findFine(a, n));

	}

	private static int findFine(int[] a, int n) {

		int fine = 0;
		for (int i : a) {

			if (i % 2 == 0 && n % 2 != 0)
				fine += 250;

			if (i % 2 != 0 && n % 2 == 0)
				fine += 250;
		}

		return fine;

	}

}
