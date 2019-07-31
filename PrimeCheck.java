
public class PrimeCheck {
	public static void main(String arge[]) {

		int n = 100;
		System.out.println("Prime numbers till " + n + " is :");

		for (int j = 1; j <= n; j++) {
			int flag = 0;

			for (int i = 2; i <= j / 2; i++) {
				if (j % i == 0) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				System.out.println(j + " ");
			}
		}
	}
}
