package rodCutting;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] price=new int[N+1];
		for(int i =1;i<N+1;i++)
			price[i]=sc.nextInt();
		
		int[] data = new int[N+1];
		
		data = solution(N,price);
		System.out.println(data[N]);
			
	}
	
	public static int[] solution(int N,int[] price) {
		int[] maxPrice=new int[N+1];
		
		//System.out.println(Arrays.toString(price));
		
		
		for(int i=1;i<=N;i++) {
			int max=0;
			for(int j=1;j<=i;j++) {
				//System.out.println();
				//System.out.println(price[j]+" "+ maxPrice[i-j]);
				max=Math.max(max, price[j]+maxPrice[i-j]);
			}
			maxPrice[i]=max;
		}
		
		System.out.println(Arrays.toString(maxPrice));
		return maxPrice;
	}
}
