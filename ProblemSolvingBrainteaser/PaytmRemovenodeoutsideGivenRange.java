package ProblemSolvingBrainteaser;

class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
}

public class PaytmRemovenodeoutsideGivenRange {

	// Removes all nodes having value
	// outside the given range and
	// returns the root of modified tree
	private static TreeNode removeOutsideRange(TreeNode root, int min, int max) {
		// BASE CASE
		if (root == null) {
			return null;
		}

		// FIRST FIX THE LEFT AND
		// RIGHT SUBTREE OF ROOT
		root.left = removeOutsideRange(root.left, min, max);
		root.right = removeOutsideRange(root.right, min, max);

		// NOW FIX THE ROOT. THERE ARE
		// TWO POSSIBLE CASES FOR THE ROOT
		// 1. a) Root's key is smaller than
		// min value(root is not in range)
		if (root.key < min) {
			TreeNode rchild = root.right;
			root = null;
			return rchild;
		}

		// 1. b) Root's key is greater than
		// max value (Root is not in range)
		if (root.key > max) {
			TreeNode lchild = root.left;
			root = null;
			return lchild;
		}

		// 2. Root in range
		return root;
	}

	public static TreeNode newTreeNode(int num) {
		TreeNode temp = new TreeNode();
		temp.key = num;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public static TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return newTreeNode(key);
		}
		if (root.key > key) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	private static void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
	}

	// Driver code
	public static void main(String[] args) {
		TreeNode root = null;
		root = insert(root, 6);
		root = insert(root, -13);
		root = insert(root, 14);
		root = insert(root, -8);
		root = insert(root, 15);
		root = insert(root, 13);
		root = insert(root, 7);

		System.out.print("Inorder Traversal of " + "the given tree is: ");
		inorderTraversal(root);

		root = removeOutsideRange(root, -10, 13);

		System.out.print("\nInorder traversal of " + "the modified tree: ");
		inorderTraversal(root);
	}
}
