package baekjoon;
import java.util.*;

public class p10819 {
	static int N;
	static int max;
	static int[] arr;
	
	static int compute(int[] result) {
		int sum = 0;
		for(int i=0; i<N-1; i++) {
			int tmp = arr[result[i]]-arr[result[i+1]];
			if(tmp < 0)
				tmp *= -1;
			sum+= tmp;
		}
		return sum;
	}
	
	static void DFS(int[] visited, int[] result, int cnt) {
		if(cnt==N) {
//			System.out.println(Arrays.toString(result));
			int res = compute(result);
			if(max < res)
				max = res;
		}
		else {
			for(int i=0; i<N; i++) {
				if(visited[i]==0) {
					visited[i] = 1;
					result[cnt] = i;
					DFS(visited,result,cnt+1);
					visited[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int[] visited = new int[N];
		int[] result = new int[N];
		DFS(visited,result,0);
		System.out.println(max);
	}
}
