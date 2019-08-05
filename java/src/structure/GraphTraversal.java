package structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Graph Traversal (그래프 순회)
 * - 순회 : 그래프의 모든 노드를 방문하는 일
 * - 두가지 방법
 * 	1.BFS (Breadth-First Search, 너비우선순회)
 * 	2.DFS (Depth-First Search, 깊이우선순회)
 */

public class GraphTraversal {
	
	static int N, M;
	static int[][] map;
	static int[] visited;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		map = new int[N+1][N+1];
		visited = new int[N+1];
		
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
	
	//BFS 알고리즘 
	static void BFS(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[N+1];
		visited[start] = 1;
		que.offer(start);
		
		
		while(!(que.isEmpty())) {
			int tmp = que.peek();
			System.out.print(que.poll() + " ");
			for(int i=1; i<= N; i++) {
				if(map[tmp][i] == 1 && visited[i] != 1) {
					visited[i] = 1;
					que.offer(i);
				}
			}	
		}
	}
	
	//DFS 알고리즘 
	static void DFS(int start) {
		visited[start] = 1;
		System.out.print(start + " ");
		for(int i=1; i<=N; i++) {
			if(map[start][i] == 1 && visited[i] != 1) {
				DFS(i);
			}
		}
	}
	
	
}
