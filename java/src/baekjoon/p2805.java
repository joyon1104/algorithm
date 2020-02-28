package baekjoon;
import java.util.*;

public class p2805 {
	static int N;
	static long M;
	static long[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		tree = new long[N];
		
		for(int i=0; i<N; i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);
		
		long start = 0;
		long end = tree[N-1];
		long answer = 0;
		
		while(start <= end) {
			long mid = (start+end)/2;
			int total = 0;
			for(int i=0; i<N; i++) {
				if(tree[i] >= mid) {
					total += tree[i] - mid;
				}
			}
			
			if(total >= M) {
				if(answer<mid)
					answer = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
