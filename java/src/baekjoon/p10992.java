package baekjoon;
import java.util.*;

public class p10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=N-1; i>=0; i--) {
			if(i==0) {
				for(int j=1; j<=2*N-1; j++) {
					System.out.print("*");
				}
			}
			else{
				for(int j=1; j<=2*N-1-i; j++) {
					if(j==2*N-1-i || j == i+1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
