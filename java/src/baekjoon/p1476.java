package baekjoon;
import java.util.*;

public class p1476 {
	static int E,S,M;
	static int e,s,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		
		e = 1;
		s = 1;
		m = 1;
		
		int year = 1;
		
		while(true) {
			if(e==E && s==S && m==M) 
				break;
			year++;
			e++;
			s++;
			m++;
			if(e>15) e = 1;
			if(s>28) s = 1;
			if(m>19) m = 1;
		}
		System.out.println(year);
	}
}
