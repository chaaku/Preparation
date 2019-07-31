
public class AnagramWithStringBuilder {

	public static void main(String[] args) {

		String s1 = "cha";
		String s2 = "H c a";

		System.out.println(isAnagram(s1, s2));
	}

	private static boolean isAnagram(String s1, String s2) {

		s1 = s1.replaceAll("\\s", "").toLowerCase();
		s2 = s2.replaceAll("\\s", "").toLowerCase();

		// System.out.println("s1 :"+s1+"\ns2 :" +s2);

		if (s1.length() != s2.length()) {
			System.out.println("here :");
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			int position = s2.indexOf(c);
			s2 = new StringBuilder(s2).deleteCharAt(position).toString();
		}
		if (s2.length() == 0)
			return true;
		else
			return false;
	}
}
