package ee;

import java.util.Scanner;

public class eerrf {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		Ksort(data,0,data.length-1);
		System.out.println();
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		
		
	}
	public static void Ksort(int[] data,int begin,int end) {
		if(begin>=end) {
			return ;
		}
		int i=begin;
		int j=end;
		int mid=data[begin];
		while(i<j) {
			while(data[j]>=mid&&i<j) {
				j--;
			}
			while(data[i]<=mid&&i<j) {
				i++;
			}
			if(i<j) {
				int temp=data[i];
				data[i]=data[j];
				data[j]=temp;
			}
			
			
		}
		data[begin]=data[j];
		data[j]=mid;
		System.out.print(j+" ");
		Ksort(data,begin,j-1);
		Ksort(data,j+1,end);
		
	}

}
