package beakjun_1463;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int temp=0;
		int num  = sc.nextInt();
		
		int[] cnt = new int[num+1];
		
		cnt[0]=0;
		if(num>0)
			cnt[1]=0;
		if(num>1)
			cnt[2]=1;
		if(num>2)
			cnt[3]=1;
		
		for(int i =4; i<=num;i++) {
			cnt[i]=cnt[i-1]+1;
			if((i%3)==0) {
				temp=cnt[i/3]+1;
				if(temp<cnt[i])
					cnt[i]=temp;
				
			}
			if((i%2)==0) {
				temp=cnt[i/2]+1;
				if(temp<cnt[i])
					cnt[i]=temp;
			}
		}
		
		System.out.println(cnt[num]);
	}

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i<=j)
			return i;
		else
			return j;
	}

}
