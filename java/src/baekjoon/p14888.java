package baekjoon;
import java.util.*;

public class p14888 {
	static int max,min;
	
	static void dfs( int[]num, int[]com, int[] arr, int cnt) {
		if(cnt == arr.length) {
			int result= num[0];
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == 0) {
					result += num[i+1];
				}
				else if(arr[i] == 1) {
					result -= num[i+1];
				}
				else if(arr[i] == 2) {
					result *= num[i+1];			
				}
				else if(arr[i] == 3) {
					result /= num[i+1];
				}
			}
			
			if(result > max)
				max = result;
			if(result < min)
				min = result;
		}
		else {
			for(int i=0; i<com.length; i++) {
				if(com[i] > 0) {
					arr[cnt] = i;
					com[i]--;
					dfs(num,com,arr,cnt+1);
					com[i]++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		int[] num = new int[N];
		int[] arr = new int[N-1];
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
		
		int[] com = new int[4];
		for(int i=0; i<4; i++)
			com[i] = sc.nextInt();
		
		dfs(num,com, arr, 0);
		System.out.println(max);
		System.out.println(min);
	}
}
