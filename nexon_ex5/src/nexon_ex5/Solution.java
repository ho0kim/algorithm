package nexon_ex5;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m= sc.nextInt();
		int start;
		int end;
		int data;
		
		int[] list=new int[n+1];
		
		for(int i =1; i<n+1;i++) {
			start=sc.nextInt();
			end=sc.nextInt();
			data=sc.nextInt();
			for(int k=start;k<=end;k++) {
				if(list[k]!=0)
					list[k]=data;
			}
		}
		
		System.out.println(n);
	}
}
