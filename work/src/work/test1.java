package work;

public class test1 {
	public static void main(String[] args) {
		List1<Integer>list=new List1<Integer>();
		list.enter(1);
		list.enter(2);
		list.enter(45);
		int size=list.size();
		for(int i=0;i<size;i++) {
			System.out.print(list.out()+" ");
		}
		System.out.println(list.isEmpty());
	}

}
