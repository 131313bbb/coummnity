package ee;

import java.util.Scanner;

public class jjfjf {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		Xrsort(data);
		int item=sc.nextInt();
		int temp=zheSort(data,item);
		if(temp==-1) {
			System.out.println("No");
		}else {
			
			System.out.println(temp+1);
		}
		
		
	}
	public static void Xrsort(int[] data) {
		int path=data.length/3;
		for(int d=path;d>=0;d--) {
			for(int i=d;i<data.length;i++) {
				int temp=data[i];
				int j;
				for(j=i-d;j>=0&&temp<data[j];j=j-d) {
					data[j+d]=data[j];
					
					
					
				}
				data[j+d]=temp;
				
				
				
				
			}
			
			
			
			
		}
	}
	public static int zheSort(int[] data,int item) {
		int min=0;
		int max=data.length-1;
		int mid=0;
		
		StringBuilder str=new StringBuilder();
		while(min<=max) {
			mid=(min+max)/2;
			if(item>data[mid]) {
				min=mid+1;
				str.append(data[mid]+" ");
			}else if(item<data[mid]) {
				max=mid-1;
				str.append(data[mid]+" ");
			}else if(data[mid]==item) {
				str.append(data[mid]);
				System.out.println(str);
				return mid;
			}
			
			
			
			
			
		}
		
		return -1;
		
		
		
		
	}

}
