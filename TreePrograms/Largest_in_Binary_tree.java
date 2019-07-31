package TreePrograms;

public class Largest_in_Binary_tree {

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
		System.out.println("Max node using recursion : " + getMaximumRec(rootNode));
	}

	public static int getMaximumRec(TreeNode root) {

		if (root == null)
			return -1;

		int left, right;
		int max = 0;

		if (root != null) {

			int value = root.data;

			left = getMaximumRec(root.left);
			right = getMaximumRec(root.right);

			if (left > right)
				max = left;
			else
				max = right;

			if (value > max)
				max = value;
		}
		return max;
	}

	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
