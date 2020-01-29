package work;

import java.util.Scanner;

public class fff {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
			
			
		}
		int[] temp=TreeSort(data);
		StringBuilder str=new StringBuilder();
		for(int i=0;i<temp.length;i++) {
			str.append(temp[i]+" ");
		}
		System.out.println(str.substring(0,str.length()));
		
		
		
		
	}
	public static int[] adjustTree(int[] data,int index,int length) {
	int left,right,temp;
	while((left=index*2+1)<=length) {
		right=left+1;
		temp=left;
		if(temp<length&&data[left]<data[right]) {
			temp++;
		}
		if(data[temp]>data[index]) {
			swap(data,temp,index);
		}else {
			break;
		}
		index=temp;
		
		
		
	}
	return data;
		
		
	}
	public static int[] TreeSort(int[] data) {
		int len=data.length-1;
		for(int i=len/2;i>=0;i--) {
			adjustTree(data,i,len);
		}
		StringBuilder str=new StringBuilder();
		for(int i=0;i<data.length;i++) {
			str.append(data[i]+" ");
		}
		System.out.println(str.substring(0,str.length()-1));
		while(len>=0) {
			swap(data,0,len--);
			adjustTree(data,0,len);
		}
		return data;
		
		
		
		
	}
	public static void swap(int[] data,int i,int j) {
		int temp=data[i];
		data[i]=data[j];
		data[j]=temp;
	}
}
