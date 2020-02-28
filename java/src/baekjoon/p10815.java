package baekjoon;
import java.util.*;

public class p10815 {
	static int N,M;
	static int[] arr;
	static int[] arr2;
	
	static int check(int find) {
		int start = 0;
		int end = arr.length-1;
		int ans = 0;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid] == find) {
				ans=1;
				break;
			}
			else if(arr[mid] < find)
				start = mid+1;
			else if(arr[mid] > find)
				end = mid-1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		arr2 = new int[M];
		for(int i=0; i<M; i++) {
			arr2[i] = sc.nextInt();
			System.out.print(check(arr2[i]) +" ");
		}
	}
}

