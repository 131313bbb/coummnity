package work;

import java.util.Scanner;
import java.util.Stack;

public class sss1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		while(n-->0) {
			String str=sc.next();
Stack<Character>stack=new Stack<Character>();
for(int i=0;i<str.length();i++) {
	if(str.charAt(i)=='['||str.charAt(i)=='(') {
		stack.add(str.charAt(i));
	}else if(str.charAt(i)==']'&&stack.peek()=='[') {
		stack.pop();
	}else if(str.charAt(i)==')'&&stack.peek()=='(') {
		stack.pop();
	}
	
	
	
}

if(stack.isEmpty()) {
	System.out.println("true");
	
}			else {
	System.out.println("false");
}
			
			
			
			
			
		}
	}

}
