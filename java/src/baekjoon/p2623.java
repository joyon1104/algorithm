package baekjoon;
import java.util.*;

public class p2623 {
	static int N;
	static int M;
	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> arrlist;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		inDegree = new int[N+1];
		arrlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
			arrlist.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			int[] arr = new int[num];
			for(int j=0; j<num; j++) 
				arr[j] = sc.nextInt();
			for(int j=0; j<num-1; j++) {
				arrlist.get(arr[j]).add(arr[j+1]);
				inDegree[arr[j+1]]++;
			}
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		int[] result = new int[N];
		
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0)
				que.add(i);
		}
		
		for(int i=0; i<N; i++) {
			if(que.isEmpty()) {
				System.out.println(0);
				return;
			}
			int x = que.poll();
			result[i] = x;
			for(int j=0; j<arrlist.get(x).size(); j++) {
				int y = arrlist.get(x).get(j);
				if(--inDegree[y] == 0)
					que.add(y);
			}
		}
		for(int i=0; i<N; i++)
			System.out.println(result[i]);
	}
}
