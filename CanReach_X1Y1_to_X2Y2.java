import java.util.Scanner;

public class CanReach_X1Y1_to_X2Y2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();

		System.out.println(canReach(x1, x2, y1, y2));
		sc.close();
	}

	public static String canReach(int x1, int x2, int y1, int y2) {

		while (x1 < x2 && y1 < y2) {

			int temp = x1 + y1;
			boolean b = true;

			if (temp < x2 && b == true) {
				x1 = x1 + temp;
				b = false;
			}

			if (temp < y2) {
				y1 = y1 + temp;
				b = true;
			}
		}

		if (x1 == x2 && y1 == y2)
			return "Yes";
		else
			return "No";
	}

}
