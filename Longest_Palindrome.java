
public class Longest_Palindrome {

	public static void main(String[] args) {

		/*
		 * System.out.println(longestPalindrome("1234"));
		 * System.out.println(longestPalindrome("12321"));
		 * System.out.println(longestPalindrome("9912321456"));
		 * System.out.println(longestPalindrome("9912333321456"));
		 * System.out.println(longestPalindrome("12145445499"));
		 * /*System.out.println(longestPalindrome("1223213"));
		 * System.out.println(longestPalindrome("abba"));
		 */
		System.out.println(longest("1234xyzyx5678"));
		String input = "abcdefeabc";
		System.out.println(longest(input));

	}

	public static String longest(String s) {

		if (s.length() == 0)
			return null;

		if (s.length() == 1)
			return s;

		String longest = s.substring(0, 1);
		// System.out.println(longest);

		for (int i = 1; i < s.length(); i++) {

			String temp = helper(s, i, i);
			//1234xyzyx5678
			// get longest palindrome with center of i, Like 121
			if (temp.length() > longest.length())
				longest = temp;

			// get longest palindrome with center of i, i+1,like 1221
			temp = helper(s, i, i + 1);
			if (temp.length() > longest.length())
				longest = temp;
		}
		return longest;
	}

	// Given a center, either one letter or two letter,
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin +1, end);
	}
}
