package baekjoon;
import java.util.*;


public class p2665_O {
	static int min = 2500;
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
		int n = Integer.parseInt(N);
		int[][] room = new int[n][n];
		int[][] visited = new int[n][n];

		
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			String[] arr;
			arr = str.split("");
			for (int j=0; j<n; j++) {
				room[i][j] = Integer.parseInt(arr[j]);
				visited[i][j] = 2500;
			}
		}
		
		
		Queue<Pair> que = new LinkedList<Pair>();
		Pair p = new Pair(0,0);
		visited[0][0] = 0;
		que.add(p);
		
		while(!(que.isEmpty())) {
			Pair tmp = que.poll();
			for(int k=0; k<4; k++) {
				int next_i = tmp.i + move[k][0];
				int next_j = tmp.j + move[k][1];
				
				if(next_i<0 || next_j<0 || next_i >=n || next_j >=n)
					continue;
				
				if(visited[next_i][next_j] <= visited[tmp.i][tmp.j])
					continue;
				
				if(room[next_i][next_j] == 0)
					visited[next_i][next_j] = visited[tmp.i][tmp.j]+1;
				else
					visited[next_i][next_j] = visited[tmp.i][tmp.j];
				
				Pair next_p = new Pair(next_i,next_j);
				que.add(next_p);
			}
		}
		
		System.out.println(visited[n-1][n-1]);
	}
}
