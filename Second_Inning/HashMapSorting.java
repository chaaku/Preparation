package Second_Inning;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapSorting {

	public static void main(String args[]) throws ParseException {
		// let's create a map with Java releases and their code names
		HashMap<String, String> codenames = new HashMap<String, String>();
		codenames.put("dJDK 1.1.4", "Sparkler");
		codenames.put("fJ2SE 1.2", "Playground");
		codenames.put("wJ2SE 1.3", "Kestrel");
		codenames.put("sJ2SE 1.4", "Merlin");
		codenames.put("aJ2SE 5.0", "Tiger");
		codenames.put("cdJava SE 6", "Mustang");
		codenames.put("lJava SE 7", "Dolphin");
		System.out.println("HashMap before sorting, random order ");
		codenames.forEach((k, v) -> System.out.println("key: " + k + "     value: " + v));

		System.out.println("\nsort by keys with treeMap\n");
		TreeMap<String, String> treeMap = new TreeMap<String, String>(codenames);
		treeMap.forEach((k, v) -> System.out.println("key : " + k + "    value: " + v));

		System.out.println("\nSorting Map Based on keys and with user of comparator :\n");

		Map<Integer, String> unsortMap = new HashMap<Integer, String>();
		unsortMap.put(10, "z");
		unsortMap.put(5, "b");
		unsortMap.put(6, "a");
		unsortMap.put(20, "c");
		unsortMap.put(1, "d");
		unsortMap.put(7, "e");
		unsortMap.put(8, "y");
		unsortMap.put(99, "n");
		unsortMap.put(50, "j");
		unsortMap.put(2, "m");
		unsortMap.put(9, "f");

		System.out.println("\nSorting Map Based on Values :\n");

		List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(unsortMap.entrySet());
		Collections.sort(entryList, new Comparator<Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> obj1, Entry<Integer, String> obj2) {
				// TODO Auto-generated method stub
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		unsortMap.clear();
		for (Entry<Integer, String> entry : entryList) {
			unsortMap.put(entry.getKey(), entry.getValue());
			System.out.println("Key : " + entry.getKey() + "  Value : " + entry.getValue());
		}

	}

}
