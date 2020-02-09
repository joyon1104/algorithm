package baekjoon;
import java.util.*;

public class p2331 {
	static int A;
	static int P;
	static ArrayList<Integer> arrlist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		arrlist = new ArrayList<Integer>();
		
		int res = 0;
		int temp = A;
		arrlist.add(temp);
		while(true) {
			int next = 0;
			String s = String.valueOf(temp);
			for(int i=0; i<s.length(); i++) {
				int n = Integer.parseInt(s.substring(i,i+1));
				next += (int)Math.pow(n, P); //float,double -> int
			}
			temp = next;
			if(arrlist.contains(temp)) {
				res = arrlist.indexOf(temp);
				break;
			}
			arrlist.add(temp);
		}
		System.out.println(res);
	}
	
	
}
