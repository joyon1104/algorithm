package baekjoon;
import java.util.*;

/*
 * dfs로 풀면 stackoverflow 발생..
 * => bfs로 풀기
 */

public class p1697 {
	static int N,M;
	static int visited[] = new int[100001];
	
	static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(N);
		visited[N] = 1;
		
		while(!que.isEmpty()) {
			int p = que.poll();
			
			if(p==M)
				break;
			
			if(p+1<=100000 && visited[p+1]==0) {
				que.add(p+1);
				visited[p+1] = visited[p]+1;
			}
			if(p-1>=0 && visited[p-1]==0) {
				que.add(p-1);
				visited[p-1] = visited[p]+1;
			}
			if(2*p<=100000 && visited[2*p]==0) {
				que.add(2*p);
				visited[2*p] = visited[p]+1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		bfs();
		System.out.println(visited[M]-1); // 처음 N에서 시작을 0이 아닌 1로 시작해서 -1해줘야함.
	}
}
