package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//190722
//BFS와 DFS 구현 

public class p1260 {
	
	static int[][] map;	// 그래프 표현을 위한  '인접행렬'
	static int N, M;
	static int[] visited;	// 방문한 노드를 기록하기 위한 배열
	
	static Queue<String> que = new LinkedList<String>();	//BFS에 사용될 
	
	static Scanner sc = new Scanner(System.in);
	
	static void BFS(int start) {
		int[] visited = new int[N+1];
		visited[start] = 1;
		que.offer(String.valueOf(start));	// 큐에 시작노드 삽입 
		
		while (que.peek() != null) {	// 큐가 empty될 때까지
			int u = Integer.parseInt(que.poll());	// 큐에 노드를 꺼내어 출력 
			System.out.print(u + " ");
			
			for(int v=1; v<=N ; v++) {
				if(map[u][v] == 1 && visited[v] != 1) {	// 방문한 적 없는 인접한 노드들을 검사하여 인접한 노드들을 다시 큐에 삽입 
					visited[v] = 1;
					que.offer(String.valueOf(v));
				}
			}
		}
	}
	
	static void DFS(int start) {
		visited[start] = 1;		// 시작노드 방문여부 표시 
		System.out.print(start + " ");	// 방문했으면 출력
		for(int v=1; v<=N; v++) {
			if(map[start][v] == 1 && visited[v] != 1) {	// 방문한 적 없는 인접한 노드들을 검사하여 해당 노드에 방문 
				visited[v] = 1;
				DFS(v);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		visited = new int[N+1];
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		DFS(start);
		System.out.println();
		BFS(start);
		
	}

}
