package baekjoon;
import java.util.*;

public class p11724 {
	static int N;
	static int M;
	static int[][] map;
	static int[] visited;
	static int num;
	
	static void BFS() {
		for(int i=1; i<=N; i++) {
			if(visited[i] == 0) {
				Queue<Integer> que = new LinkedList<Integer>();
				visited[i] = 1;
				que.offer(i);
				num++;
				while(!(que.isEmpty())) {
					int temp = que.poll();
					for(int j=1; j<=N; j++) {
						if(map[temp][j]==1 && visited[j]==0) {
							visited[j]=1;
							que.offer(j);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		visited = new int[N+1];
		num = 0;
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		BFS();
		System.out.println(num);
	}
}
