package beakjun;

import java.util.Scanner;

public class Main {
	private static int zeroCnt=0;
	private static int oneCnt=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int testCase=sc.nextInt();
		for(int i=0;i<testCase;i++) {
			fibo(sc.nextInt());
			System.out.println(zeroCnt+" "+oneCnt);
			zeroCnt=0;
			oneCnt=0;
		}
		
	}
	
	public static int fibo(int num) {
		if(num==0) {
			zeroCnt++;
			return 0;
		}else if(num==1) {
			oneCnt++;
			return 1;
		}else {
			return fibo(num-1)+fibo(num-2);
		}
	}


}
