package Wallmart;

import java.util.*;
class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
public class PrintKSumPathInBinarytree {
	
	static Node root;
	private static void printKPath(Node root, int k) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		backtrack(root, list,k); 
		
	}
	
	private static void backtrack(Node root, List<Integer> list, int k) {
		// TODO Auto-generated method stub
		
		if(root==null)
			return;
		
		list.add(root.data);		
		backtrack(root.left,list,k);	
		backtrack(root.right,list,k);

		int sum=0;
		for(int i=list.size()-1; i>=0;i--) {
			sum=sum+list.get(i);
			if(sum==k) {
				printList(list);
				System.out.println();
			}
		}
		list.remove(list.size()-1);
	}

	private static void printList(List<Integer> list) {
		// TODO Auto-generated method stub
		for(int i :list)
			System.out.print(i+ " ");
	}

	public static void main(String args[])  
    { 
          
        /* Constructed binary tree is 
              10 
             /  \ 
           8     2 
          / \   / 
         3   5 2 
        */
        PrintKSumPathInBinarytree tree = new PrintKSumPathInBinarytree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2); 
   
        int k = 12; 
        printKPath(root, k); 
   

    }
}
