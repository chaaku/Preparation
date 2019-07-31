package TreePrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// inorder, iterative, postorder, preorder

public class BinaryTreeInPrePostOrderIterTraversal {

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {

		Node node = BinaryTreeInPrePostOrderIterTraversal.createBinaryTree();

		System.out.println("\ninorder traver of the tree is : ");
		inOrderIter(node);

		System.out.println("\nPreorder traver of the tree is : ");
		preorderIter(node);

		System.out.println("\nPostorder traver of the tree with one stack is : ");
		nonRecursivePostorder(node);

		System.out.println("\nPostorder traver of the tree with list is : ");
		List<Integer> l = postorderTraversalWithList(node);
		for (int i : l)
			System.out.print(i + " ");

	}

	public static void preorder(Node root) {

		if (root == null)
			return;

		else {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void preorderIter(Node root) {

		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.empty()) {

			Node n = stack.pop();
			System.out.printf("%d ", n.data);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	public static void inorder(Node root) {

		if (root == null)
			return;

		else {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	public static void inOrderIter(Node root) {

		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node currentNode = root;

		while (!s.empty() || currentNode != null) {

			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				Node n = s.pop();
				System.out.printf("%d ", n.data);
				currentNode = n.right;
			}
		}
	}

	public static void postorder(Node root) {

		if (root == null)
			return;

		else {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}

	public static List<Integer> postorderTraversalWithList(Node root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				Node pop = stack.pop();
				res.add(pop.data);
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}

				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}

		return res;
	}

	public static void nonRecursivePostorder(Node rootNode) {
        Node current = rootNode;
        Stack<Node> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        	temp = stack.pop();
                        	System.out.print(temp.data + " ");
                    	}
                	} 
                else {
                    current = temp;
                }
            }
        }
    }
	// //https://www.youtube.com/results?search_query=post+order+non+recursive
	// Stack<Node> nodeStack = new Stack<Node>();
	// nodeStack.push(rootNode);
	// boolean visitedLeft= false, visitedRight = false;
	// while (! nodeStack.empty()) {
	// Node currNode = nodeStack.peek();
	//
	// if ((currNode.left != null) && (visitedLeft = false)) {
	// nodeStack.push(currNode.left);
	// visitedLeft=true;
	// }
	//
	// else {
	// if (currNode.right != null && visitedRight == false) {
	// nodeStack.push(currNode.right);
	// visitedRight=true;
	// }else {
	// System.out.println(currNode.data);
	// visitedLeft= true;
	// nodeStack.pop();
	// }
	// }
	// }
	// }

	public static void postorderIter(Node root) {
		if (root == null)
			return;

		// With two stack

		Stack<Node> s = new Stack<Node>();
		Stack<Node> out = new Stack<Node>();
		s.push(root);
		
		while (!s.isEmpty()) {
			Node temp = s.pop();
			out.push(temp);

			if (temp.left != null)
				s.push(temp.left);
			if (temp.right != null)
				s.push(temp.right);
		}

		while (!out.isEmpty())
			System.out.println(out.pop().data + " ");

	}

	public static Node createBinaryTree() {

		Node rootNode = new Node(40);

		rootNode.left = new Node(20);

		rootNode.left.left = new Node(10);
		rootNode.left.right = new Node(30);

		rootNode.right = new Node(60);
		rootNode.right.left = new Node(50);

		rootNode.right.right = new Node(80);
		rootNode.right.right.left = new Node(70);

		return rootNode;
	}

}