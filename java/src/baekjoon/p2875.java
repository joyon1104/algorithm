package baekjoon;
import java.util.*;

public class p2875 {
	static int N,M,K,max,intern;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		max = Math.min(N/2, M);
		intern = (N-max*2) + (M-max);
		
		while(intern<K) {
			intern += 3;
			max--;
		}
		System.out.println(max);
		
	}
}
