package work;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
	int[] data1=heapsort(data);
	StringBuilder sb=new StringBuilder();
	
	for(int i=0;i<data1.length;i++) {
		sb.append(data1[i]+" ");
		
		
	}
	System.out.println(sb);
		
		
	}
public static int [] heapsort(int[] data) {
	int len=data.length-1;
	int temp=0;
	for(int i=len/2;i>=0;i--) {
		
		headAdjust(data,i,len);
	}
			StringBuilder sb=new StringBuilder();
			for(int k=0;k<data.length;k++) {
				sb.append(data[k]+" ");
			}
			System.out.println(sb.substring(0,sb.length()-1));
			
		
		
		
		
	
	while(len>=0) {
		swap(data,0,len--);
			headAdjust(data,0,len);
		}
	return data;
		
		
	}
	
	
	
	
	
	


public static int[] headAdjust(int[] data,int i,int len) {
	int left,right,j;
	while((left=2*i+1)<=len) {
		right=left+1;
		j=left;
		if(j<len&&data[left]<data[right])
			j++;
		if(data[i]<data[j])
			swap(data,i,j);
		else
			break;
		i=j;
		
		
		
	}
	return data;
	
	
	
	
}
public static int[] swap(int[] data,int i,int len )
{
int temp=data[i];
data[i]=data[len];
data[len]=temp;

return data;
}
}
