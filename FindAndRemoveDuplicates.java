import java.util.Arrays;
import java.util.HashSet;

public class FindAndRemoveDuplicates {

	public static void main(String[] args) {

		String[] strArray = { "abc", "def", "mno", "xyz", "pqr", "cha", "ku", "ku", "xyz", "def" };
		System.out.print(Arrays.toString(strArray));

		System.out.print("\n\nDuplicate Elements are : ");
		int n = strArray.length;

		if (n == 0)
			return;

		/*
		 * find all duplicate elements in a array With 2 for loop
		 * 
		 * for(int i=0; i<n;i++) { for(int j=i+1;j<n;j++) {
		 * 
		 * if(strArray[i]==strArray[j] && i!=j) { System.out.println(strArray[i]); } } }
		 * 
		 */

		// WIth the use of hashset find duplicate

		HashSet<String> set = new HashSet<String>();

		for (String str : strArray) {
			if (!set.add(str))
				System.out.print(str + " ");
		}

		// With use of hashset remove duplicate and print rest of the array

		set.clear();
		for (String str : strArray) {
			set.add(str);
		}
		System.out.print("\n\nAfter removing Duplicates : ");
		for (String str : set)
			System.out.print(str + " ");

	}
}