package structure;
import java.util.*;
// ���� ������� 5�� ���� �� 3���� ���� ��� ���
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
		k = arr.length;	// k���� ���� �߿�
		n = 3;			// n�� ���ڸ� ���� ��� ���
		res = 0;
		String str = "";
		for(int i=0; i<k-(n-1); i++)
			dfs(i,1,str+arr[i]+" ");
		System.out.println(res);
	}
}

