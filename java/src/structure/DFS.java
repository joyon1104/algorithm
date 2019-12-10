package structure;

import java.util.*;

public class DFS {

	static int[] arr = {1,2,3};
	static int[] visited = new int[3];
	static int[] result = new int[3];
	
	static void dfs(int[]arr, int[]visited, int[] result, int n) {
		if(n==arr.length) {
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i]);
			}
		System.out.println();
		}
//		
//		// 3개 중복없이 고르는 모든 경우의 수
//		else { 
//			for(int i=0; i<arr.length; i++) {
//				if(visited[i] == 0) {
//					visited[i] = 1;
//					result[n] = arr[i];
//					dfs(arr,visited,result, n+1);
//					visited[i] = 0;
//				}
//			}
//		}
//		
//		// 중복해서 3개 고르는 모든 경우의 수
//		else {
//			for(int i=0 ;i<arr.length; i++) {
//				result[n] = arr[i];
//				dfs(arr,visited, result, n+1);
//			}
//		}
	}
	
	public static void main(String[] args) {
	
//		System.out.println("a");
		//모든 경우의 수 나열
		dfs(arr,visited,result,0);
	}

}


