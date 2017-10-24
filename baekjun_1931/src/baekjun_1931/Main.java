package baekjun_1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] start;
	static int[] end;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int max=0;
		
		int n=sc.nextInt();
		start = new int[n];
		end=new int[n];
		for(int i =0;i<n;i++) {
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
		}
		
		//quick sort
		sort(start,end,0,start.length-1);
	
		System.out.println(Arrays.toString(end));
		System.out.println(Arrays.toString(start));
		max=0;
		int cnt=0;
		for(int i=0;i<end.length;i++) {
			if(start[i]>=max) {
				cnt++;
				max=end[i];
				//System.out.println(start[i]+" "+end[i]);
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void sort(int[] start,int[] end, int l, int r){
        int left = l;
        int right = r;
        int pivot = end[(l+r)/2];
        
        do{
            while(end[left] < pivot) left++;
            while(end[right] > pivot) right--;
            if(left <= right){    
                int temp = end[left];
                end[left] = end[right];
                end[right] = temp;
                temp = start[left];
                start[left] = start[right];
                start[right] = temp;
                
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(start,end, l, right);
        if(r > left) sort(start,end, left, r);
    }

}
