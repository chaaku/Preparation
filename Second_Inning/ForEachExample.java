package Second_Inning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> gamesList = new ArrayList<String>();
		gamesList.add("Football");
		gamesList.add("Cricket");
		gamesList.add("Chess");
		gamesList.add("Hocky");
		System.out.println("------------Iterating by passing lambda expression--------------");
		gamesList.forEach(games -> System.out.println(games));

		System.out.println("------------Iterating by syso--------------");
		gamesList.forEach(System.out::println);

		System.out.println();
		HashMap<String, Integer> items = new HashMap<String, Integer>();

		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> System.out.println("Item : " + k + " value : " + v));

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " value : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});

	}
}
