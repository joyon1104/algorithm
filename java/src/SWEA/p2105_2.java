package SWEA;
import java.util.*;

/*
 * [디저트 카페]
 * - 성공
 */

public class p2105_2 {
	
	static int N;
	static int max;
	static int start_i,start_j;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max = -1;
			N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int[] dessert = new int[101]; // 0: 지나간적 없음, 1:지나감, -1:시작점
					dessert[map[i][j]] = -1; 
					// 시작점 전역변수 초기화
					start_i = i;
					start_j = j; 
					if(i+1<N && j+1<N && dessert[map[i+1][j+1]]==0) {	//**시작점과 다음점이 디저트 종류가 같은 경우 제외
						dessert[map[i+1][j+1]] = 1;
						solve(map,dessert,i+1,j+1,0,1,0);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	// 같은 디저트인지 or 접근 가능한 좌표인지 판단하는 함수
	static boolean isPossible(int[][]map, int[]dessert, int i, int j) {
		boolean res = true;
		if(i<0 || j<0 || i>=N || j>=N)
			res = false;
		else if(i==start_i && j==start_j)
			res = true;
		else if(dessert[map[i][j]]!=0)
			res = false;
		return res;
	}
	
	static void solve(int[][] map, int[] dessert, int i, int j, int d, int a, int b) {
		int[][] move = {{1,1},{1,-1},{-1,-1},{-1,1}};
		int next_i = 0;
		int next_j = 0;
		if(d==0) { //오른쪽아래
			next_i = i + move[d][0];
			next_j = j + move[d][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d,a+1,b);
				dessert[map[next_i][next_j]] = 0;
			}
			next_i = i + move[d+1][0];
			next_j = j + move[d+1][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d+1,a,b+1);
				dessert[map[next_i][next_j]] = 0;
			}
		}
		else if(d==1) { //왼쪽아래
			next_i = i + move[d][0];
			next_j = j + move[d][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d,a,b+1);
				dessert[map[next_i][next_j]] = 0;
			}
			next_i = i + move[d+1][0];
			next_j = j + move[d+1][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d+1,a-1,b);
				dessert[map[next_i][next_j]] = 0;
			}
		}
		else if(d==2) {  //왼쪽위
			if(a==0) {
				solve(map,dessert,i,j,d+1,a,b);
			}
			else {
				next_i = i + move[d][0];
				next_j = j + move[d][1];
				if(isPossible(map,dessert,next_i,next_j)) {
					dessert[map[next_i][next_j]] = 1;
					solve(map,dessert,next_i,next_j,d,a-1,b);
					dessert[map[next_i][next_j]] = 0;
				}
			}
		}
		else if(d==3) { //오른쪽 위 
			if(b==0) {
				if(i==start_i && j==start_j) {
					int result = 0;
					for(int k=1; k<=100; k++) { //0이 아닌 것 -> 지나간 디저트
						if(dessert[k] !=0)
							result++;
					}
					if(result > max) {
						max = result;
					}
				}
			}
			else {
				next_i = i + move[d][0];
				next_j = j + move[d][1];
				if(isPossible(map,dessert,next_i,next_j)) {
					if(dessert[map[next_i][next_j]] ==0)
						dessert[map[next_i][next_j]] = 1;
					solve(map,dessert,next_i,next_j,d,a,b-1);
					if(dessert[map[next_i][next_j]] ==1)
						dessert[map[next_i][next_j]] = 0;
				}
			}
		}
	}

}
