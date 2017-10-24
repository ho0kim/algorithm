package beakjun_11052;

import java.util.Scanner;

public class Main {
		static int[] price;
		static int[] maxPrice;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		price = new int[num+1];
		maxPrice=new int[num+1];
		for(int i=1;i<num+1;i++)
			price[i]=sc.nextInt();
		
		for(int i = 1;i<=num;i++) {
			maxPrice[i]=0;
			for(int j=1;j<=i;j++) {
				maxPrice[i]=max(maxPrice[i],maxPrice[i-j]+price[j]);
			}
		}
		
		System.out.println(maxPrice[num]);
	}
	static public int max(int i, int j) {
		if(i>=j)
			return i;
		else
			return j;
	}

}
