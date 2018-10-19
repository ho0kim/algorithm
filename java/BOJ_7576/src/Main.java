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
		sc.close();
		
		//결과 출
		System.out.println(solution(M, N, box));
	}
	
	public static int solution(int M, int N, int[][] box) {
		//bfs를 위한 상,하,좌,우 방향좌표 
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		
		//방문여부 체크 
		boolean[][] visit = new boolean[N][M];
		//익은 사과를 집어넣는 큐 
		Queue<Spot> q = new LinkedList<>();
		
		//최초 익은 사과가 있는 곳을 큐에 저장 및 방문 ture
		for(int i = 0;i<N ;i++) {
			for(int k=0; k<M; k++) {
				if(box[i][k] == 1) {
					visit[i][k] = true;
					q.offer(new Spot(i,k));
				}
			}
		}
		
		//bfs탐
		while(!q.isEmpty()) {
			Spot startPoint = q.poll();
			int x = startPoint.x;
			int y = startPoint.y;
			for(int i=0;i<4;i++) {
				int dx = x+dir[i][0];
				int dy = y+dir[i][1];
				
				//방향이 데이터 범위를 넘기지않는지 체
				if(dx >= 0 && dx < N && dy>=0 && dy<M) {
					/*
					 익은 사과인지 아닌지 체크
					 안익은 사과라면
					 - root데이터에 +1을 해서 저장
					 - 방문 true
					 - 해당위치 enqueue
					 * */
					if(box[dx][dy] == UNRIPE) {
						visit[dx][dy] = true;
						box[dx][dy] = box[x][y] + 1;
						q.offer(new Spot(dx,dy));
					}
				}
			}
		}
		
		int answer = -1;
		//결과값 찾기 
		for(int i=0; i<N; i++) {
			for(int k=0;k<M;k++) {
				//가장 큰 값 찾음 
				if(box[i][k] > answer) {
					answer = box[i][k];
				}
				//하나라도 안익은 사과가 있다면 결과값 -1 리
				if(box[i][k] == UNRIPE) {
					return -1;
				}
			}
		}
		//시작을 1로 시작했으므로 -1 해준 뒤 결과값 리
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