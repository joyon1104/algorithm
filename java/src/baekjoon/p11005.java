package baekjoon;
import java.util.*;

public class p11005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		solve(N,B);
		System.out.println();
	}
	
	static void solve(int n, int b) {
		if(n==0) 
			return;
		else {
			solve(n/b,b);
			int temp = n%b;
			
			if(temp>=10) { // 10진법 보다 큰 진법일 경우
				temp += 55;
				System.out.print((char)temp);
			}
			else
				System.out.print(temp);
		}
	}
}
