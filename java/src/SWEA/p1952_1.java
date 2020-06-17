package SWEA;
import java.util.*;

public class p1952_1 {
	public static void printArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int[]fee = new int[4];
			for(int i=0; i<4; i++)
				fee[i] = sc.nextInt();
			int[]plan = new int[13];
			for(int i=1; i<=12; i++)
				plan[i] = sc.nextInt();
			
			int[][] dp = new int[13][4];
			for(int i=1; i<=12; i++) {
				if(i<=3) {
					dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + fee[0]*plan[i];
					dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + fee[1];
					dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + fee[2];
				}
				else {
					dp[i][0] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]),dp[i-3][2]) + fee[0]*plan[i];
					dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]),dp[i-3][2]) + fee[1];
					dp[i][2] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]),dp[i-3][2]) + fee[2];
				}
				dp[i][3] = fee[3];
			}
			printArr(dp);
			int result = 1000000;
			for(int i=0; i<4; i++) {
				if(result > dp[12][i])
					result = dp[12][i];
			}
			result = Math.min(Math.min(dp[10][2], dp[11][2]), result);
			System.out.println("#"+t+" "+result);
		}
	}
}
