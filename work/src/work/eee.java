package work;

import java.util.Scanner;

import ds.tree.LinkBiTree;
import ds.tree.LinkNode;

public class eee {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	 LinkBiTree<Character> tree =new LinkBiTree<Character>();
     LinkBiTree.create(tree);
    for(int i=0;i<4;i++) {
    	int n=sc.nextInt();
    	if(n==1) {
    		PreOrder(tree.root);
    		System.out.println();
    	}else if(n==2) {
    		InOrder( tree.root);
    		System.out.println();
    		
    	}else if(n==3) {
    		PostOrder(tree.root);
    		System.out.println();
    	}else {
    		levelOrder(tree.root);
    		System.out.println();
    		
    	}
    }
     
}
static  void PreOrder(LinkNode<Character> tree){ //先序遍历
    if(tree==null) {
    	return ;
    	
    }
    if(tree!=null) {
    	System.out.print(tree.data+" ");
    	
    	
    }
    if(tree.lchild!=null) {
    	PreOrder(tree.lchild);
    }
    if(tree.rchild!=null) {
    	PreOrder(tree.rchild);
    }
   
    
}

static  void InOrder(LinkNode<Character> tree){ //中序遍历
	if(tree==null) {
    	return ;
    	
    }
	 if(tree.lchild!=null) {
	    	InOrder(tree.lchild);
	    }
	 if(tree!=null) {
	    	System.out.print(tree.data+" ");
	    	
	    	
	    }
	   
	    if(tree.rchild!=null) {
	    InOrder(tree.rchild);
	    }
}

static  void PostOrder(LinkNode<Character> tree){ //后序遍历
	if(tree==null) {
    	return ;
    	
    }
	 
	    if(tree.lchild!=null) {
	    	PostOrder(tree.lchild);
	    }
	    if(tree.rchild!=null) {
	    	PostOrder(tree.rchild);
	    }
	    if(tree!=null) {
	    	System.out.print(tree.data+" ");
	    	
	    	
	    }
}

static void levelOrder(LinkNode<Character> tree){//层次遍历
	if(tree==null) {
		return ;
	}
	if(tree!=null) {
	List<LinkNode<Character>> list=new List<LinkNode<Character>>();
	list.enter(tree);
	while(!list.isEmpty()) {
		LinkNode<Character> dd=list.out();
		System.out.print(dd.data+" ");
		if(dd.lchild!=null) {
			list.enter(dd.lchild);
			
		}
		if(dd.rchild!=null) {
			list.enter(dd.rchild);
		}
	}
	
 
}
}

}
class List<E>{
	
	private Node<E> rear;
	private Node<E> front;
	private int size;
	static class  Node<E>{
		private E data;
private Node<E> next;
public Node(E data, Node<E>next) {
	this.data=data;
	this.next=next;
}
public Node(E data) {
	
	this(data,null);
}
public Node(Node<E>next) {
	this(null,next);
}
public Node() {
	this(null,null);
}
public E getData() {
	return data;
}
public void setData(E data) {
	this.data = data;
}
public Node<E> getNext() {
	return next;
}
public void setNext(Node<E> next) {
	this.next = next;
}
		
		
	}
	public List() {
		rear=front=null;
		size=0;
	}
	public boolean  isEmpty() {
		return size==0;
		
	}
	public boolean enter(E item) {
		Node<E> node=new Node<E>(item);
		if(isEmpty()) {
			rear=front=node;
			size++;
			return true;
		}
		else {
			rear.next=node;
			rear=node;
			size++;
			return true;
			
		}
		
	}
	public E out() {
		if(isEmpty()) {
			return null;
		}
		else {
			E item1=front.data;
			front=front.next;
			if(front==null) {
				
				rear=null;
			}
			size--;
			return item1;
			
			
			
		}
		
		
	}
	public int size() {
		return size;
	}
	
	
	
}
