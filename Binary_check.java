
public class Binary_check {

	static void isBinaryOrNot(int number) {
		boolean isBinary = true;

		while (number != 0) {
			int temp = number % 10; // Gives last digit of the number

			if (temp > 1) {
				isBinary = false;
				break;
			} else {
				number = number / 10; // Removes last digit from the number
			}
		}

		if (isBinary) {
			System.out.println("it is a binary number");
		} else {
			System.out.println("it is not a binary number");
		}
	}

	public static void main(String[] args) {
		isBinaryOrNot(11111021);

		isBinaryOrNot((101110));

		isBinaryOrNot((42578));

		isBinaryOrNot((10110101));
	}
}