package baekjoon;
import java.util.*;

public class p11047 {
	static int N,K;
	static int cnt;
	static int[] coins;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		cnt = 0;
		coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		
		for(int i=N-1; i>=0; i--) {
			if(K>= coins[i]) {
				cnt += K/coins[i];
				K = K%coins[i];
			}
		}
		System.out.println(cnt);
	}
}
