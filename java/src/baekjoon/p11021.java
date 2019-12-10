package baekjoon;
import java.util.Scanner;

public class p11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result = A+B;
			System.out.println("Case #"+ t+": "+result);
		}
		
	}
}
