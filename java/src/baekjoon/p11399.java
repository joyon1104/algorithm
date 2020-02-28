package baekjoon;
import java.util.*;

public class p11399 {
	static int N, result;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		result = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				result += arr[j];
			}
		}
		System.out.println(result);
	}
}
