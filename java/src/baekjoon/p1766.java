package baekjoon;
import java.util.*;

public class p1766 {
	static int N,M;
	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> arrlist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		inDegree = new int[N+1];
		arrlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
			arrlist.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arrlist.get(a).add(b);
			inDegree[b]++;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) {
				que.offer(i);
				visited[i] = 1;
				break;		// 쉬운문제부터 탐색해 한개만 큐에 넣는다.
			}
		}
		
		int[] result = new int[N+1];
		for(int i=1; i<=N; i++) {
			int x = que.poll();
			result[i] = x;
			for(int j=0; j<arrlist.get(x).size(); j++){
				int y = arrlist.get(x).get(j);
				inDegree[y]--;		// 이후 진입차수가 0인 모든 문제들 중 쉬운문제부터 큐에 넣어야 하기 때문에 여기서 진입차수를 비교하지 않는다.
			}
			
			// 진입차수가 0인 모든 문제들 중에 쉬운 것부터 탐색해 한개만 집어 넣는다.
			for(int j=1; j<=N; j++) {
				if(inDegree[j] == 0 && visited[j]==0) {
					que.offer(j);
					visited[j] = 1;
					break;
				}
			}
		}
		for(int i=1; i<=N; i++)
			System.out.print(result[i]+" ");
	}
}
