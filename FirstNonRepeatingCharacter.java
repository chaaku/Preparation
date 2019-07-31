import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "GEELS FOR GEELS AND CHANDAN";
		String k1 = "cccaslaasbccb";
		String s2 = "GEELS FOR GEELS AND CHANDAN";
		String s3 = "GEELS FOR GEELS AND CHANDAN";
		String s4 = "GEELS FOR GEELS AND CHANDAN";
		String s5 = "GEELS FOR GEELS AND CHANDAN";
		String s6 = "GEELS FOR GEELS AND CHANDAN";

		System.out.println("First non repeatinf character is : " + getFirstNonRepeatedChar(k1) + "\n");
		System.out.println(
				"First non repeating character using linkedHashMap is : " + getFirstNonRepeatedChar(k1) + "\n");
	}

	/*
	 * Using LinkedHashMap to find first non repeated character of String Algorithm
	 * : Step 1: get character array and loop through it to build a hash table with
	 * char and their count. Step 2: loop through LinkedHashMap to find an entry
	 * with value 1, that's your first non-repeated character, as LinkedHashMap
	 * maintains insertion order.
	 */
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

		for (char c : str.toCharArray()) {
//			These 2 lines can do what all codes are doing here.
//			if(str.indexOf(c)==str.lastIndexOf(c))
//				return c;
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		try {
			for (Entry<Character, Integer> entry : counts.entrySet()) {
				if (entry.getValue() == 1) {
					return entry.getKey();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		throw new RuntimeException("No unique value");
	}

	public static char firstNonRepeatedCharacter(String word) {
		HashMap<Character, Integer> scoreboard = new HashMap<>();
		// build table [char -> count]
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}
		// since HashMap doesn't maintain order, going through string again
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.get(c) == 1) {
				return c;
			}
		}
		throw new RuntimeException("No unique value");
	}

}