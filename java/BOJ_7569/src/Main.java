import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int RIPE = 1, UNRIPE = 0, EMPTY = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] boxData = sc.nextLine().split(" ");
		int[][][] box = {};
		
		int M = Integer.parseInt(boxData[0]);
		int N = Integer.parseInt(boxData[1]);
		int H = Integer.parseInt(boxData[2]);
		
		box = new int[M][N][H];
		
		for(int i=0;i<H;i++) {
			for(int k=0;k<N;k++) {
				String[] input = sc.nextLine().split(" ");
				for(int l=0;l<M;l++) {
					box[l][k][i] = Integer.parseInt(input[l]);
				}
			}
		}
		
		System.out.println(solution(M, N, H, box));
		
	}
	
	public static int solution(int M,int N, int H, int[][][] box) {
		int[] dirX = {0,0,1,-1,0,0};
		int[] dirY = {0,0,0,0,1,-1};
		int[] dirZ = {1,-1,0,0,0,0};
		
		boolean[][][] visit = new boolean[M][N][H];
		Queue<Spot> q = new LinkedList<Spot>();
		
		for(int i=0;i<H;i++) {
			for(int k=0;k<N;k++) {
				for(int l=0;l<M;l++) {
					if(box[l][k][i] == RIPE) {
						visit[l][k][i] = true;
						q.offer(new Spot(l, k, i));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Spot startPoint = q.poll();
			int x = startPoint.x;
			int y = startPoint.y;
			int z = startPoint.z;
			
			for(int i=0;i<6;i++) {
				int dx = x+dirX[i];
				int dy = y+dirY[i];
				int dz = z+dirZ[i];
				
				if(dx>=0 && dx<M && dy>=0 && dy<N && dz>=0 && dz<H) {
					if(box[dx][dy][dz] == UNRIPE) {
						box[dx][dy][dz] = box[x][y][z] + 1;
						visit[dx][dy][dz] = true;
						q.offer(new Spot(dx, dy, dz));
					}
				}
			}
		}
		
		int answer = -1;
		
		for(int i=0;i<H;i++) {
			for(int k=0;k<N;k++) {
				for(int l=0;l<M;l++) {
					if(box[l][k][i] == UNRIPE) {
						return -1;
					}
					if(box[l][k][i] > answer) {
						answer = box[l][k][i];
					}
				}
			}
		}
		return answer -1;
	}

}


class Spot{
	int x;
	int y;
	int z;
	public Spot(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}