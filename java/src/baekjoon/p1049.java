package baekjoon;
import java.util.*;

public class p1049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] setarr = new int[M];
		int[] arr = new int[M];
		for(int i=0; i<M; i++) {
			setarr[i] = sc.nextInt();
			arr[i] = sc.nextInt();
		}
		Arrays.sort(setarr);
		Arrays.sort(arr);
		
		int set = N/6;
		
		int result = (set*setarr[0] < set*6*arr[0]?set*setarr[0]:set*6*arr[0]);
		if(N%6>0)
			result += (setarr[0] < (N%6)*arr[0] ? setarr[0]:(N%6)*arr[0]);
		System.out.println(result);
	}
}
