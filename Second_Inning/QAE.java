package Second_Inning;

import java.util.Stack;

public class QAE {

	public static void main(String[] args) {

		
		// x to the power y 
		/*
		int x =2, y=9;long result=1;
		while(y>0) {
			result*=x;
			y--;
		}
		System.out.println(result);
	
	*/ 	
		// reverse String with split
		String str = "Hi this is chandan";
		reverseWords(str);
		System.out.println();
//		String [] strArray = str.split("\\s");
//		
//		for(int i =strArray.length-1; i>=0;i--) {
//			System.out.print (strArray[i]+" ");
//		}		
		// without split // chandan is this Hi
	    
		StringBuilder revStr = new StringBuilder("");
	    int end = str.length(); // substring takes the end index -1
	    for (int i = str.length()-1; i >= 0; i--) {     
	        if (str.charAt(i) == ' ' || i == 0) {
	            if (i != 0) {
	                revStr.append(str.substring(i+1, end));
	                revStr.append(" ");
	            }
	            else {
	                revStr.append(str.substring(i,end));
	            }
	            end = i;
	        }
	    }
	    System.out.println(revStr); //chandan is this Hi
		
	 // reverses individual words of a string 
	} 
	    static void reverseWords(String str) 
	    { 

	        Stack<Character> st=new Stack<Character>(); 
	       
	        // Traverse given string and push all 
	        // characters to stack until we see a space. 
	        for (int i = 0; i < str.length(); ++i) { 
	            if (str.charAt(i) != ' ') 
	                st.push(str.charAt(i)); 
	       
	            // When we see a space, we print 
	            // contents of stack. 
	            else { 
	                while (!st.isEmpty()) { 
	                    System.out.print(st.pop()); 
	                      
	                } 
	                System.out.print(" "); 
	            } 
	        } 
	       
	        // Since there may not be space after 
	        // last word. 
	        while (!st.isEmpty()) { 
	            System.out.print(st.pop()); 
	              
	     }  
	}
	
}
