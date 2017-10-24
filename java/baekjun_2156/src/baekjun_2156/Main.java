package baekjun_2156;

import java.util.Scanner;

public class Main {
	static int[] glass;
	static int[] maxAmt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n=sc.nextInt();
			
			glass=new int[n+1];
			maxAmt=new int[n+1];
			
			for(int i =1;i<=n;i++)
				glass[i]=sc.nextInt();
			
			maxAmt[1]=glass[1];
			if(n>1)
			maxAmt[2]=glass[2]+glass[1];
			
			for(int i=3;i<=n;i++) {
				maxAmt[i]=max(maxAmt[i-1],maxAmt[i-2]+glass[i],maxAmt[i-3]+glass[i]+glass[i-1]);
			}
			
			System.out.println(maxAmt[n]);
	}
	
	static public int max(int i,int j,int k) {
		int max=0;
		if(i>=j&&i>=k)
			max=i;
		if(j>=i&&j>=k)
			max=j;
		if(k>=i&&k>=j)
			max=k;
		return max;
		
	}

}
