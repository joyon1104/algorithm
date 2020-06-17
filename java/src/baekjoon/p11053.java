package baekjoon;
import java.util.*;

/*
 * [���� �� �����ϴ� �κ� ���� ]
 * - �ð����⵵ : N^2 (1000*1000)
 * 
 */
public class p11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]arr = new int[n+1];
		int[]dp = new int[n+1];
		
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i] && dp[j]+1>dp[i]) // 1~i-1���� ���鼭 A[j] < A[i]�� �����ϴ� dp �� �� �ִ밪 + 1�� ��.
					dp[i] = dp[j]+1;
			}
		}
		
		//dp�迭 �� �ִ밪�� ����
		int ans = dp[0];
        for (int i=0; i<=n; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
		
		System.out.println(ans);
	}
}
