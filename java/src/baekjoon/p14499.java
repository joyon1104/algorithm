package baekjoon;
import java.util.*;

public class p14499 {
	
	public static void turn(int[]dice, int d) {
		int[] tmp = new int[6];
		for(int i=0; i<6; i++)
			tmp[i] = dice[i];
		
		if(d==1) {	//µ¿ 
			dice[0] = tmp[2];
			dice[2] = tmp[5];
			dice[4] = tmp[0];
			dice[5] = tmp[4];
		}
		else if(d==2) {	//¼­
			dice[0] = tmp[4];
			dice[2] = tmp[0];
			dice[4] = tmp[5];
			dice[5] = tmp[2];
			
		}
		else if(d==3) {	//ºÏ
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[3] = tmp[0];
			dice[5] = tmp[3];
		}
		else if(d==4) {	//³²
			dice[0] = tmp[3];
			dice[1] = tmp[0];
			dice[3] = tmp[5];
			dice[5] = tmp[1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[N][M];
		int[] dice = new int[6];
		int[][] moved = {{0,1},{0,-1},{-1,0},{1,0}};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int k=0; k<K; k++) {
			int d = sc.nextInt();
			int next_x = x + moved[d-1][0];
			int next_y = y + moved[d-1][1];
			if(next_x<0 || next_y<0 || next_x>=N || next_y>=M)
				continue;
			x = next_x; y = next_y;
			turn(dice,d);
			if(map[x][y] == 0) {
				map[x][y] = dice[5];
			}
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
	}
}
