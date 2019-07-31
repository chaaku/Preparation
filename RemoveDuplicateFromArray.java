import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {

		String arr[] = { "chandan", "is", "chandan", "so", "what", "i", "can", "do", "what", "you", "cannot", "do",
				"am", "i", "right", "so", "what" };

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			String keyString = arr[i];
			if (map.containsKey(keyString)) {
				count = map.get(keyString);
			}
			map.put(arr[i], ++count);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
			}

		}
	}
}
