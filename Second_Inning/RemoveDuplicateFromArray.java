package Second_Inning;

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

	/*
	 * simplest approach
	 * 
	 * int [] arr = {1,1,2,2,3,4,5,6,6,7,8,8,9 }; 
	 * System.out.print(arr[0]+" ");
	 * 
	 * for(int i=1;i<arr.length;i++) 
	 * {
	 * 	 boolean b =true; 
	 * 	if(arr[i]==arr[i-1]) 
	 * 	{ 
		 	b = false; 
		 	continue;
		 } 
		 if(b==true) 
		 	System.out.print(arr[i]+ " "); 
		 }
	 * 
	 * }
	 * 
	 */
}
