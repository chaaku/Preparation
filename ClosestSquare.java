
public class ClosestSquare {
	public static void main(String[] args) {

		int n = 48;
		System.out.println(close(n));
	}

	public static double close(int n) {

		if (Math.floor(Math.sqrt(n)) == Math.ceil(Math.sqrt(n)))
			return n;
		else {
			double res = ((Math.sqrt(n) - Math.floor(Math.sqrt(n)) > Math.ceil(Math.sqrt(n)) - Math.sqrt(n))
					? (Math.ceil(Math.sqrt(n))) * (Math.ceil(Math.sqrt(n)))
					: (Math.floor(Math.sqrt(n)) * (Math.floor(Math.sqrt(n)))));

			return res;
		}

	}

}
