package work;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class rr {
	public static int n,x=0;
	public static int t[];
	public static int data[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		while(n-->0)
		{
			String s=sc.next();
			Stack<Character> st=new Stack<Character>();
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='['||s.charAt(i)=='(')
					st.add(s.charAt(i));
				else
				{
					if(s.charAt(i)==']'&&st.peek()=='[')
						st.pop();
					else
					{
						if(s.charAt(i)==')'&&st.peek()=='(')
							st.pop();
					}
				}
			}
			if(st.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
		}
	}
}

