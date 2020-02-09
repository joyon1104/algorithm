package baekjoon;
import java.util.*;

/*
 * stack으로 풀어야 시간초과가 나지 않는다.
 * Scanner보다 BufferedReader로 풀어야 훨씬 빠름.
 */

public class p1406_X {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = Integer.parseInt(sc.nextLine());
		int pos = s.length();
		for(int i=1; i<=n; i++) {
			String inst = sc.nextLine();
			String[] ls = inst.split(" ");
			if(ls[0].equals("P")) {
				if (pos == s.length())
					s += ls[1];
				else
					s = s.substring(0, pos) + ls[1] + s.substring(pos);
				pos++;
			}
			else if(ls[0].equals("L")) {
				if(pos==0)
					continue;
				pos--;
			}
			else if(ls[0].equals("D")) {
				if(pos==s.length())
					continue;
				pos++;
			}
			else if(ls[0].equals("B")) {
				if(pos==0)
					continue;
				if (pos == s.length())
					s = s.substring(0, pos-1);
				else
					s = s.substring(0, pos-1) + s.substring(pos);
				pos--;
			}
		}
		System.out.println(s);
	}
}
