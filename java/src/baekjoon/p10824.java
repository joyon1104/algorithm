package baekjoon;
import java.util.*;

public class p10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] ls = s.split(" ");
		
		String s1 = ls[0]+ls[1];
		String s2 = ls[2]+ls[3];
		
		// Integer.parseInt -> 데이터 초과
		System.out.println(Long.parseLong(s1) + Long.parseLong(s2));
	}
}
