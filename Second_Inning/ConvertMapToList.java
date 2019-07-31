package Second_Inning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertMapToList {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(10, "apple");
		map.put(20, "orange");
		map.put(30, "banana");
		map.put(40, "watermelon");
		map.put(50, "dragonfruit");

		System.out.println("\n1. Export Map Key to List...");

		List<Integer> result = new ArrayList(map.keySet());

		result.forEach(System.out::println);

		// for(int i: result)
		// System.out.print(i+ " ");

		System.out.println("\n2. Export Map Value to List...");

		List<String> result2 = new ArrayList(map.values());

		result2.forEach(System.out::println);
		// _______________________________________________________________________________

		System.out.println("\n\nForEach in map with lambda Expression\n");
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		System.out.println();

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});
		// _________________________________________________________________________________

		// System.out.println("\n\nForEach in list with lambda Expression\n");
		// List<String> itemLists = new ArrayList<>();
		// itemLists.add("A");
		// itemLists.add("B");
		// itemLists.add("C");
		// itemLists.add("D");
		// itemLists.add("E");
		//
		// //lambda
		// //Output : A,B,C,D,E
		// itemLists.forEach(itemList->System.out.println(itemList));
		//
		// //Output : C
		// itemLists.forEach(itemList->{
		// if("C".equals(itemList)){
		// System.out.println(itemList);
		// }
		// });
		//
		// //method reference
		// //Output : A,B,C,D,E
		// itemLists.forEach(System.out::println);
		//
		// //Stream and filter
		// //Output : B
		// itemLists.stream()
		// .filter(s->s.contains("B"))
		// .forEach(System.out::println);
	}
}
