package ProblemSolvingBrainteaser;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
// Data structure to store a Binary Search Tree node

// Already declared in same package so removing this declaration

class Node_ {
	int data;
	Node_ left = null, right = null;

	Node_(int data) {
		this.data = data;
	}
}

public class KthSMallestNode {
	static ArrayList<Integer> arr = new ArrayList<>();

	// Recursive function to insert an key into BST
	public static Node_ insert(Node_ root, int key) {
		// if the root is null, create a new node an return it
		if (root == null) { 
			return new Node_(key);
		}

		// if given key is less than the root node, recurse for left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		// if given key is more than the root node, recurse for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static void getkthWithInOrder(Node_ root, int k, int reached) {
		
		if (root == null)
			return;
		else {
			reached+=1;
			getkthWithInOrder(root.left,k,reached);
			arr.add(root.data);
			getkthWithInOrder(root.right,k,reached);
		}

	}

	// Function to find k'th smallest element in BST
	// Here i denotes the number of nodes processed so far
	public static int kthSmallest(Node_ root, AtomicInteger i, int k) {
		// base case
		if (root == null) {
			return -1;
		}

		// search in left subtree
		int left = kthSmallest(root.left, i, k);

		// if k'th smallest is found in left subtree, return it
		if (left != -1) {
			return left;
		}

		// if current element is k'th smallest, return its value
		if (i.incrementAndGet() == k) {
			return root.data;
		}

		// else search in right subtree
		return kthSmallest(root.right, i, k);
	}

	// Function to find k'th smallest element in BST
	// Here i denotes the number of nodes processed so far
	public static int kthLargest(Node_ root, AtomicInteger i, int k) {
		// base case
		if (root == null) {
			return -1;
		}

		// search in left subtree
		int right = kthLargest(root.right, i, k);

		// if k'th smallest is found in left subtree, return it
		if (right != -1) {
			return right;
		}

		// if current element is k'th smallest, return its value
		if (i.incrementAndGet() == k) {
			return root.data;
		}

		// else search in right subtree
		return kthLargest(root.left, i, k);
	}
	
	// Function to find k'th smallest element in BST
	public static int kthSmallest(Node_ root, int k) {
		// maintain index to count number of nodes processed so far
		AtomicInteger i = new AtomicInteger(0);

		// traverse the tree in in-order fashion and return k'th element
		return kthSmallest(root, i, k);
	}
	
	// Function to find k'th smallest element in BST
	public static int kthLargest(Node_ root, int k) {
		// maintain index to count number of nodes processed so far
		AtomicInteger i = new AtomicInteger(0);

		// traverse the tree in in-order fashion and return k'th element
		return kthLargest(root, i, k);
	}

	// main function
	public static void main(String[] args) {
		Node_ root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key : keys) {
			root = insert(root, key);
		}

		int k = 4;
		int res = kthSmallest(root, k);
		
		int m = 1;
		System.out.println("Kth largest "+kthLargest(root, m));

		int reached=0;
		getkthWithInOrder(root,k,reached);

		if (res != -1) {
			System.out.print(res);
		} else {
			System.out.print("Invalid Input");
		}

		int count = 0;
		while (count != k) {
			count++;
		}

		System.out.println("\nInteger at " +k+"th position with inorder: " + arr.get(count - 1));
	}
}