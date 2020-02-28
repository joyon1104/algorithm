package baekjoon;
import java.util.*;

public class p1005 {
	static int T,N,K,W;
	static int[] time;
	static ArrayList<ArrayList<Integer>> arrlist;
	static int[] inDegree;
	static int result;
	
	static void sort() {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) {
				que.offer(i);
			}
		}
		
		int max = 0;
		Queue<Integer> tmpque = new LinkedList<Integer>();
		while(!que.isEmpty()) {
			int x = que.poll();
			if(x == W) {
				result += time[x];
				return;
			}
			if(max < time[x])
				max = time[x];
			for(int i=0; i<arrlist.get(x).size(); i++) {
				int y = arrlist.get(x).get(i);
				inDegree[y]--;
				if(inDegree[y] == 0)
					tmpque.offer(y);
			}
			if(que.isEmpty()) {
				result += max;
				max = 0;
				while(!tmpque.isEmpty()) 
					que.add(tmpque.poll());
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			K = sc.nextInt();
			result = 0;
			
			inDegree = new int[N+1];
			time = new int[N+1];
			for(int j=1; j<=N; j++)
				time[j] = sc.nextInt();
			
			arrlist = new ArrayList<ArrayList<Integer>>();
			for(int j=0; j<=N; j++) 
				arrlist.add(new ArrayList<Integer>());
				
			for(int j=0; j<K; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arrlist.get(a).add(b);
				inDegree[b]++;
			}
			W = sc.nextInt();
			
			sort();
			System.out.println(result);
		}
	}
}
