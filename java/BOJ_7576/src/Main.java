import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int RIPE = 1, UNRIPE = 0, EMPTY = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] boxData = sc.nextLine().split(" ");
		int M = Integer.parseInt(boxData[0]);
		int N = Integer.parseInt(boxData[1]);
		
		int[][] box = new int[N][M];
		
		for(int i =0; i<N ;i++) {
			String[] input = sc.nextLine().split(" ");
						
			for(int n = 0; n<input.length; n++) {
				box[i][n] = Integer.parseInt(input[n]);
			}
		}
		
		System.out.println(solution(M, N, box));
	}
	
	public static int solution(int M, int N, int[][] box) {
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		
		boolean[][] visit = new boolean[N][M];
		Queue<Spot> q = new LinkedList<>();
		
		for(int i = 0;i<N ;i++) {
			for(int k=0; k<M; k++) {
				if(box[i][k] == 1) {
					visit[i][k] = true;
					q.offer(new Spot(i,k));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Spot startPoint = q.poll();
			int x = startPoint.x;
			int y = startPoint.y;
			for(int i=0;i<4;i++) {
				int dx = x+dir[i][0];
				int dy = y+dir[i][1];
				
				if(dx >= 0 && dx < N && dy>=0 && dy<M) {
					if(box[dx][dy] == UNRIPE) {
						visit[dx][dy] = true;
						box[dx][dy] = box[x][y] + 1;
						q.offer(new Spot(dx,dy));
					}
				}
			}
		}
		
		int answer = -1;
		for(int i=0; i<N; i++) {
			for(int k=0;k<M;k++) {
				if(box[i][k] > answer) {
					answer = box[i][k];
				}
				
				if(box[i][k] == 0) {
					return -1;
				}
			}
		}
		
		return answer-1;
	}
}

class Spot{
	int x;
	int y;
	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}