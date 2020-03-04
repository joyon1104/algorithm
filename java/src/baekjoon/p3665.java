package baekjoon;
import java.util.*;

public class p3665 {
	static int T;
	static int N,M;
	static int[] rank;
	static ArrayList<ArrayList<Integer>> arrlist;
	static int[] indegree;
	
	static void swap(int a, int b) {
		//a와 b중 더 앞선 순위를 찾는다.
		int prev = 0;
		int next = 0;
		for(int i=1; i<=N; i++) {
			if(rank[i] == a) {
				prev = a;
				next = b;
				break;
			}
			else if(rank[i] == b) {
				prev = b;
				next = a;
				break;
			}
		}
		
		for(int i=0; i<arrlist.get(prev).size(); i++) {
			if(arrlist.get(prev).get(i) == a) {
				arrlist.get(prev).remove(i);
				break;
			}
		}
		indegree[next]--;
		arrlist.get(next).add(prev);
		indegree[prev]++;
	}
	
	static void solve() {
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0)
				que.offer(i);
		}
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(que.size()>1) {
				System.out.println("?");
				return;
			}
			else if(que.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			int x = que.poll();
			result[i] = x;
			
			for(int j=0; j<arrlist.get(x).size(); j++) {
				int y = arrlist.get(x).get(j);
				indegree[y]--;
				if(indegree[y]==0)
					que.offer(y);
			}
		}
		
		for(int i=1; i<=N; i++)
			System.out.print(result[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=0; t<T; t++) {
			N = sc.nextInt();
			rank = new int[N+1];
			indegree = new int[N+1];
			for(int i=1; i<=N; i++)
				rank[i] = sc.nextInt();
			
			//위상정렬
			arrlist = new ArrayList<>();
			for(int i=0; i<=N; i++)
				arrlist.add(new ArrayList<Integer>());
			
			for(int i=1; i<N; i++) {
				int x = rank[i];
				for(int j=i+1; j<=N; j++) {
					int y = rank[j];
					arrlist.get(x).add(y);
					indegree[y]++;
				}
			}
			
			M = sc.nextInt();
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				swap(a,b);
			}
			
			solve();
		}
	}
}
