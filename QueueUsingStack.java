package Wallmart;

import java.util.Stack;


public class QueueUsingStack <Element>{
	
	Stack<Element> stack ;

	public QueueUsingStack() {
		stack = new Stack<>();
	}
	
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public Element poll() {
		return stack.peek();
	}
	
	
	public void enQueue(Element data){
		  stack.push(data);
	}
		 
	public Element deQueue(){
	  if(stack.size()<1){
	   System.out.println("Nothing to deQueue");
	   return null;
	  }
	 
	  if(stack.size()==1){
		  return stack.pop();
	  }
	 
	  Element data = stack.pop();
	  Element temp = deQueue();
	  stack.push(data);
	  return temp;
	 
	}
	
	public static void main(String[] args) {
		
		QueueUsingStack<String> q = new QueueUsingStack<>();  
	    q.enQueue("1");  
	    q.enQueue("2");  
	    q.enQueue("3");  
	  
	    System.out.println(q.deQueue());  
	    System.out.println(q.deQueue()); 
	    System.out.println(q.deQueue()); 
	    System.out.println(q.deQueue());
	    
	    System.out.println("here");
		
	}
	
	
}
