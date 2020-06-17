package baekjoon;
import java.util.*;

public class p14889 {
	static int min;
	
	static void solve(int[][] map, int[]A, int[]B) {
		int a = 0;
		int b = 0;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				a += map[A[i]][A[j]];
				b += map[B[i]][B[j]];
			}
		}
		
		int result = (a>b?a-b:b-a);
		if(result < min)
			min = result;
	}
	
	static void dfs(int[][]map, int[]A,int idx, int cnt) {
		if(cnt==A.length) {
			int[] B = new int[A.length];
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<map.length; i++) {
				if(n1<A.length) {
					if(i==A[n1])
						n1++;
					else {
						B[n2]= i;
						n2++;
					}
				}
				else {
					B[n2] =i;
					n2++;
				}
			}
			solve(map,A,B);
		}
		else {
			for(int i=idx+1; i<map.length; i++) {
				A[cnt] = i;
				dfs(map,A,i,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		min = 99999;
		int[] A = new int[N/2];
		for(int i=0; i<N; i++) {
			A[0] = i;
			dfs(map,A,i,1);
		}
		System.out.println(min);
	}
}
