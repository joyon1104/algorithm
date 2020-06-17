package baekjoon;
import java.util.*;

public class p1197 {

	static class Pair implements Comparable<Pair>{
		int a;
		int b;
		int c;
		
		public Pair(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Pair target) {
			if(this.c < target.c)
				return -1;
			else if(this.c > target.c)
				return 1;
			return 0;
		}
	}
	
	static int getParent(int[]parents, int n) {
		if(parents[n] == n)
			return n;
		else
			return getParent(parents,parents[n]);
	}
	
	static void unionParent(int[]parents, int a, int b) {
		a = getParent(parents,a);
		b = getParent(parents,b);
		
		if(a<b)
			parents[b] = a;
		else
			parents[a] = b;
	}
	
	static boolean isSameParent(int[]parents, int a, int b) {
		if(getParent(parents,a) == getParent(parents,b))
			return true;
		else
			return false;
	}
	
	static int v,e;
	static PriorityQueue<Pair> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		pq = new PriorityQueue<>();
		int[] parents = new int[v+1];
		
		for(int i=1; i<=v; i++)
			parents[i] = i;
		
		for(int i=0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			pq.add(new Pair(a,b,c));
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Pair tmp = pq.poll();
			if(!isSameParent(parents,tmp.a, tmp.b)) {
				unionParent(parents, tmp.a, tmp.b);
				answer += tmp.c;
			}
		}
		System.out.println(answer);
	}
}
