package baekjoon;
import java.util.*;

public class p11655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String res = "";
		
		for(int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			int tmp = 0;
			if((int)c >=65 && (int)c <= 90) {
				tmp = (int)c + 13;
				if(tmp > 90) {
					tmp = tmp%91 + 65;
				}
			}
			else if((int)c >= 97 && (int)c <= 122) {
				tmp = (int)c + 13;
				if(tmp > 122) {
					tmp = tmp%123 + 97;
				}
			}
			else
				tmp = (int)c;
			res += (char)tmp;
		}
		System.out.println(res);
	}
}
