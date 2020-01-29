package work;

import java.util.Scanner;

public class ehhhf {
	public static class Node{
		private int weight;
		private int Lchild;
		private int Rchild;
		private int pareant;
		private String data;
		
		public Node(String data) {
			
			this.data=data;
		}
		public Node(int weight) {
			this();
			this.weight=weight;
		}
	public Node(){
		this.data="";
		this.weight=-1;
		this.Lchild=-1;
		this.Rchild=-1;
		this.pareant=-1;
		
		
	}
		
		
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	Node[] vexs=new Node[2*n-1];
	for(int i=0;i<2*n-1;i++) {
		
		vexs[i]=new Node();
	}
	for(int i=0;i<n;i++) {
		int item=sc.nextInt();
		vexs[i].weight=item;
		
	}
	String str1=sc.nextLine();
	String str=sc.next();
	for(int i=0;i<str.length();i++) {
		vexs[i].data=str.charAt(i)+"";
	}
	create(vexs,n);
	print(vexs,n);
	
	
}
public static void create(Node[] vexs,int n) {
	int x1,x2,v1,v2;
	for(int i=0;i<n-1;i++) {
	 x1=x2=0;
	v1=v2=Integer.MAX_VALUE;
	for(int j=0;j<n+i;j++) {
		if(vexs[j].weight<v1&&vexs[j].pareant==-1) {
			x2=x1;
			x1=j;
			v2=v1;
			v1=vexs[j].weight;
			
		}else if(vexs[j].weight<v2
				&&vexs[j].pareant==-1) {
			x2=j;
			v2=vexs[j].weight;
		}
		
		
		
	}
		
 vexs[n+i].weight=v1+v2;
 vexs[n+i].Lchild=x1;
 vexs[n+i].Rchild=x2;
 vexs[x1].pareant=n+i;
 vexs[x2].pareant=n+i;

		
		
		
	}
	
	
	
	
}
public static  void print(Node[] vexs,int n) {
	for(int i=0;i<n;i++) {
		System.out.print(vexs[i].data+":");
		Stack stack=new Stack();
		int parent=vexs[i].pareant;
		int child=i;
		while(parent!=-1) {
		if(parent!=-1) {
			if(vexs[parent].Lchild==child) {
				stack.enter("l");
			}
			if(vexs[parent].Rchild==child) {
				stack.enter("r");
			}
			
		}
		 child=parent;
		parent=vexs[child].pareant;
		
	}
		int size=stack.getSize();
		StringBuilder sb=new StringBuilder();
		for(int j=0;j<size;j++) {
			sb.append(stack.out()+" ");
		}
		System.out.println(sb.substring(0,sb.length()-1));
		
	}
	
	
	
	
}

}
class Stack{
	private Node1 top;
	private int size;
 public  class Node1{
	 
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext(Node1 next) {
		this.next = next;
	}
	private String data;
	private Node1 next;
	public Node1(String data,Node1 next) {
		this.data=data;
		this.next=next;
	}
	public Node1(String data) {
		
		this(data,null);
	}
	
	
}
	

	public Stack() {
		top=null;
		size=0;
		
	}
	public boolean enter(String item) {
		Node1 node=new Node1(item);
		if(isEmpty()) {
			top=node;
			size++;
			return true;
		
		}else {
			node.next=top;
			top=node;
			size++;
			return true;
		}
	}
	public boolean isEmpty() {
		return size==0;
	}
	public String out() {
		String item=top.data;
		top=top.next;
		return item;
	}
	public String pop() {
		return top.data;
	}
	public int getSize() {
		return size;
	}
	
	
	
}

