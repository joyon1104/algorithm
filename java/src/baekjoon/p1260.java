package baekjoon;
import java.util.*;

public class p1260 {
	static int[][] arr;
	static int[] visited;
	static int N;
	static int M;
	static int start;
	
	static void DFS(int start) {
		visited[start] = 1;
		System.out.print(start+" ");
		for(int i=1; i<=N; i++) {
			if(arr[start][i] == 1 && visited[i] == 0) {
				DFS(i);
			}
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = 1;
		
		while(!(q.isEmpty())) {
			int temp = q.poll();
			System.out.print(temp+" ");
			
			for(int i=1; i<=N; i++) {
				if(arr[temp][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					q.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		
		DFS(start);
		System.out.println();
		Arrays.fill(visited, 0);
		BFS(start);
	}
}
