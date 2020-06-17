package SWEA;
import java.util.*;

public class p4008 {
	static int max;
	static int min;
	
	public static void solve(int[] arr, int[] num) {
		int res = num[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				res += num[i+1];
			}
			else if(arr[i] == 1) {
				res -= num[i+1];
			}
			else if(arr[i] == 2) {
				res *= num[i+1];
			}
			else if(arr[i] == 3) {
				res /= num[i+1];
			}
		}
		if(res > max)
			max = res;
		if(res < min)
			min = res;
	}
	
	public static void dfs(int[] com, int[] num, int[] arr, int cnt) {
		if(cnt == arr.length) {
			solve(arr,num);
		}
		else {
			for(int i=0; i<com.length; i++) {
				if(com[i] != 0) {
					arr[cnt] = i;
					com[i]--;
					dfs(com,num,arr,cnt+1);
					com[i]++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			max = -100000001;
			min = 100000001;
			int[] com = new int[4];
			for(int i=0; i<4; i++)
				com[i] = sc.nextInt();
			int[] num = new int[N];
			for(int i=0; i<N; i++)
				num[i] = sc.nextInt();
			
			int[] arr = new int[N-1];
			dfs(com,num,arr,0);
			
			int result = max - min;
			System.out.println("#"+t+" "+result);
		}
	}
}
