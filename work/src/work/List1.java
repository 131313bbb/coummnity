package work;



public class List1<E>{
	
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
	public List1() {
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
