package TreePrograms;

public class DeleteFromBinarytree {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	// Get minimum element in binary search tree
	public static TreeNode minimumElement(TreeNode root) {
		return root.left == null ? root: minimumElement(root.left);
	}

	public static TreeNode deleteNode(TreeNode root, int value) {
		if (root == null)
			return null;

		if (root.data > value)
			root.left = deleteNode(root.left, value);
		else if (root.data < value)
			root.right = deleteNode(root.right, value);

		else {
				// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
					TreeNode temp = root;
					// Finding minimum element from right
					TreeNode minNodeForRight = minimumElement(temp.right);
					// Replacing current node with minimum node from right subtree
					root.data = minNodeForRight.data;
	
					// Deleting minimum node from right now
					deleteNode(root.right, minNodeForRight.data);
				}
				// if nodeToBeDeleted has only left child
				else if (root.right== null)
					root = root.left;
	
				// if nodeToBeDeleted has only right child
				else if (root.left == null)
					root = root.right;
	
				// if nodeToBeDeleted do not have child (Leaf node)
				else
					root = null;
			}

		return root;
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void main(String[] args) {

		// Creating a binary search tree
		TreeNode rootNode = createBinarySearchTree();

		System.out.println("Binary tree:\n");
		inOrder(rootNode);
		System.out.println();
		System.out.println("\nDeleting node 40 which have two children:\n");
		TreeNode rootNodeRes = deleteNode(rootNode, 40);
		inOrder(rootNodeRes);
	}

	public static TreeNode createBinarySearchTree() {
		TreeNode rootNode = new TreeNode(40);

		TreeNode node30 = new TreeNode(30);

		TreeNode node20 = new TreeNode(20);

		TreeNode node10 = new TreeNode(10);

		TreeNode node50 = new TreeNode(50);

		TreeNode node60 = new TreeNode(60);

		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;

		rootNode.right = node60;

		node60.left = node50;

		node60.right = node70;

		node20.left = node10;

		node20.right = node30;

		return rootNode;
	}
}