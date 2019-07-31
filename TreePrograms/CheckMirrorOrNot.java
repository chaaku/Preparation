package TreePrograms;

public class CheckMirrorOrNot {

	public static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {

			this.data = data;
		}

	}

	public static void main(String[] args) {

		CheckMirrorOrNot check = new CheckMirrorOrNot();

		Node rootNode = new Node(1);

		rootNode.left = new Node(2);

		rootNode.right = new Node(3);

		rootNode.left.left = new Node(4);

		rootNode.left.right = new Node(5);

		Node root = new Node(1);

		root.left = new Node(3);

		root.right = new Node(2);

		root.right.left = new Node(5);

		root.right.right = new Node(4);

		if (check.areMirror(root, rootNode) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private boolean areMirror(Node a, Node b) {
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

		if (a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left))
			return true;

		return false;

	}

}