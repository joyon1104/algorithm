package SWEA;
import java.util.*;

public class p2117_1 {

	static int result;
	
	public static void solve(int[][] map, int i, int j, int k, int M) {
		int cnt = 0;
		for(int p=i-(k-1); p<=i+(k-1); p++) {
			for(int q=j-(k-1); q<=j+(k-1); q++) {
				if(Math.abs(p-i)+Math.abs(q-j) < k && map[p][q] == 1)
					cnt++;
			}
		}
		int cost = cnt*M - (k*k + (k-1)*(k-1));
		if(cost >= 0 && result < cnt) {
			result = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[100][100];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i+22][j+22] = sc.nextInt();
				}
			}
			
			for(int k=1; k<=22; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						solve(map, i+22, j+22, k, M);
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}
}
