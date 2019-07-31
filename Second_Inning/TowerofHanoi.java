package Second_Inning;

public class TowerofHanoi {

	public static void main(String[] args) {
		move(5, 1, 3);
	}

	public static void move(int n, int startPole, int endPole) {

		if (n == 0) {
			return;
		}

		int intermediatePole = 6 - startPole - endPole;
		move(n - 1, startPole, intermediatePole);
		System.out.println("Move disk " + n + " from " + startPole + " to " + endPole);
		move(n - 1, intermediatePole, endPole);

	}
}