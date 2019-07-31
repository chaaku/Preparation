
public class IsBalanced {
	
	private class Node{
		int value;
		Node left,right;
	}

	private boolean isBalancedTree(Node n) {
		
		if(heightOfBalancedTree(n) != -1) return true;
		return false;
	}
	
	
	private static int heightOfBalancedTree(Node n) {
		
		if (n==null)
			return 0;
		
		int lheight = heightOfBalancedTree(n.left);
		int rheight = heightOfBalancedTree(n.right);
		
		if(lheight==-1|| rheight==-1) return -1;
			
		if(Math.abs(lheight-rheight)>1) return -1;
		
		if(lheight>rheight) return lheight+1;
		
		return rheight+1;
		
	}
	
}
