package baekjoon;

import java.util.Scanner;

/*
 * 190903
 * 
 * 백준 삼성 A형 기출 문제
 * 
 * 17406번 
 * [배열 돌리기 4]
 * 
 * -> 성공
 * 
 */

public class p17406 {

	static int N,M,K;
	static int result;
	
	static Scanner sc = new Scanner(System.in);
	
	//한칸 씩 돌면서 위치 옮기는 함수 
	static int[][] cycle(int i, int[][] board, int[][] compute){
		int[][] temp = deepcopy(N+1, M+1, board);
		int s = compute[i][2];
		while(s > 0) {
			int si = compute[i][0] - s;
			int sj = compute[i][1] - s;
			int ei = compute[i][0] + s;
			int ej = compute[i][1] + s;
			
			int ti = si;
			int tj = sj;
			
			temp[ti][tj+1] = board[ti][tj];
			tj++;
			
			while(!(ti == si && tj == sj)) {
				if(ti == si && tj > sj && tj < ej) {
					temp[ti][tj+1] = board[ti][tj];
					tj++;
				}
				else if(ti >= si && ti < ei && tj == ej) {
					temp[ti+1][tj] = board[ti][tj];
					ti++;
				}
				else if(ti == ei && tj <= ej && tj > sj) {
					temp[ti][tj-1] = board[ti][tj];
					tj--;
				}
				else if(ti <= ei && ti > si && tj == sj) {
					temp[ti-1][tj] = board[ti][tj];
					ti--;
				}
			}
			s--;
		}
		return temp;
	}
	
	// 행마다 최소값 계산
	static void compute(int[]output, int[][]board, int[][] compute) {
		
		for(int i = 0; i< output.length; i++) {
			board = cycle(output[i], board, compute);
		}
		
		int min =0;
		
		for(int i=1; i<=N; i++) {
			int tmp =0;
			for(int j=1; j<=M; j++) {
				tmp += board[i][j];
			}
			if(i == 1) 
				min = tmp;
			if (min > tmp) {
				min = tmp;
			}
		}
		
		if(result > min)
			result = min;
	}
	
	//DFS로 모든 연산순서 경우를 구하는 함수 -> output배열에 저장 
	static void DFS(int[] arr, int[] output, int[] visited, int[][]board, int[][] compute, int depth, int K) {
		
		if(depth == K) {
			compute(output, board, compute);
		}
		else {
			for(int i=0; i<K; i++) {
				if(visited[i]==0) {
					visited[i] = 1;
					output[depth] = arr[i];
					DFS(arr,output,visited,board, compute, depth+1, K);
					visited[i] = 0;
					output[depth] = 0;
				}
			}
		}
		
	}
	
	static int[][] deepcopy(int n, int m, int[][]board){
		int[][] temp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = board[i][j];
			}
		}
		return temp;
	}
	
	static void print(int n, int m, int[][]board){
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		result = 10000;
		
		int[][] board = new int[N+1][M+1];
		int[][] compute = new int[K][3];	//각각의 연산의 (r,c,s)저장 
		int[] arr = new int[K];	//연산 번호저장
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int k=0; k<K; k++) {
			compute[k][0] = sc.nextInt();
			compute[k][1] = sc.nextInt();
			compute[k][2] = sc.nextInt();
			arr[k] = k;
		}
		
		int[] output = new int[K];
		int[] visited = new int[K];	//DFS를 위한 visited배열
		
		DFS(arr, output, visited, board, compute, 0, K);
		
		System.out.println(result);
		
	}
}
