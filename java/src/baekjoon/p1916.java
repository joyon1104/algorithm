package baekjoon;
import java.util.*;

public class p1916 {
	
	static class Pair implements Comparable<Pair>{
		int idx;
		int dist;
		
		public Pair(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		public int compareTo(Pair target) {
			if(this.idx > target.idx)
				return -1;
			else if(this.idx < target.idx)
				return 1;
			else
				return 0;
		}
	}
	
	static int n,m;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[] path = new int[n+1];
		Arrays.fill(path, INF);
		
		ArrayList<ArrayList<Pair>> arrlist = new ArrayList<>();
		for(int i=0; i<=n; i++)
			arrlist.add(new ArrayList<Pair>());
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arrlist.get(a).add(new Pair(b,c));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		path[start] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(start, path[start]));
		
		while(!pq.isEmpty()) {
			Pair current = pq.poll();
			if(current.dist > path[current.idx])
				continue;
			for(Pair p : arrlist.get(current.idx)) {
				if(path[p.idx] > path[current.idx] + p.dist) {
					path[p.idx] = path[current.idx] + p.dist;
					pq.offer(new Pair(p.idx, path[p.idx]));
				}
			}
		}
		
		System.out.println(path[end]);
	}
}
