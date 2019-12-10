package baekjoon;
import java.util.Scanner;

public class p2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=2*N-1; i>0; i--) {
			if(i>=N) {
				for(int j=2*N-i; j>0 ;j--) {
					System.out.print("*");
				}
				for(int k=i%N; k>0; k--) {
					System.out.print(" ");
					System.out.print(" ");
				}
				for(int j=2*N-i; j>0 ;j--) {
					System.out.print("*");
				}
			}
			else {
				for(int j=i; j>0 ;j--) {
					System.out.print("*");
				}
				for(int k=N-i; k>0; k--) {
					System.out.print(" ");
					System.out.print(" ");
				}
				for(int j=i; j>0 ;j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
