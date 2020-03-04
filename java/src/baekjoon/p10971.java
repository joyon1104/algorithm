package baekjoon;
import java.util.*;

/*
 * [완전탐색]
 * - dfs로 가능한 경로를 모두 찾은 후 최솟값을 비교해서 가장 적은 비용을 출력한다.
 * !주의할점
 * 1. map[i][j]와 map[j][i]는 다름.
 * 2. map[i][j]==0이라는 의미는 해당 도시로 갈 수 없다는 것.
 * 3. **마지막 도시에서 첫번째 도시로 갈 수 있는지도 꼭 확인해야 함!
 */

public class p10971 {
	static int N;
	static long min;
	static int[] turn;
	static int[] visited;
	static int[][] map;
	
	static int score(int[] turn) {
		int sum = 0;
		for(int i=1; i<=N-1; i++) {
			sum+= map[turn[i]][turn[i+1]];
		}
		sum += map[turn[N]][turn[1]];
		return sum;
	}
	
	static void dfs(int[] turn, int[] visited, int cnt) {
		if(cnt > N) {
			if(map[turn[N]][turn[1]]==0)	// 마지막 도시에서 첫번째 도시로 다시 돌아올 수 없는 경우
				return;
			long tmp = score(turn);
			if(min == -1)	// min이 초기값인 경우 첫번째 구한 비용을 넣어줌.
				min = tmp;
			else if(min > tmp)	// 더 작은 비용을 발견했으면 해당비용을 score에 갱신!
				min = tmp;
		}
		else {
			for(int i=1; i<=N; i++) {
				if(visited[i] == 0) {
					visited[i] = 1;
					turn[cnt] = i;
					if(cnt>1 && map[turn[cnt-1]][turn[cnt]] == 0) {	// i->j로 갈 수 없는 경우
						visited[i] = 0;
						continue;
					}
					dfs(turn, visited, cnt+1);
					visited[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		turn = new int[N+1];
		visited = new int[N+1];
		map = new int[N+1][N+1];
		min = -1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				map[i][j] = sc.nextInt();
		}
		dfs(turn,visited,1);
		System.out.println(min);
	}
}
