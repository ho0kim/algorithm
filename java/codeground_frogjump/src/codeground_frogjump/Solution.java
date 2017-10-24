package codeground_frogjump;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int ans=0;
			
			int stoneNum=sc.nextInt();
			
			String[] stonedata=new String[stoneNum];
			int[] stones=new int[stoneNum];
			
			String data=sc1.nextLine();
			stonedata=data.split(" ");
			
			int K=sc.nextInt();
			
			//typecasting sting to int
			for(int i =0;i<stonedata.length;i++) {
				stones[i]=Integer.parseInt(stonedata[i]);
			}

			
			//check case dont reach endpoint
			for(int i=1;i<stones.length;i++) {
				if(stones[i]-stones[i-1]>K) {
					ans=-1;
				}
			}
			
			int startPoint=0;
			if(ans!=-1) {
				for(int i=0;i<stones.length;i++) {
					if(K<stones[i]-stones[startPoint]) {
						ans+=1;
						startPoint=i-1;
						
					}
				}
				ans+=2;
			}
			
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(ans);
		}
	}
}