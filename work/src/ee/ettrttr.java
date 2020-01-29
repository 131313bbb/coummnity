package ee;

import java.util.Scanner;

public class ettrttr {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		int[] temp=TreeSort(data);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<temp.length;i++) {
			sb.append(data[i]+" ");
		}
		System.out.println(sb.substring(0,sb.length()-1));
		
	}
	public static int[] TreeSort(int[] data) {
		int length=data.length-1;
		for(int i=length/2;i>=0;i--) {
			adjustTree(data,i,length);
		}
		StringBuilder str=new StringBuilder();
		for(int i=0;i<data.length;i++) {
			str.append(data[i]+" ");
		}
		System.out.println(str.substring(0,str.length()-1));
		
		while(length>=0) {
			swap(data,0,length--);
			adjustTree(data,0,length);
		}
		return data;
		
		
		
		
		
	}
public static void swap(int[] data,int i,int j) {
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
}
public static int[] adjustTree(int[] data,int index,int len) {
	int right,left,temp;
	while((left=2*index+1)<=len) {
		right=left+1;
		temp=left;
		if(temp<len&&data[left]<data[right]) {
			temp++;
		}
		if(data[temp]>data[index]) {
			swap(data,index,temp);
		}else {
			break;
		}
		index=temp;
		
		
		
		
	}
	
	
	
	return data;
	
}
}
