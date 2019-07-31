package TreePrograms;

import java.util.ArrayList;

public class IsPairPresentInBT {

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(30);
		root.left.left = new TreeNode(10);
		root.right = new TreeNode(70);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(90);
		root.right.left.left = new TreeNode(45);
		root.right.left.right = new TreeNode(60);

		isPairPresent(root, 120);
	}

	// Method that adds values of given BST into ArrayList
	// and hence returns the ArrayList
	static ArrayList<Integer> treeToList(TreeNode node, ArrayList<Integer> list) {
		// Base Case
		if (node == null)
			return list;

		treeToList(node.left, list);
		list.add(node.data);
		treeToList(node.right, list);

		return list;
	}

	// method that checks if there is a pair present
	static boolean isPairPresent(TreeNode node, int target) {
		// This list a1 is passed as an argument
		// in treeToList method
		// which is later on filled by the values of BST
		ArrayList<Integer> a2 = new ArrayList<>();

		// a2 list contains all the values of BST
		// returned by treeToList method
		a2 = treeToList(node, a2);

		System.out.println(a2);
		int start = 0, count = 0;
		// Starting index of a2

		int end = a2.size() - 1; // Ending index of a2

		while (start < end) {

			if (a2.get(start) + a2.get(end) == target) // Target Found!
			{
				System.out.println("Pair Found: " + a2.get(start) + " + " + a2.get(end) + " " + "= " + target);
				// return true;
				start++;
				end--;
				count++;

			}

			if (a2.get(start) + a2.get(end) > target) // decrements end
			{
				end--;
			}

			if (a2.get(start) + a2.get(end) < target) // increments start
			{
				start++;
			}
		}

		if (count == 0) {
			System.out.println("No such values are found!");
			return false;
		} else {
			System.out.println("\nTotal " + count + " pairs found.");
			return true;
		}
	}
}
