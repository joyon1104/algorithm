package baekjoon;
import java.util.*;

public class p11404 {
	static int INF = 10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();
			arr[x][y] = Math.min(arr[x][y], c);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] >= INF)
					System.out.print(0+" ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
