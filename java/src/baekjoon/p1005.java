package baekjoon;
import java.util.*;

public class p1005 {
	static int T,N,K,W;
	static int[] time;
	static int[] indegree;
	static int[] result;
	static ArrayList<ArrayList<Integer>> arrlist;
	
	static void solve() {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				que.offer(i);
				result[i] = time[i];
			}
		}
		
		for(int i=1; i<=N; i++) {
			int x = que.poll();
			for(int j=0; j<arrlist.get(x).size(); j++) {
				int y = arrlist.get(x).get(j);
				result[y] = Math.max(result[y], result[x]+time[y]);
				indegree[y]--;
				if(indegree[y]==0)
					que.offer(y);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			// 초기화 중요!!!
			N = sc.nextInt();
			K = sc.nextInt();
			time = new int[N+1];
			indegree = new int[N+1];
			result = new int[N+1];
			arrlist = new ArrayList<>();
			
			for(int j=0; j<=N; j++)
				arrlist.add(new ArrayList<Integer>());
			
			for(int j=1; j<=N; j++) {
				time[j] = sc.nextInt();
			}
			
			for(int k=0; k<K; k++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arrlist.get(a).add(b);
				indegree[b]++;
			}
			W = sc.nextInt();
			solve();
			System.out.println(result[W]);
		}
	}
}
