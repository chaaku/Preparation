package TreePrograms;

public class SortedArrayToBST {

	class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		SortedArrayToBST tree = new SortedArrayToBST();
		int arr[] = new int[] { 2, 4, 6, 8, 10, 12 };
		int n = arr.length;

		Node root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("inorder traversal of constructed BST");
		tree.inOrder(root);
	}

	/*
	 * A function that constructs Balanced Binary Search Tree from a sorted array
	 */
	Node sortedArrayToBST(int arr[], int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		Node node = new Node(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	/* A utility function to print inorder traversal of BST */
	void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

}