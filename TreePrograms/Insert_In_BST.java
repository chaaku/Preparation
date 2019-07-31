package TreePrograms;

public class Insert_In_BST {

	public static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node rootNode = createBinaryTree();

		System.out.println("Before Insertion : ");
		printTree(rootNode);

		Node key = new Node(41);

		rootNode = insert(rootNode, key);

		System.out.println("\nAfter Insertion preorder: ");
		printTree(rootNode);
	}

	private static void printTree(Node rootNode) {
		// TODO Auto-generated method stub

		// Pre Order traversal

		if (rootNode != null) {
			System.out.println(rootNode.data);
			printTree(rootNode.left);
			printTree(rootNode.right);
		}
	}

	public static Node insert(Node root, Node key) {

		if (root == null)
			return key;

		if (key.data > root.data)
			root.right = insert(root.right, key);
		else if (key.data < root.data)
			root.left = insert(root.left, key);

		return root;
	}

	public static Node createBinaryTree() {

		Node rootNode = new Node(40);

		Node node30 = new Node(30);

		Node node20 = new Node(20);

		Node node10 = new Node(10);

		Node node50 = new Node(50);

		Node node60 = new Node(60);

		Node node70 = new Node(70);

		rootNode.left = node20;

		rootNode.right = node60;

		node60.left = node50;

		node60.right = node70;

		node20.left = node10;

		node20.right = node30;

		return rootNode;
	}
}
