package ee;

import java.util.Scanner;

public class hfhfh {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		Xrsort(data);
		int item=sc.nextInt();
	int temp=zhesort(data,item);
		if(temp==-1) {
			System.out.println("no");
		}else {
			System.out.println(temp);
			
		}
		
		
	}
	public static void Xrsort(int[] data) {
		int path=data.length/3;
		for(int d=path;d>0;d--) {
			for(int i=d;i<data.length;i++) {
				int temp=data[i];
				int  j=0;
				if(temp<data[i-d]) {
					
					for(j=i-d;j>=0&&temp<data[j];j=j-d) {
						data[j+d]=data[j];
					}
					data[j+d]=temp;
					
					
					
				}
				
				
				
				
			}
			
			
			
			
		}
		
		
		
	}
	public static int zhesort(int[] data,int item) {
		int min=0;
	int	mid=0;
		int max=data.length-1;
		StringBuilder sb=new StringBuilder();
		while(min<=max) {
			mid=(min+max)/2;
			if(item>data[mid]) {
				min=mid+1;
				sb.append(data[mid]+" ");
				
			}else if(item<data[mid]) {
				
				max=mid-1;
				sb.append(data[mid]+" ");
				
			}else if(item==data[mid]) {
				sb.append(data[mid]);
				System.out.println(sb);
				return mid;
			}
			
			
			
			
		}
		
		return -1;
	}

}
