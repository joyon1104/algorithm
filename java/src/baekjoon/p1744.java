package baekjoon;
import java.util.*;

public class p1744 {
	static int N,max;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		max = 0;
		
		// 음수  -> 1보다 낮은 두 수를 곱하면 항상 최대
		for(; left<right; left+=2) {
			if(arr[left] < 1 && arr[left+1] < 1) {
				max += arr[left] * arr[left+1];
			}
			else break;
		}
		
		// 양수 -> 1보다 큰 두수를 곱하면 항상 최대
		for(; right>0; right -=2) {
			if(arr[right] > 1 && arr[right-1]>1) {
				max += arr[right] * arr[right-1];
			}
			else break;
		}
		
		for(; right >=left; right--) {
			max += arr[right];
		}
		
		System.out.println(max);
	}
}
