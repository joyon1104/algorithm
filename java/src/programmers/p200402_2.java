package programmers;
import java.util.*;

public class p200402_2 {
	static void dfs(int[] arr,String str,int idx, int cnt) {
		if(cnt == 6)
			System.out.println(str);
		else {
			for(int i=idx+1; i<arr.length; i++) {
				dfs(arr,str+arr[i]+" ",i,cnt+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int k = sc.nextInt();
			if(k==0)
				break;
			int[] arr = new int[k];
			for(int i=0; i<k; i++)
				arr[i] = sc.nextInt();
			
			String str = "";
			for(int i=0; i<k-5; i++)
				dfs(arr,str+arr[i]+" ",i,1);
			System.out.println();
		}
	}

}
