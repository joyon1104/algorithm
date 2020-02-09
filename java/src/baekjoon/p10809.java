package baekjoon;
import java.util.*;

public class p10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int[] bag = new int[26];
		Arrays.fill(bag, -1);

		for(int i=0; i<word.length(); i++) {
			char cc = word.charAt(i);
			int nc = (int)cc - 97;
			if(bag[nc] == -1)
				bag[nc] = i;
		}
		
		String s = Arrays.toString(bag);
		String s1=s.replaceAll(",", "").replace("[","").replace("]","");
		System.out.println(s1);
	}
}
