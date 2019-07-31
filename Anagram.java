import java.util.HashMap;

public class Anagram {

	public static void main(String[] args) {

		String s1 = "Hi This is greatest chutia of this planet";
		String s0 = "H Th igreatchutia of txzhplanet is est s is i";

//		String s1 = " grea t ed";
//		String s0 = "rg eat ed ";

		
		int [] arr = new int[27];
		
		for(int i=0; i<s1.length();i++) {
			
			if(s1.toLowerCase().charAt(i)==' ')
				arr[26]++;
			else 
				arr[s1.toLowerCase().charAt(i)-'a']++;			
		}
		
		for(int i=0; i<s1.length();i++) {
			
			if(s0.toLowerCase().charAt(i)==' ')
				arr[26]--;
			else 
			arr[s0.toLowerCase().charAt(i)-'a']--;
		}
		
		boolean flag =true;
		for(int i:arr)
			if(i>0)
			flag=false;
		
		if(flag==true)
			System.out.println("Anagram");
		else
			System.out.println("Not anagram");
		
		
		System.out.println(isAnagram(s1, s0));
	}

	public static boolean isAnagram(String s1, String s2) {

		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");

	//	System.out.println("s1 :" + s1 + "\ns2 :" + s2);

		if (s1.length() != s2.length())
			return false;
		else {

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			for (int i = 0; i < s1.length(); i++) {

				char keychar = s1.charAt(i);
				int count = 0;

				if (map.containsKey(keychar)) {
					count = map.get(keychar);
				}

				map.put(keychar, ++count);

				keychar = s2.charAt(i);
				count = 0;

				if (map.containsKey(keychar)) {
					count = map.get(keychar);
				}

				map.put(keychar, --count);

			}

			for (int value : map.values()) {
				if (value == 0)
					return true;
			}

		}
		return false;
	}
}
