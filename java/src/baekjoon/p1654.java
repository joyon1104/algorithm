package baekjoon;
import java.util.*;

public class p1654 {
	static int N;
	static int K;
	static int[] lan;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		lan = new int[N];
		
		for(int i=0; i<N; i++)
			lan[i] = sc.nextInt();
		
		Arrays.sort(lan);
		
		long begin = 1;
		long end = lan[N-1];
		
		while(begin<=end) {
			long mid = (begin+end)/2;
			int num = 0;
			for(int i=0; i<N; i++) {
				num += lan[i]/mid;
			}
			if(num >= K)
				begin = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(end);
		
	}
}
