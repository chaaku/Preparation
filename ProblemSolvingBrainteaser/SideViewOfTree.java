package ProblemSolvingBrainteaser;

class SideViewNode {
	int data;
	SideViewNode left, right;

	public SideViewNode(int item) {
		data = item;
		left = right = null;
	}
}

public class SideViewOfTree { // className

	static SideViewNode root;
	static int max_level_left = 0, max_level_right = 0;
	
	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		SideViewOfTree tree = new SideViewOfTree();
		SideViewOfTree.root = new SideViewNode(12);
		SideViewOfTree.root.left = new SideViewNode(10);
		SideViewOfTree.root.right = new SideViewNode(30);
		SideViewOfTree.root.right.left = new SideViewNode(25);
		SideViewOfTree.root.right.right = new SideViewNode(40);

		System.out.println("left subtree : ");
		tree.leftView(SideViewOfTree.root, 1);

		SideViewOfTree tree2 = new SideViewOfTree();
		SideViewOfTree.root = new SideViewNode(1);
		SideViewOfTree.root.left = new SideViewNode(2);
		SideViewOfTree.root.right = new SideViewNode(3);
		SideViewOfTree.root.left.left = new SideViewNode(4);
		SideViewOfTree.root.left.right = new SideViewNode(5);
		SideViewOfTree.root.right.left = new SideViewNode(6);
		SideViewOfTree.root.right.right = new SideViewNode(7);
		SideViewOfTree.root.right.left.right = new SideViewNode(8);

		System.out.println("\n\nRight subtree : ");
		tree.rightView(SideViewOfTree.root, 1);
		

		// Time Complexity: The function does a simple traversal of the tree,
		// so the complexity is O(n).
	}

	
	void leftView(SideViewNode node, int level) // leftView Method
	{
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level_left < level) {
			System.out.print(" " + node.data);
			max_level_left = level;
		}

		// Recur for left and right subtrees
		leftView(node.left, level + 1);
		leftView(node.right, level + 1);
	}

	void rightView(SideViewNode node, int level) {

		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level_right < level) {
			max_level_right = level;
			System.out.print(" " + node.data);
		}

		// Recur for left and right subtrees
		rightView(node.right, level + 1);
		rightView(node.left, level + 1);
	}


}
