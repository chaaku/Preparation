
import java.util.*;

public class TestClass {
	
	static int level =1;
	
	static class Node{ 
        int data; 
        Node left; 
        Node right; 
          
        //constructor 
        Node(int data) 
        { 
            this.data=data; 
            left = null; 
            right =null; 
        } 
    }
	

	private static void print(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;

		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		PrintRecursively(root, 0, map);
		
		for(java.util.Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
		
	private static void PrintRecursively(Node root, int i, HashMap<Integer, ArrayList<Integer>> map) {
		// TODO Auto-generated method stub
		
		if(root==null)
			return;
		
		ArrayList<Integer> list = map.get(i);
		
		if(list==null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
		}
		
		else {
			list.add(root.data);
		}
		
		map.put(i, list);
		PrintRecursively(root.left, i+1, map);
		PrintRecursively(root.right, i, map);
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(8); 
        root.left = new Node(3); 
        root.right = new Node(10); 
        root.left.left = new Node(1); 
        root.left.right = new Node(6); 
        root.right.right = new Node(14); 
        root.right.right.left = new Node(13); 
        root.left.right.left = new Node(4); 
        root.left.right.right = new Node(7);
		
        print(root);
	
	
	}

}
