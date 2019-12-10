package baekjoon;
import java.util.*;

public class p1260_2 {
	
	static void DFS(int[][] map, int[] visited, int[] result, int start, int n) {
		System.out.print(result[n] + " ");
		n++;
		for(int j=1; j<result.length; j++) {
			if(map[start][j] == 1 && visited[j] == 0) {
				result[n] = j;
				visited[j] = 1;
				DFS(map,visited,result,j, n);
			}
		}
	}
	
	static void BFS(int[][] map, int[]visited, int[] result, int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		int n=2;
		
		while(!(que.isEmpty())) {
			int q = que.poll();
			for(int i=1; i<result.length; i++) {
				if(map[q][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					result[n++] = i;
					que.add(i);
				}
			}
		}
		
		for(int i=1; i<result.length; i++) {
			if(result[i] == 0)
				break;
			System.out.print(result[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		
		for(int m=1; m<=M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			map[i][j] = 1;
			map[j][i] = 1;
		}
		
		int[] visited = new int[N+1];
		int[] result = new int[N+1];
		visited[V] = 1;
		result[1] = V;
		
		DFS(map,visited,result,V,1);
		System.out.println();
		
		visited = new int[N+1];
		result = new int[N+1];
		visited[V] = 1;
		result[1] = V;
		BFS(map,visited,result,V);
	}

}
