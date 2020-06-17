package baekjoon;
import java.util.*;

public class p5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int charge = 1000-N;
		int cnt = 0;
		int[] money = {500,100,50,10,5,1};
		for(int i=0; i<6; i++) {
			cnt += charge/money[i];
			charge = charge%money[i];
		}
		System.out.println(cnt);
	}
}
