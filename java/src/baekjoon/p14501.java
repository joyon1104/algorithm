package baekjoon;
import java.util.Scanner;


public class p14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N+2];	// �Ⱓ	
		int[] P = new int[N+2];	// ����
		int[] dp = new int[N+2];// �ִ�ݾ�
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=N; i>0; i--) {
			int day = i + T[i];
			if(day <= N+1)	//ex) N�� 7�� �� 7��°�� �Ⱓ�� 1�� ����� 7�� �Ϸ絿�� �� �� �����Ƿ� N+1
				dp[i] = Math.max(dp[day]+P[i], dp[i+1]);	// ex) 5��° ��� + 7��° �ִ� �ݾ� �� (5�ϳ� ������ ���� ��) 6�ϳ� �ִ�ݾ� ������ �ִ밪!
			else
				dp[i] = dp[i+1];
		}
		System.out.println(dp[1]);
	}
}
