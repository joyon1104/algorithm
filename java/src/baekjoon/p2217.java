package baekjoon;
import java.util.*;

public class p2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[]rope = new int[N];
		for(int i=0; i<N; i++)
			rope[i] = sc.nextInt();
		
		Arrays.sort(rope);
		int max = 0;
		for(int i=N-1; i>=0; i--) {
			int tmp = rope[i] * (N-i);
			if(max < tmp)
				max = tmp;
		}
		System.out.println(max);
	}
}
