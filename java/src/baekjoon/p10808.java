package baekjoon;
import java.util.*;

/* 
 * 문자 -> 숫자
 * char alpa = sc.nextLine().charAt(0);
 * int ialpa = (int)alpa;
 * 
 * 숫자 -> 문자
 * int alpa = sc.nextInt();
 * char calpa = (char)alpa;
 * 
 * 
 */

public class p10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int[] bag = new int[26];

		for(int i=0; i<word.length(); i++) {
			char cc = word.charAt(i);
			int nc = (int)cc - 97;
			bag[nc] += 1;
		}
		
		String s = Arrays.toString(bag);
		String s1=s.replaceAll(",", "").replace("[","").replace("]","");
		System.out.println(s1);
	}
}
