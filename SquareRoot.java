
public class SquareRoot {

	public static void main(String[] args) {

		int n = 224;

		System.out.println(sqrt(n));

	}

	private static double sqrt(int n) {
		// TODO Auto-generated method stub
		double lo = 0, hi = n, mid = 0;
		for (int i = 0; i < n; i++) {
			mid = (lo + hi) / 2;
			if (mid * mid == n)
				return mid;
			if (mid * mid > n)
				hi = mid;
			else
				lo = mid;
		}
		return mid;
	}

	private static double sqrt2(int n) {
		// TODO Auto-generated method stub

		double temp;
		double squareRoot = n / 2;

		do {
			temp = squareRoot;
			squareRoot = (temp + (n / temp)) / 2;
		} while ((temp - squareRoot) != 0);

		return squareRoot;
	}

}