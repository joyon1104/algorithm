package baekjoon;
import java.util.*;

public class p14500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				map[i][j] = sc.nextInt();
		}
		
		int result = 0;
		
		//けけけけ
		for(int i=0; i<N; i++) {
			for(int j=0; j<=M-4; j++) {
				int tmp = 0;
				for(int k=0; k<4; k++)
					tmp += map[i][j+k];
				if(tmp > result)
					result = tmp;
			}
		}
		
		//けけけけ(室稽)
		for(int i=0; i<M; i++) {
			for(int j=0; j<=N-4; j++) {
				int tmp = 0;
				for(int k=0; k<4; k++)
					tmp += map[j+k][i];
				if(tmp > result)
					result = tmp;
			}
		}
		
		//けけ
		//けけ
		for(int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-2; j++) {
				int tmp = map[i][j] + map[i][j+1];
				int max = map[i+1][j] + map[i+1][j+1];
				if(j-1>=0)
					max = Math.max(max, map[i+1][j-1] + map[i+1][j]);
				if(j+2<M)
					max = Math.max(max, map[i+1][j+1] + map[i+1][j+2]);
				tmp += max;
				if(tmp > result)
					result = tmp;
			}
		}
		
		//け
		//けけ
		// け
		for(int i=0; i<=N-3; i++) {
			for(int j=0; j<M; j++) {
				int tmp = map[i][j] + map[i+1][j];
				int max = 0;
				if(j-1 >=0)
					max = map[i+1][j-1] + map[i+2][j-1];
				if(j+1 < M)
					max = Math.max(max, map[i+1][j+1]+map[i+2][j+1]);
				tmp += max;
				if(tmp > result)
					result = tmp;
			}
		}
		
		//け
		//けけけ
		for(int i=0; i<N; i++) {
			for(int j=0; j<=M-3; j++) {
				int tmp = map[i][j] + map[i][j+1] + map[i][j+2];
				int max = 0;
				if(i+1 < N)
					max = Math.max(Math.max(map[i+1][j], map[i+1][j+1]),map[i+1][j+2]);
				if(i-1 >= 0)
					max = Math.max(max,Math.max(Math.max(map[i-1][j], map[i-1][j+1]),map[i-1][j+2]));
				tmp += max;
				if(tmp > result)
					result = tmp;
			}
		}
		
		
		//け
		//けけけ (室稽)
		for(int i=0; i<M; i++) {
			for(int j=0; j<=N-3; j++) {
				int tmp = map[j][i] + map[j+1][i] + map[j+2][i];
				int max = 0;
				if(i+1 < M)
					max = Math.max(Math.max(map[j][i+1], map[j+1][i+1]),map[j+2][i+1]);
				if(i-1 >= 0)
					max = Math.max(max, Math.max(Math.max(map[j][i-1], map[j+1][i-1]),map[j+2][i-1]));
				tmp += max;
				if(tmp > result)
					result = tmp;
			}
		}
		
		System.out.println(result);
		
	}
}
