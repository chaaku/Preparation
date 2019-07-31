package TreePrograms;

// Java program to find maximum path sum between two leaves 
// of a binary tree 

//  https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
class ResNode {

	int data;
	ResNode left, right;

	ResNode(int item) {
		data = item;
		left = right = null;
	}
}

class MaximumSumOfNodes {

	static int res=Integer.MIN_VALUE;
	static ResNode root;

	// A utility function to find the maximum sum between any
	// two leaves.This function calculates two values:
	// 1) Maximum path sum between two leaves which is stored
	// in res.
	// 2) The maximum root to leaf path sum which is returned.
	// If one side of root is empty, then it returns INT_MIN
	int maxPathSum(ResNode node, int res) {

		// Base cases
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.data;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right subtrees and store them in
		// ls and rs
		int ls = maxPathSum(node.left, res);
		int rs = maxPathSum(node.right, res);

		// If both left and right children exist
		if (node.left != null && node.right != null) {

			// Update result if needed
			res = Math.max(res, ls + rs + node.data);

			// Return maxium possible value for root being
			// on one side
			return Math.max(ls, rs) + node.data;
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (node.left == null) ? rs + node.data : ls + node.data;
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		MaximumSumOfNodes tree = new MaximumSumOfNodes();
		MaximumSumOfNodes.root = new ResNode(-1);
		MaximumSumOfNodes.root.left = new ResNode(-2);
		MaximumSumOfNodes.root.right = new ResNode(6);
		 tree.root.left.left = new ResNode(-8);
		 tree.root.left.right = new ResNode(1);
		 tree.root.left.left.left = new ResNode(2);
		 tree.root.left.left.right = new ResNode(6);
		 tree.root.right.left = new ResNode(3);
		 tree.root.right.right = new ResNode(9);
		 tree.root.right.right.right = new ResNode(0);
		 tree.root.right.right.right.left = new ResNode(4);
		 tree.root.right.right.right.right = new ResNode(-1);
		 tree.root.right.right.right.right.left = new ResNode(10);
		System.out.println("Max pathSum of the given binary tree is " + tree.maxPathSum(root,res));
	}
}

// This code is contributed by Mayank Jaiswal
