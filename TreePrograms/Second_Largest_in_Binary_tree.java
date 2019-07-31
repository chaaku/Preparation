package TreePrograms;

public class Second_Largest_in_Binary_tree {
	
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		TreeNode rootNode = createBinaryTree();
		System.out.println("Second Max node using recursion : " + findSecondLargest(rootNode));

		System.out.println(" Max node using recursion : " + findLargest(rootNode));
	}

	private static int findLargest(TreeNode rootNode) {

		while (rootNode.right != null) {
			rootNode = rootNode.right;
		}
		return rootNode.data;
	}

	public static int findSecondLargest(TreeNode rootNode) {

		if (rootNode == null || (rootNode.left == null && rootNode.right == null))
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		TreeNode current = rootNode;

		while (true) {

			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargest(current.left);
			}

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null && current.right.left == null && current.right.right == null)
				return current.data;

			current = current.right;
		}
	}
	
	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(90);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
