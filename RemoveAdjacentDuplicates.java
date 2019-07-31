
import java.util.Stack;

public class RemoveAdjacentDuplicates {
	public static void main(String[] args) {

		// String str = "AADBsddsCGGkkkkhkGGGkkmmkkklll";
		String str = "AACOCCOkdkddd";
		removeDuplicatesWithoutStack1(str);
		System.out.println();
		System.out.println(removeDuplicatesWithStack(str).toString());

	}

	private static void removeDuplicatesWithoutStack1(String str) {

		System.out.print(str.charAt(0) + " ");
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				continue;
			} else
				System.out.print(str.charAt(i) + " ");
		}

	}

	private static String removeDuplicatesWithStack(String str) {
		// TODO Auto-generated method stub

		Stack<Character> s = new Stack<Character>();

		if (str.isEmpty())
			return null;
		else if (str.length() == 1)
			return str;

		else {
			s.push(str.charAt(0));

			for (int i = 1; i < str.length(); i++) {

				if (!s.isEmpty() && s.peek() == str.charAt(i))
					s.pop();

				else if (str.charAt(i) == str.charAt(i - 1))
					continue;

				else
					s.push(str.charAt(i));
			}
		}
		return s.toString();
	}
}
