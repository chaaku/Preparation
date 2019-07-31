import java.util.HashMap;

public class Intuit1234 {
	public static void main(String[] args) {

		String s = "12134";
		getinWorgs(s);
	}

	private static void getinWorgs(String s) {
		// TODO Auto-generated method stub

		int length = s.length();
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();
		map.put(1, "test");
		System.out.println(map2.get(s.substring(1, length)).length());
		System.out.println("result is " + "just the if else and getting the value from map");

	}

}
