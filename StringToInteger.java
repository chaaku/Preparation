import javax.management.RuntimeErrorException;

public class StringToInteger {
	public static void main(String[] args) {

		String s = "-74668657";

		System.out.println(myAtoi(s));

	}

	private static int myAtoi(String str) {
		// TODO Auto-generated method stub

		if (str.isEmpty())
			throw new RuntimeErrorException(null, "Not a valid input");

		boolean flag = false;
		if (str.charAt(0) == '-') {
			flag = true;
			str = str.substring(1, str.length());
		}
		str = str.trim();
		int result = str.charAt(str.length() - 1) - '0';

		int j = 10;
		for (int i = str.length() - 2; i >= 0; i--) {
			result = (str.charAt(i) - '0') * j + result;
			j = j * 10;

		}

		if (flag == true)
			result = result * -1;

		if (result == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return result;
	}

}
