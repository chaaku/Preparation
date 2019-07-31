package TreePrograms;

public class Nutanix {

	public static class Node {

		Node parent;
		Node left, right;
		int value;

		public Node(int value) {
			this.value = value;
			left = right = null;

		}
	}

	public static void main(String[] args) {

		// storing a BST so, after inorder traversal
		// i will have a the node values in increasing order

		Node root = new Node(40);
		root.left = new Node(20);
		root.left.left = new Node(10);
		root.left.right = new Node(30);
		root.right = new Node(60);
		root.right.left = new Node(50);
		root.right.right = new Node(90);

		System.out.print("In-Order Traversal of the tree is : ");
		traverse(root);
	}

	// I am doing in-order traversal

	public static void traverse(Node rootNode) {

		if (rootNode == null)
			return;

		Node previousNode;

		while (rootNode != null) {
			if (rootNode.left == null) {
				System.out.print(rootNode.value + " ");
				rootNode = rootNode.right;
			}

			else {
				previousNode = rootNode.left;
				while (previousNode.right != null && previousNode.right != rootNode)
					previousNode = previousNode.right;

				if (previousNode.right == null) {
					previousNode.right = rootNode;
					rootNode = rootNode.left;
				} else {
					System.out.print(rootNode.value + " ");
					previousNode.right = null;
					rootNode = rootNode.right;
				}
			}
		}

	}
}

// Here complexity will be ~ O(n) where n is no. of nodes
// because i am traversing every leaf node once and non-leaf maximum by 2 times.
