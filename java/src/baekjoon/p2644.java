package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 190814
 * 
 * 백준 2644번
 * -> 분류 : BFS
 * 
 * [ 촌수계산 ]
 * 
 * => 성공
 * 
 */

public class p2644 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[][] board = new int[n+1][n+1];
		int[] visited = new int[n+1];
		
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		
		int m = sc.nextInt();
		
		//그래프 연결관계 -> 이중배열로 표시 
		for(int i=1; i<=m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			board[x][y] = 1;
			board[y][x] = 1;
		}
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		//출발점 p1 
		visited[p1] = 1;
		
		//p1과 연결된 노드들을 큐에 넣음 
		for(int i=1; i<=n; i++) {
			if(board[p1][i] != 0) {
				visited[i] = 1;
				que.offer(i);
			}
		}
		
		//BFS 
		while(!(que.isEmpty())) {
			int tmp = que.poll();
			for(int i=1; i<=n; i++) {
				if(board[tmp][i] != 0 && visited[i] ==0) {	// tmp와 i가 연결되어 있고, i는 방문하지 않은 노드인 경우 
					visited[i] = 1;							// i를 방문 표시 
					board[p1][i] = board[p1][tmp] + board[tmp][i];	// 출발점 p1과 i 사이의 엣지 수 = p1과 큐에서 출력된 노드(tmp) 사이의 엣지 수 + tmp와 i사이의 엣지 수 
					que.offer(i);	// 해야할 것을 모두 수행한 후에 큐에 넣어야 함.
				}
			}
		}
		
		//board[p1][p2]값을 출력 (0이면 연결되지 않은 것) 
		if(board[p1][p2] > 0)
			System.out.println(board[p1][p2]);
		else
			System.out.println(-1);
	}
}
