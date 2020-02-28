package baekjoon;
import java.util.*;

public class p2252 {
	static int N,M;
	static ArrayList<ArrayList<Integer>> arrlist;
	static int[] result;
	static int[] inDegree;
	
	static void sort() {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0)
				que.offer(i);
		}
		
		for(int i=1; i<=N; i++) {
			if(que.isEmpty())
				return;
			int x = que.poll();
			result[i] = x;
			for(int j=0; j<arrlist.get(x).size(); j++) {
				int y = arrlist.get(x).get(j);
				inDegree[y]--;
				if(inDegree[y]==0)
					que.offer(y);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arrlist = new ArrayList<ArrayList<Integer>>();
		result = new int[N+1];
		inDegree = new int[N+1];
		
		for(int i=0; i<=N; i++) 
			arrlist.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arrlist.get(a).add(b);
			inDegree[b]++;
		}
		
		sort();
		for(int i=1;i<=N; i++) {
			System.out.print(result[i]+" ");
		}
	}
}