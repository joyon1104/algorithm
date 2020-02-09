package baekjoon;
import java.util.*;

public class p9466_1 {
	static int T;
	static int n;
	static int arr[];
	static int visited[];
	static int cycle[];
	
	static int dfs(int idx, int cnt, int start) {
		// 방문한 적 있는 경우
		if(visited[idx] != 0) { // ==1 로 하면 안된다. visited에는 몇번째 지나간 건지에 대한 정보가 담겨있기 때문
			if(start != cycle[idx])  // 시작정점과 같지 않으면 0을 return
				return 0;
			else return cnt-visited[idx]; // 현재 몇번째 방문한건지 - 시작정점이 몇번째로 거쳐간건지
		}
		// 방문한 적 없는 경우
		visited[idx] = cnt;  // 몇번째 방문한건지 저장
		cycle[idx] = start;  // 시작 정점을 입력
		return dfs(arr[idx], cnt+1, start);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			n = sc.nextInt();
			arr = new int[n+1];
			visited = new int[n+1];
			cycle = new int[n+1];
			
			for(int j=1; j<=n; j++)
				arr[j] = sc.nextInt();

			int ans = 0;  // 팀에 속한 사람들 인원
			for(int j=1; j<=n; j++) {
				if(visited[j] == 0)
					ans += dfs(j,1,j);
			}
			System.out.println(n-ans);
			
		}
	}
}
