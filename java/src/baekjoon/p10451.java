package baekjoon;
import java.util.*;

public class p10451 {
	static int T;
	static int N;
	static int res;
	static int[] arr;
	
	static void BFS() {
		int[] visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			Queue<Integer> que = new LinkedList<Integer>();
			if(visited[i]== 0) {
				que.offer(i);
				int base = 0;
				while(!(que.isEmpty())) {
					int temp = que.poll();
					visited[temp] = 1;
					if (base == 0) base = temp;
					if(arr[temp] == base) {
						res++;
						break;
					}
					else {
						que.offer(arr[temp]);
					}
				}
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			res = 0;
			arr = new int[N+1];
			for(int j=1; j<=N; j++) {
				int temp = sc.nextInt();
				arr[j] = temp;
			}
			BFS();
		}
		
		
	}
}
