import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		String s = "2+3-1";
		
		String s2 = "3*(4+5)-6/(1+2)";
		
		
		System.out.println(convert(s));
		System.out.println(convert(s2));
	}
	
	
	public static int getPriority(char c) {
		if(c=='+' || c=='-')
			return 1;
		else 
			return 2;
	}
	
	public static String convert(String s) {
		
		Stack<Character> st = new Stack<>();
		
		char [] charArray = s.toCharArray();
		String result = "";
		
		for(char c:charArray) {
			
			if(c !='+' &&c !='-' &&c !='/' &&c !='*' &&c !='(' &&c !=')')
				result+=c;
			else if(c=='(')
				st.push(c);
			else if(c==')') {
				while(!st.isEmpty()) {
					char temp= st.pop();
					if(temp!='(')
						result+=temp;
					else{
						break;
					}
				}
			}
			else if(c =='+' || c =='-' || c =='/' || c =='*') {
				if(st.isEmpty()) {
					st.push(c);
				} else {
					while(!st.isEmpty()) {
						char t = st.pop();
						if(t =='(') {
							st.push(t);
							break;
						} else if(t =='+'|| t =='-'|| t =='*'|| t =='/') {
							if(getPriority(c) > getPriority(t)){
								st.push(c);
								break;
							}else {
								result+=t;
							}
						}
								
					}
					st.push(c);
				} 
				
			}		

		}
		while(!st.isEmpty()) {
			result=result+st.pop();
		}
		return result;
	}
		
	
}
