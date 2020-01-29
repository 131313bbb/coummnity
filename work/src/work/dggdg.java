package work;

import java.util.Scanner;

public class dggdg {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		int item=sc.nextInt();
		
		
		
		int dex=zheSort(data,item);
		if(dex==-1) {
			System.out.println("No");
		}else {
			System.out.println(dex+1);
		}
		
	}
	public static int zheSort(int[] data,int item) {
		int min=0;
		int mid=0;
		int  max=data.length-1;
		StringBuilder str=new StringBuilder();
		while(min<=max) {
			mid=(min+max)/2;
			if(data[mid]>item) {
				max=mid-1;
				str.append(data[mid]+" ");
				
			}else if(data[mid]<item) {
				min=mid+1;
				
				str.append(data[mid]+" ");
			}else if(data[mid]==item) {
				str.append(data[mid]);
				System.out.println(str);
				return mid;
				
			}
			
		}
		return -1;
	}
public static void xrsort(int[] data) {
	int path=data.length/3;
	for(int d=path;d>0;d--) {
	for(int i=d;i>0;i--) {
		int temp=data[i];
		int j=0;
		for( j=i-d;j>0&&temp<data[j];i=i-d) {
			data[j+d]=data[j];
		}
		data[j+d]=temp;
		
		
		
		
		
	}
	
	
	
	
}
}
}
