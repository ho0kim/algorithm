import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nm = sc.nextLine().split(" ");
		
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		int[][] maze = new int[N][M];
		
		for(int i = 0; i<N ;i++) {
			String input = sc.nextLine();
			for(int k = 0; k<M ; k++) {
				maze[i][k] = (int)input.charAt(k) - '0';
			}
		}
		
		System.out.println(solution(N, M, maze));
		
	}
	
	public static int solution(int N, int M ,int[][] maze) {
		boolean[][] visit = new boolean[N][M];
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<Spot> q = new LinkedList<>();
		
		q.offer(new Spot(0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Spot startPoint = q.poll();
			int x = startPoint.x;
			int y = startPoint.y;
			
			for(int i = 0; i<4;i++) {
				int dx = x + dir[i][0];
				int dy = y + dir[i][1];
				if(dx>=0 && dx<N && dy>=0 && dy<M) {
					if(!visit[dx][dy] && maze[dx][dy] != 0) {
						visit[dx][dy] = true;
						maze[dx][dy] = maze[x][y] + 1;
						q.offer(new Spot(dx, dy));
					}
				}
			}
		}
		int answer = maze[N-1][M-1];
		return answer;
	}

}

class Spot{
	int x;
	int y;
	Spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}