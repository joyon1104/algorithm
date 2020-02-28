package baekjoon;
import java.util.*;

public class p9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			System.out.println(partition(n));
		}
	}
	
	static int partition(int n) {
		if(n==0)
			return 1;
		else if(n<0) 
			return 0;
		else {
			int sum = 0;
			sum = partition(n-1) + partition(n-2) + partition(n-3);
			return sum;
		}
	}
}
