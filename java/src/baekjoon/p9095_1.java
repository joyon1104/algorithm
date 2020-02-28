package baekjoon;
import java.util.*;

/*
 * 재귀 이용
 */

public class p9095_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int cnt = 0;
			for(int p=N/3; p>=0; p--) {
				for(int q=(N-3*p)/2; q>=0; q--)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
