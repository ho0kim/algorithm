package baekjun_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] graph;
	static boolean[] flag;
	static int n,v,start;
	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		v=sc.nextInt();
		start=sc.nextInt();
		
		graph=new int[1001][1001];
		flag= new boolean[1001];
		
		for(int i=0;i<v;i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			graph[a][b]=1;
			graph[b][a]=1;
		}
		
		dfs(start);
		for(int i =0;i<flag.length;i++) 
			flag[i]=false;
		System.out.println();
		bfs(start);
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q= new LinkedList<>();
		int temp=0;
		q.offer(start);
		flag[start]=true;
		
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			temp=q.poll();
			for(int i =0;i<n+1;i++) {
				if(graph[temp][i]==1&&flag[i]==false) {
					q.offer(i);
					flag[i]=true;
					System.out.print(i+" ");
				}
			}
		}
	}
	
	
	public static void dfs(int start) {
		flag[start]=true;
		System.out.print(start+" ");
		for(int i =0;i<n+1;i++) {
			if(graph[start][i]==1&&flag[i]==false) {
				dfs(i);
			}
		}
	}
}
