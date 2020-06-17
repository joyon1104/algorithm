package structure;
import java.util.*;
// 순서 상관없이 5개 숫자 중 3개를 고르는 모든 경우
public class Comb {
	static int k;
	static int n;
	static int res;
	static int[] arr = {1,2,3,4,5};
	
	static void dfs (int idx, int cnt, String str) {
		if(cnt == n) {
			System.out.println(str);
			res++;
		}
		else {
			for(int i=idx+1; i<k; i++) {
				dfs(i, cnt+1, str+arr[i]+" ");
			}
		}
	}
	public static void main(String[] args) {
		k = arr.length;	// k개의 숫자 중에
		n = 3;			// n개 숫자를 고르는 모든 경우
		res = 0;
		String str = "";
		for(int i=0; i<k-(n-1); i++)
			dfs(i,1,str+arr[i]+" ");
		System.out.println(res);
	}
}

