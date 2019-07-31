import java.util.*; 
		 
public class WallmartTopological {
	
	Stack<Node> stack;
 
	public WallmartTopological() {
		stack=new Stack<>();
	}
	static class Node
	{
		String data;
		boolean visited;
		List<Node> neighbours;
 
		Node(String data)
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
		
		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}
		
		public List<Node> getNeighbours() {
			return neighbours;
		}
		
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
		
		public String toString() {
			return ""+data;
		}
	}
		 
			// Recursive toplogical Sort
	public  void toplogicalSort(Node node)
	{
		List<Node> neighbours=node.getNeighbours();
		for (int i = 0; i < neighbours.size(); i++) {
			Node n=neighbours.get(i);
			if(n!=null && !n.visited)
			{
				toplogicalSort(n);
				n.visited=true;
			}
		}
		stack.push(node);
	}
	 
	public static void main(String arg[])
	{
 
		WallmartTopological topological = new WallmartTopological();
		Node A =new Node("A");
		Node B =new Node("B");
		Node C =new Node("C");
		Node D =new Node("D");
		
		B.addneighbours(A);
		C.addneighbours(A);
		C.addneighbours(B);
		D.addneighbours(B);
		C.addneighbours(D);
 
		System.out.println("Topological Sorting Order:");
		topological.toplogicalSort(C);
		
		// Print contents of stack
		Stack<Node> resultStack=topological.stack;
		while (resultStack.empty()==false)
			System.out.print(resultStack.pop() + " ");
	}
		 
}