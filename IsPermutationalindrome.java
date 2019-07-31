import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class IsPermutationalindrome {
	public static void main(String[] args) {
		String s = "asdfgasmasasagfdsaaa";
		System.out.println(ispalindrome(s));
	}

	private static boolean ispalindrome(String s) {
		// TODO Auto-generated method stub

		HashMap<Character, Integer> map = new HashMap<>();

		int i = 0;

		while (i <= s.length() - 1) {

			int count = 0;
			char key = s.charAt(i);

			if (map.containsKey(key))
				count = map.get(key);
			map.put(key, ++count);
			i++;
		}

		for(Entry<Character, Integer> entry :map.entrySet()) {
			System.out.println("key "+entry.getKey() + " : value "+entry.getValue());
		}
		
		List<Integer> al = new ArrayList<Integer>(map.values());
		// System.out.println(al);

		int count = 0;
		for (int j : al) {
			int remainder = j%2;
			if (remainder == 1)
				count = count + 1;
		}

		if (count > 1)
			return false;
		else
			return true;
	}

}
